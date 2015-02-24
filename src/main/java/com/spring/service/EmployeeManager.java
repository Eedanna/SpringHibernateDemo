package com.spring.service;

import java.util.List;

import com.spring.entity.EmployeeEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeManager.
 */
public interface EmployeeManager {
	
	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 */
	public void addEmployee(EmployeeEntity employee);
    
    /**
     * Gets the all employees.
     *
     * @return the all employees
     */
    public List<EmployeeEntity> getAllEmployees();
    
    /**
     * Delete employee.
     *
     * @param employeeId the employee id
     */
    public void deleteEmployee(Integer employeeId);
}
