package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.EmployeeDao;
import com.jsp.dto.Employee;

@Component
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	public Employee saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}
	public Employee deleteEmployee(Employee employee) {
		return dao.deleteEmployee(employee);
	}
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}
	public Employee getById(int id) {
		return dao.getById(id);
	}

}
