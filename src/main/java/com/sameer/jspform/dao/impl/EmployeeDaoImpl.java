package com.sameer.jspform.dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sameer.jspform.dao.EmployeeDao;
import com.sameer.jspform.model.Employee;


@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
		
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(Employee emp) {
		String sql = "INSERT INTO employee " +
				"(empId, empName) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getEmpId(), emp.getEmpName()
		});
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			result.add(emp);
		}
		
		return result;
	}
	
	@Override
	public void deleteById(long id)
	{
		String sql = "DELETE  FROM employee where empId=?";
		 JdbcTemplate template = new JdbcTemplate(dataSource);
		 
		 
		  // define query arguments
		        Object[] params = { id };
		 
		   
		        // define SQL types of the arguments
		        int[] types = {Types.BIGINT};
		 
		 
		  int rows = template.update(sql, params, types);
		 		
	}/*

	@Override
	public List<Employee> getEmployee(long id) {
		String sql = "SELECT * FROM employee where empId=?";

	 Object[] inputs = new Object[] {id};
     List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, inputs);
		List<Employee> result = new ArrayList<Employee>();
			for(Map<String, Object> row:rows){
				Employee emp = new Employee();
				emp.setEmpId((String)row.get("empId"));
				emp.setEmpName((String)row.get("empName"));
				result.add(emp);
			}
		
		return result;
		
		
		
	}
*/

	 @Override
	 public Employee getEmployee(long id)
	 {
		 String sql ="select * from employee where empId=?";
		 Object[] inputs = new Object[] {id};

		 List<Map<String, Object>> rows=getJdbcTemplate().queryForList(sql,inputs);
		 
		 Employee emp=new Employee();
		 
		 for(Map<String, Object> row:rows)
		 {
		 	emp.setEmpId((String)row.get("empId"));
		 	emp.setEmpName((String)row.get("empName"));}
		
	return emp; 
	 }

	@Override
	public void update(Employee e) {
  
		String empId=e.getEmpId();
		String empName=e.getEmpName();
		String sql ="update employee set empName=? where empId=?";
		 Object[] inputs = new Object[] {empName,empId};
		 
		 getJdbcTemplate().update(sql,inputs);

		
	}

}
