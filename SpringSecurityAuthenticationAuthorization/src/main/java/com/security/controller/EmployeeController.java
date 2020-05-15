package com.security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Employee;


@RestController
public class EmployeeController 
{
	static List<Employee> emplist = new ArrayList<Employee>(Arrays.asList(new Employee(1,"Vinod","SSE"),
			new Employee(2,"Vaibhav","SE"),
			new Employee(3,"Roshan","STE"),
			new Employee(4,"Tusshar","Ultra Senior technical Manager Max pro 2")));	
	
	@GetMapping("/")
	public String welcomeMessage() 
	{
		return "<h1>Welcome User<h1>";
	}
	
	
	@PostMapping("employee/saveEmployee")
	public List<Employee> saveEmployee(@RequestBody Employee emp)
	{
		System.out.println(emp.toString());
		emplist.add(emp);
		return emplist;
	}
	
	@GetMapping("/employee/getEmployee/{id}")
	public Stream<Employee> getEmployee(@PathVariable int id) {
		return emplist.stream().filter(emp1->id==emp1.getEmpId());
	}
	
	@GetMapping("/employee/getAllEmployee")
	public List<Employee> getEmployee() {
		return emplist;
	}
	
	@GetMapping("/employee/deleteEmployee/{id}")
	public List<Employee> delete(@PathVariable int id) 
	{
		//return emplist.stream().filter(p->id!=p.getEmpId()).collect(Collectors.toList());
		Iterator<Employee> itr = emplist.iterator();
		while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			if (employee.getEmpId()==id) {
				itr.remove();
			}
		}
		return emplist;
	}
}
