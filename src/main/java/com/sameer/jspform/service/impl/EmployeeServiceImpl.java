package com.sameer.jspform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sameer.jspform.dao.EmployeeDao;
import com.sameer.jspform.model.Employee;
import com.sameer.jspform.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void deleteEmployee(Long id) {
        employeeDao.deleteById(id);
  }

	@Override
	public List<Employee> getSingleEmployee(long id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public List<Employee> updateEmployee(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}
}
