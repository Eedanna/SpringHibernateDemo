package com.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.EmployeeEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDaoImpl.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDAO  {

	/** The session factory. */
	@Autowired
    private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.spring.dao.EmployeeDAO#addEmployee(com.spring.entity.EmployeeEntity)
	 */
	@Override
	public void addEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	/* (non-Javadoc)
	 * @see com.spring.dao.EmployeeDAO#getAllEmployees()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	/* (non-Javadoc)
	 * @see com.spring.dao.EmployeeDAO#deleteEmployee(java.lang.Integer)
	 */
	@Override
	public void deleteEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
				EmployeeEntity.class, employeeId);
        if (null != employee) {
        	this.sessionFactory.getCurrentSession().delete(employee);
        }
	}



}
