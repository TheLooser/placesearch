package com.cogxio.placesearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cogxio.placesearch.domain.Places;
import com.cogxio.placesearch.service.PlacesService;

@Controller
@ControllerAdvice
public class SearchController {

	/***
	 * this is called for Home Page 
	 */
	@Autowired
	private PlacesService placeService;

	@RequestMapping("/")
	public ModelAndView Home() {
		return new ModelAndView("index");

	}
/***
 * 
 * @param String For Search place
 * @return List of Place Object 
 * @throws Exception if blank passed
 */
	@RequestMapping(value = "getdata/{query}")
	@ResponseBody
	public List<Places> saveAppointmentStatus(
			@PathVariable(value = "query") String query) throws Exception {
		try {
			
			return placeService.getSearchResult(query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
