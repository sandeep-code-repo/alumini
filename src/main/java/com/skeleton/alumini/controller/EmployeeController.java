package com.skeleton.alumini.controller;
import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skeleton.alumini.entity.Employee;
import com.skeleton.alumini.service.EmployeeService;

@RestController
@RequestMapping("/alumini/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 
	 * @param employee
	 * @return
	 * @description
	 * insert employee details
	 */
	
	@PostMapping("/")
	public ResponseEntity<?> insertEmployeeData(@RequestBody Employee emp) {
    	
    		Employee entity = employeeService.insertemp(emp);	
    		
	        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param employee
	 * @return
	 * @description
	 * Update employee By Employee Id
	 */
	
	@PutMapping(value ="/{iName}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> editEmployeeData(@RequestBody Employee emp,@PathVariable("iName") String iName) {
    	
    		Employee entity = employeeService.editByEname(iName,emp);
    
	        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
		}
	

	/**
	 * 
	 * @param employee
	 * @return
	 * @description
	 * Get employee By Employee Name
	 */
	
	@GetMapping(value ="/{iName}",
			produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmpByName(@PathVariable("iName") String iName) 
                                                    {
		
			Employee entity = employeeService.findEmpByName(iName);			 
	        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	
	/**
	 * 
	 * @param employee
	 * @return
	 * @description
	 * Get employee By Employee details
	 */
	@GetMapping(value ="/",
			produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getEmpDetails() 
                                                    {
		
			List<Employee> entity = employeeService.getEmployeeList();
			return new ResponseEntity<Object>(entity, HttpStatus.OK);
    }
	
	/**
	 * Delete employee By Employee Name
	 */
	
	@DeleteMapping(value ="/{iName}",
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?>  deleteUser(@PathVariable("iName") String iName){
		
		String Status="INACTIVE";
		Employee result = employeeService.deleteUser(iName,Status);
		  return new ResponseEntity<Object>(result, HttpStatus.OK);
	   }
	
	
	
}
