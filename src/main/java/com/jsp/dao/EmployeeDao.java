package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.jsp.dto.Employee;

@Component
public class EmployeeDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public Employee saveEmployee(Employee employee) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
		}
		return employee;
	}
	public Employee updateEmployee(Employee employee) {
		int id=employee.getId();
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee employee2= entityManager.find(Employee.class, id);
		if(employee2!=null) {
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		return employee;
		
	}
	public Employee deleteEmployee(Employee employee) {
		int id=employee.getId();
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee employee2= entityManager.find(Employee.class, id);
		if(employee2!=null) {
			entityTransaction.begin();
			entityManager.remove(employee2);
			entityTransaction.commit();
		}
		return employee;
	}
	
	
	public List<Employee> getAllEmployee(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query= entityManager.createQuery("select a from Employee a");
		return  query.getResultList();
	}
	
	
	public Employee getById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Employee.class, id);
	}
	
	

}
