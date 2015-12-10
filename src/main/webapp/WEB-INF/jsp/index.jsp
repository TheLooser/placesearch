<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Search Places </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script
	src="${pageContext.request.contextPath}/resources/js/fetchData.js"
	type="text/javascript"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true">
	
	</script>
	

<style>
.box {
	box-shadow: rgb(153, 153, 153) 0px 5px 9px;
	border: 1px solid #c2d5d9;
}

.rating .glyphicon {
	font-size: 17px;
	color: #f0ad4e;
}

.loction-btn {
	float: right;
	margin-bottom: 10px;
}

.glyphicon-star{
top:3px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="col-xs-12" style="margin-top: 5%">
			<div class="col-xs-3"></div>
			<div class="col-xs-5">
				<input class="form-control" placeholder="Search Places" type="text"
					id="search" required="required">
			</div>
			<div class="col-xs-1">
				<button class="btn btn-warning" onclick="getData();">
					<i class="glyphicon glyphicon-search"></i>&nbsp; Search
				</button>
			</div>
			<div class="col-xs-3"></div>
		</div>
		<div class="col-xs-12" style="margin-top: 5%">
			<div class="col-xs-5"></div>
			<div class="col-xs-5">
			<label id="countrecord"></label>
			</div>
			<div class="col-xs-5"></div>
		</div>
		
		
		
		
		
		
		
		
		<div id="datashow" class="col-xs-12"></div>
		<div class="modal fade" id="light1" role="dialog">
			<div class="modal-dialog modal-lg">

				<div class="modal-content">
					<div class="modal-header btn-warning">
						<button type="button" class="close" data-dismiss="modal"
							style="width: auto;">&times;</button>
						<h4 class="modal-title">Place Location</h4>
					</div>
					<div class="modal-body">
						<div id="map"
							style="height: 400px; width: 100%; border-radius: 5px; margin-top: 0px;">
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
