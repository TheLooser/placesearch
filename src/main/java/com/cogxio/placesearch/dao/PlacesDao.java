package com.cogxio.placesearch.dao;

import java.util.List;

import com.cogxio.placesearch.domain.Places;

public interface PlacesDao {
	public List<Places> getAllPlaces() throws Exception;

	public List<Places> getSearchResult(String query) throws Exception;
}
