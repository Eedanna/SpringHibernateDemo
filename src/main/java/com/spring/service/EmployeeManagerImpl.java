package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDAO;
import com.spring.entity.EmployeeEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeManagerImpl.
 */
@Service
public class EmployeeManagerImpl implements EmployeeManager {

	/** The employee dao. */
	@Autowired
    private EmployeeDAO employeeDAO;

	/* (non-Javadoc)
	 * @see com.spring.service.EmployeeManager#addEmployee(com.spring.entity.EmployeeEntity)
	 */
	@Override
	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		employeeDAO.addEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.spring.service.EmployeeManager#getAllEmployees()
	 */
	@Override
	@Transactional
	public List<EmployeeEntity> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	/* (non-Javadoc)
	 * @see com.spring.service.EmployeeManager#deleteEmployee(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	/**
	 * Sets the employee dao.
	 *
	 * @param employeeDAO the new employee dao
	 */
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
