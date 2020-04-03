package com.laptrinhjavaweb.repository.custom.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findStaff() {
		String sql="select * from user a inner join  user_role b on a.id=b.userid where b.roleid=2";
		Query query=entityManager.createNativeQuery(sql, UserEntity.class);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findAll(Map<String, Object> params, Pageable pageable,
			UserSearchBuilder userSearchBuilder) {
		StringBuilder sqlSearch = new StringBuilder("Select * FROM user A ");
		sqlSearch.append(" INNER JOIN user_role  B ON A.id=B.userid ");
		sqlSearch.append(" INNER JOIN role  C ON C.id=B.roleid ");
		sqlSearch.append(" WHERE 1=1 ");
		sqlSearch = this.CreateSQLfindAll(sqlSearch, params);
		Query query= entityManager.createNativeQuery(sqlSearch.toString(),UserEntity.class);
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

				if ((value[i1] instanceof String) && (StringUtils.isNoneBlank(value[i1].toString()))) {
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
}
