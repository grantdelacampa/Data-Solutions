/*
 * Grant De La Campa
 * 2021
 * employeeController: Controller for various pages and functions relating to the employee model
 */
package com.myproject.datasolutions.employee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class employeeController {
	
	@Autowired
	private EmployeeService service;
	
	//Map to the employee page
	@RequestMapping("/employee")
	public String viewHomePage(Model model) {
		List<Employee> listEmployees = service.listAll();
		model.addAttribute("listEmployees", listEmployees);
		return "employee";
	}
	
	// New employee feature
	@RequestMapping("/employee/new")
	public String showNewEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "new_employee";
	}
	
	// Edit employee feature
	@RequestMapping("/employee/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable("id") int id) {
	    ModelAndView mav = new ModelAndView("edit_employee");
	    Employee employee = service.get(id);
	    mav.addObject("employee", employee);     
	    return mav;
	}
	
	@RequestMapping(value = "employee/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		
		// redirect back to the employee page
		return "redirect:/employee";
	}
	
	@RequestMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		service.delete(id);
		
		//redirect back to the employees
		return "redirect:/employee";
	}
	
}
