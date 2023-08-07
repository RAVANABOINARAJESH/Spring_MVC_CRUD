package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotation.Adapt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Employee;
import com.jsp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/load")
	public ModelAndView load() {
		ModelAndView andView = new ModelAndView("createEmployee.jsp");
		andView.addObject("emp", new Employee());
		return andView;
	}

	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		ModelAndView andView = new ModelAndView("home.jsp");

		return andView;
	}

	@RequestMapping("/getall")
	public ModelAndView getAllEmployee() {
		List<Employee> list = employeeService.getAllEmployee();
		if (list.size() > 0) {
			ModelAndView andView = new ModelAndView("getall.jsp");
			andView.addObject("list", list);
			return andView;
		} else {
			ModelAndView andView = new ModelAndView("home.jsp");
			andView.addObject("msg", "Add the data");
			return andView;
		}
	}

	@RequestMapping("/getbyid")
	public ModelAndView getById(@RequestParam int id) {
		Employee employee = employeeService.getById(id);
		ModelAndView andView = new ModelAndView("update.jsp");
		andView.addObject("list", employee);
		return andView;

	}
	@RequestMapping("/updateemployee")
	public ModelAndView updateEmployee(Employee employee) {
		Employee employee2= employeeService.updateEmployee(employee);		
		ModelAndView andView=new ModelAndView("/getall");
		andView.addObject("emp", employee2);
		return andView;

	}
	@RequestMapping("/deleteemployee")
	public ModelAndView deleteEmployee(Employee employee) {
		Employee employee2= employeeService.deleteEmployee(employee);
		ModelAndView andView=new ModelAndView("/getall");
		andView.addObject("emp", employee2);
		return andView;

	}
}
