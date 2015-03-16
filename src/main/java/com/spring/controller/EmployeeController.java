package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.entity.EmployeeEntity;
import com.spring.service.EmployeeManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EditEmployeeController.
 * 
 * @author Eedanna
 */

@Controller
public class EmployeeController {

	/** The employee manager. */
	@Autowired
	private EmployeeManager employeeManager;

	/**
	 * Sets the employee manager.
	 * 
	 * @param employeeManager
	 *            the new employee manager
	 */
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	/**
	 * Default page.
	 * 
	 * @param map
	 *            the map
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/list";
	}

	/**
	 * List employees.
	 * 
	 * @param map
	 *            the map
	 * @return the string
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {

		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployees());

		return "editEmployeeList";
	}

	/**
	 * Adds the employee.
	 * 
	 * @param employee
	 *            the employee
	 * @param result
	 *            the result
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(
			@ModelAttribute(value = "employee") EmployeeEntity employee,
			BindingResult result) {
		employeeManager.addEmployee(employee);
		return "redirect:/list";
	}

	/**
	 * Delete emplyee.
	 * 
	 * @param employeeId
	 *            the employee id
	 * @return the string
	 */
	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
		employeeManager.deleteEmployee(employeeId);
		return "redirect:/list";
	}

	/**
	 * Login.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	/**
	 * Loginerror.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	/**
	 * Logout.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
}
