package com.laptrinhjavaweb.repository.custom.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params,Pageable pageable,
			BuildingSeachBuilder fieldSearch) {
		StringBuilder sqlSearch = new StringBuilder("Select * FROM building A ");
		if(StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			sqlSearch.append(" INNER JOIN assignmentstaff  assignmentstaff ON A.id=assignmentstaff.buildingid "
					+ "INNER JOIN user user ON user.id=assignmentstaff.staffid ");
		}else if(StringUtils.isNotBlank(fieldSearch.getStaffName())) {
			sqlSearch.append(" INNER JOIN assignmentstaff  assignmentstaff ON A.id=assignmentstaff.buildingid "
					+ "INNER JOIN user user ON user.id=assignmentstaff.staffid ");
		}
		
		sqlSearch.append(" WHERE 1=1 ");
		sqlSearch = this.CreateSQLfindAll(sqlSearch, params);
		String sqlSpecial = buildSqlSpecial(fieldSearch);
		sqlSearch.append(sqlSpecial);
		Query query= entityManager.createNativeQuery(sqlSearch.toString(),BuildingEntity.class);
		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		
		return query.getResultList();
	}

	private StringBuilder CreateSQLfindAll(StringBuilder where, Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			String[] keys = new String[params.size()];
			Object[] value = new Object[params.size()];
			int i = 0;
			for (Map.Entry<String, Object> item : params.entrySet()) {
				keys[i] = item.getKey();
				value[i] = item.getValue();
				i++;
			}

			for (int i1 = 0; i1 < keys.length; i1++) {

				if ((value[i1] instanceof String) && (StringUtils.isNoneBlank(value[i1].toString())) && value[i1].equals("staffName")) {
					where.append(" AND LOWER(A." + keys[i1] + ") LIKE '%" + value[i1].toString() + "%' ");
				}
				if ((value[i1] instanceof Integer) && (value[i1] != null)) {
					where.append(" AND LOWER(A." + keys[i1] + ") =" + value[i1] + " ");

				}
				if ((value[i1] instanceof Long) && (value[i1] != null)) {
					where.append(" AND LOWER(A." + keys[i1] + ") =" + value[i1] + " ");

				}
			}
		}
		return where;
	}
	private String buildSqlSpecial(BuildingSeachBuilder fieldSearch) {
		StringBuilder result = new StringBuilder("");
		if (StringUtils.isNotBlank(fieldSearch.getCostRentFrom())) {
			result.append(" AND A.costrent >= " + fieldSearch.getCostRentFrom() + "");
		}
		if (StringUtils.isNotBlank(fieldSearch.getCostRentTo())) {
			result.append(" AND A.costrent <= " + fieldSearch.getCostRentTo() + "");
		}
		if (fieldSearch.getBuildingTypes().length > 0) {
			result.append(" AND (");
			// JAVA 7
			// int i=0;
			// for(String item:fieldSearch.getBuildingTypes()) {
			//
			// if(i==0) {
			// result.append(" A.type like '%"+item+"%'");
			// }else {
			// result.append(" OR A.type l5ike '%"+item+"%'");
			// }
			// i++;
			// }
			// java 8
			result.append(" A.type like '%" + fieldSearch.getBuildingTypes()[0] + "%'");
			Arrays.stream(fieldSearch.getBuildingTypes())
					.filter((item -> !item.equals(fieldSearch.getBuildingTypes()[0])))
					.forEach(item -> result.append(" OR  A.type like '%" + item + "%'"));
			result.append(" )");
		}
		if (StringUtils.isNotBlank(fieldSearch.getAreaRentFrom())
				|| StringUtils.isNotBlank(fieldSearch.getAreaRentTo())) {
			result.append(" AND EXIST (SELECT * FROM rentarea ra WHERE (ra.buildingid = A.id");
			if (fieldSearch.getAreaRentFrom() != null) {
				result.append(" AND ra.value >= " + fieldSearch.getAreaRentFrom() + "");
			}
			if (fieldSearch.getAreaRentTo() != null) {
				result.append("  AND ra.value <=" + fieldSearch.getAreaRentTo() + "");
			}
			result.append(" ))");
		}
		if(StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			result.append(" AND assignmentstaff.staffid ="+fieldSearch.getStaffId()+"");
		}
		if(StringUtils.isNotBlank(fieldSearch.getStaffName())) {
			result.append(" AND LOWER(user.username) LIKE '"+fieldSearch.getStaffName()+"' ");
		}
		return result.toString();
	}
	

	


}
