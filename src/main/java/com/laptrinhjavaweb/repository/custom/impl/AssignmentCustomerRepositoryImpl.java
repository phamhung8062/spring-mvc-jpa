package com.laptrinhjavaweb.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.laptrinhjavaweb.repository.custom.AssignmentCustomerRepositoryCustom;

public class AssignmentCustomerRepositoryImpl  implements AssignmentCustomerRepositoryCustom{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void deleteBuilding(Long id) {
		//String sql="DELETE FROM building ";
		
	}

	@Override
	public void deleteUser(Long id) {
		//String sql="DELETE FROM user";
		
	}
   
	@Override
	@Transactional
	public void deleteCustomer(Long id) {
		String sql="DELETE FROM assignmentcustomer WHERE customerid="+id+" ";
		entityManager.createNativeQuery(sql).executeUpdate();
	}

	

}
