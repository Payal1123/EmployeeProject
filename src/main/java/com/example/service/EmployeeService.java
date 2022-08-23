package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;


@Service
public class EmployeeService {
	 @Autowired
	 EmployeeRepository emprepo;
	
	public Employee saveEmloyee(Employee employee) {
	   return  emprepo.save(employee);
		 
		 }
	public Employee getEmployeeById(long employee_id) {
	Optional<Employee> employee=emprepo.findById(employee_id);
	return employee.get();
		
	}
	public List<Employee> getEmployeeList(){
		return (List<Employee>)emprepo.findAll();
}
	 public Employee updateEmployee(Employee employee, long employee_id ) {
		// Employee resultById= emprepo.findById( employee_id).get();
		 Employee resultById=null;
		 try {
			 resultById= emprepo.findById( employee_id).get();
			 
		 }catch (Exception exception) {
			// TODO: handle exception
			 throw new EmployeeNotFoundException("Employee not found");
		}
		 
		 if (employee!=null){
	         if (employee.getFirstName()!=null){
	        	
	        	 resultById.setFirstName(employee.getFirstName());	        	 
	         }
	         if (employee.getLastName()!=null){
	        	 
	        	 resultById.setLastName(employee.getLastName());
        	 
	         }
	         if (employee.getDateOfbirth()!=null){
	        	 
	         }
	         resultById.setDateOfbirth(employee.getDateOfbirth());
	        	 
	         }
		 

       return emprepo.save(resultById);
		  }

}
