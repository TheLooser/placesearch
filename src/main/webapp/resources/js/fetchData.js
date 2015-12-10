/***
 * this function is use for getting data by search parameter.
 * this data pass by ajax and show without page refreshment
 */
function getData() {

	var query = $('#search').val();
	if(query=="")
		{
		$("#countrecord").html("No Record Found")
		$('#search').focus();
		return; 
		}
	$
			.ajax({
				url : "getdata/" + query,
				type : "POST",
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					//alert(data.length);
					$('#datashow').html("");
					var record = '';
					
					$("#countrecord").html(data.length+" Record Found")
					$(data)
							.each(
									function(item, index) {
										//alert(index.rating);
										record += '<div class="row" style="margin-top:2%">';
										record += '<div class="col-xs-2"></div>';
										record += '<div class="col-xs-8 box">';
										record += '<strong style="font-size:24px">Place Name:'
												+ index.name + '</strong>';
										record += '<div class="rating" style="float:right">Rating:&nbsp;';
										for (var i = 1; i <= Math.ceil(index.rating); i++) {
											record += '<span class="glyphicon glyphicon-star"></span>'
										}
										
										record += '</div><br><h6>Category : '
												+ index.category + '</h6>';
										record += '<button class="btn btn-xs btn-warning loction-btn" onclick=pan('+index.latitude+","+index.longitude+')><i class="glyphicon glyphicon-map-marker"></i>&nbsp; Map Location</button>';
										record += '</div><div class="col-xs-2"></div></div>';
									});

					$('#datashow').append(record);
					record='';

				},
				error : function(event) {
					console.log(event.responseText);
					alert(event.responseText);
				}
			});

}
/***
 * Map Initialize and pass data latitude and longitude as per location of places to show correct place with marker 
 */



var map;
var panPoint;
var marker;
var i=0;

function initialize() {
	var myLatlng = new google.maps.LatLng(23.032120, 72.552254);
	var myOptions = {
		zoom : 15,
		center : myLatlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP

	}

	map = new google.maps.Map(document.getElementById("map"),
			myOptions);
	addMarker(myLatlng, 'Location', map);
i++;

	//google.maps.event.addListener(map,'click',function(event) {   addMarker(event.latLng, 'Click Generated Marker', map); }    );
}

function pan(valuelat, valuelong) {
	if(i==0)
		{initialize();}
	

	if(valuelat=="" || valuelong=="")
	{
	
	valuelat=23.0284781;
	valuelong=72.5464677;
	}	

	
	panPoint = new google.maps.LatLng(valuelat, valuelong);
	map.panTo(panPoint);
	marker.setMap(null);
	addMarker(panPoint, 'Location', map);
	$('#light1').modal('show');
	 document.getElementById("light1").style.display = "table-row";
}

function addMarker(latlng, title, map) {

	marker = new google.maps.Marker({
		position : latlng,
		map : map,
		title : title,
		draggable : false
	});
}
