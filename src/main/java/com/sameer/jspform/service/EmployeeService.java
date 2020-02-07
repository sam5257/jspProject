package com.sameer.jspform.service;


import java.util.List;
import com.sameer.jspform.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	List<Employee> getAllEmployees();
	public void deleteEmployee(Long id);
	List<Employee> getSingleEmployee(long id);
	List<Employee> updateEmployee(long parseLong);


}
