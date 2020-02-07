package com.sameer.jspform.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sameer.jspform.model.Employee;
import com.sameer.jspform.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

    //the welcome page
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

    //show the add employee form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}

    //Get the form field vaues which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {
		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

    //show all employees saved in db
	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
	 @PostMapping("/delete")
     public String deleteEmployee(@RequestParam("id") String id) {
           employeeService.deleteEmployee(Long.parseLong(id));
           return "redirect:/deleteEmployee";  
     }
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("deleteEmployee");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public ModelAndView updateEmployee() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("updateEmployee");
		model.addObject("employees", employees);
		return model;
	}
	
	@RequestMapping(value = "/edit", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView edit(@RequestParam("id") String id) {
		List<Employee> employee = employeeService.getSingleEmployee(Long.parseLong(id));
		ModelAndView model = new ModelAndView("edit");
		model.addObject("employee", employee);
		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") String id) {
		List<Employee> employee = employeeService.updateEmployee(Long.parseLong(id));
		ModelAndView model = new ModelAndView("updateEmployee");
		model.addObject("employees", employee);
		return model;
	}
	
	

}
