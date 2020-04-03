package com.laptrinhjavaweb.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;

public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom {

	@PersistenceContext 
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<RentAreaEntity> findByBuildingId(Long id) {
		String sql="";
		if(id!=null) {
			 sql="select * from rentarea where building="+id+"";
		}
		Query query=entityManager.createNativeQuery(sql, RentAreaEntity.class);
		return query.getResultList();
	}
	@Override
	public void deleteBuilding(Long id) {
		String sql="delete from rentarea where building="+id+"";
		entityManager.createNativeQuery(sql).executeUpdate();
	}

}
