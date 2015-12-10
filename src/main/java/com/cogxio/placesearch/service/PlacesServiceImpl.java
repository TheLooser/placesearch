package com.cogxio.placesearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cogxio.placesearch.dao.PlacesDao;
import com.cogxio.placesearch.domain.Places;

@Service
@Transactional
public class PlacesServiceImpl implements PlacesService {

	@Autowired
	private PlacesDao placesDao;

	@Override
	public List<Places> getAllPlaces() throws Exception {
		return placesDao.getAllPlaces();
	}

	@Override
	public List<Places> getSearchResult(String query) throws Exception {
		return placesDao.getSearchResult(query);
	}
}
