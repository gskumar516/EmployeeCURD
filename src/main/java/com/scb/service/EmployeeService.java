package com.scb.service;

import java.util.List;

import com.scb.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public List<Employee> listEmployes();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
	
}
