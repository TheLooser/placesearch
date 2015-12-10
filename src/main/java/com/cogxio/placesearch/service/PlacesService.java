package com.cogxio.placesearch.service;

import java.util.List;

import com.cogxio.placesearch.domain.Places;

public interface PlacesService {

	public List<Places> getAllPlaces() throws Exception;

	public List<Places> getSearchResult(String query) throws Exception;
}
