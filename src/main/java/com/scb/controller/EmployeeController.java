package com.scb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scb.model.Employee;
import com.scb.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired(required = true)
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService es) {
		this.employeeService = es;
	}

	@RequestMapping(value = "/employes", method = RequestMethod.GET)
	public String listemployes(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployes", this.employeeService.listEmployes());
		return "employee";
	}

	// For add and update employee both
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee e) {

		if (e.getId() == 0) {
			// new employee, add it
			this.employeeService.addEmployee(e);
		} else {
			// existing employee, call update
			this.employeeService.updateEmployee(e);
		}

		return "redirect:/employes";

	}

	@RequestMapping("/remove/{id}")
	public String removeEmployee(@PathVariable("id") int id) {

		this.employeeService.removeEmployee(id);
		return "redirect:/employes";
	}

	@RequestMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("listEmployes", this.employeeService.listEmployes());
		return "employee";
	}

}
