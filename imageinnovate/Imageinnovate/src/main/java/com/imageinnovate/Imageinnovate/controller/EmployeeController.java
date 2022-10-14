package com.imageinnovate.Imageinnovate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imageinnovate.Imageinnovate.Service.EmployeeService;
import com.imageinnovate.Imageinnovate.beans.Employee;
import com.imageinnovate.Imageinnovate.beans.TaxData;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addEmp")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getEmp/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getTax/{id}")
	public TaxData getTaxOfEmployee(@PathVariable Long id) {
		return service.getTaxOfEmployee(id);
	}

	
	/*
	 * @RequestMapping(method = RequestMethod.POST, value = "/addEmpName") public
	 * String addEmployee(@RequestParam String name) { System.out.println(name);
	 * return name; }
	 */
}
