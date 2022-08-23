package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EmployeeNotFoundException;
import com.example.exception.ErrorMassage;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/app")
public class EmployeeController {
 @Autowired
 EmployeeService employeeservice ;
 
 
@PostMapping("/employees")
 public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee) {
		 employeeservice.saveEmloyee(employee);
		   
	return ResponseEntity.status(HttpStatus.CREATED).build();
		     
	   }
	@GetMapping("/employees/{employee_id}")
	public Employee getEmployeeById(@PathVariable("employee_id") long employee_id) {
	Employee employee=employeeservice.getEmployeeById(employee_id);
		return employee;
		
	}
	@GetMapping("employees")
	public List<Employee>getEmployeeList() {
		
		return employeeservice.getEmployeeList();
}
	@PutMapping("/employees/{employee_id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee,@PathVariable("employee_id")long employee_id) {
	
		try{
			employeeservice.updateEmployee(employee, employee_id);
			
			return ResponseEntity.status(HttpStatus.OK).build();
			//return ResponseEntity.ok().body(employee);
		}catch (EmployeeNotFoundException exception) {
			ErrorMassage error=new ErrorMassage(506,"EmployeeNotfound!!!");
			
			// TODO: handle exception
		 return new ResponseEntity<ErrorMassage>(error,HttpStatus.NOT_MODIFIED);
			
						//return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}
		
	//	return null; 	
	}
}