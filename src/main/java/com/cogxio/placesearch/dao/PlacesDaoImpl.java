package com.cogxio.placesearch.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cogxio.placesearch.domain.Places;

@Repository
@Transactional
public class PlacesDaoImpl implements PlacesDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getAllPlaces() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(Places.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getSearchResult(String query) throws Exception {
		if(query.equals(""))
		{
			return getAllPlaces();
		}
		return sessionFactory
				.getCurrentSession()
				.createCriteria(Places.class)
				.add(Restrictions.or(Restrictions.ilike("name", query,
						MatchMode.ANYWHERE), Restrictions.ilike("category",
						query, MatchMode.ANYWHERE))).list();
	}

}
