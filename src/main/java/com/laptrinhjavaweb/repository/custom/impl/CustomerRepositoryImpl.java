package com.laptrinhjavaweb.repository.custom.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerEntity> findAll(Map<String, Object> params, Pageable pageable,
			CustomerSearchBuilder customerSearchBuilder) {
		StringBuilder sqlSearch = new StringBuilder("Select * FROM customer A  ");
		sqlSearch.append(" INNER JOIN assignmentcustomer B ON A.id=B.customerid ");
		sqlSearch.append(" WHERE 1=1 ");
		sqlSearch = this.CreateSQLfindAll(sqlSearch, params);
		String sqlSpecial = buildSqlSpecial(customerSearchBuilder);
		sqlSearch.append(sqlSpecial);
		Query query= entityManager.createNativeQuery(sqlSearch.toString(),CustomerEntity.class);
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

				if ((value[i1] instanceof String) && (StringUtils.isNoneBlank(value[i1].toString())) && value[i1].equals("staffId")) {
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
	private String buildSqlSpecial(CustomerSearchBuilder customerSearchBuilder) {
		StringBuilder result = new StringBuilder("");
		if(StringUtils.isNotBlank(customerSearchBuilder.getStaffId())) {
			result.append(" AND B.staffid ="+customerSearchBuilder.getStaffId()+"");
		}
		return result.toString();
	}
}
