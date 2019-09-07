package com.scb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scb.dao.EmployeeDAO;
import com.scb.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		this.employeeDAO.addEmployee(e);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		this.employeeDAO.updateEmployee(e);
	}

	@Override
	@Transactional
	public List<Employee> listEmployes() {
		return this.employeeDAO.listEmployes();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeeDAO.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		this.employeeDAO.removeEmployee(id);
	}

}
