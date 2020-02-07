package com.sameer.jspform.dao;

import java.util.List;

import com.sameer.jspform.model.Employee;

public interface EmployeeDao {
	
	void insertEmployee(Employee cus);
	List<Employee> getAllEmployees();
	void deleteById(long id);
	List<Employee> getEmployee(long id);
}
