package com.example.test.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.dto.EmployeeDTO;
import com.example.test.demo.models.Employee;
import com.example.test.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user/data")
	public List<Employee> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/dto/{id}")
	public List<EmployeeDTO> getEmployeeById(@PathVariable("id") long id){
	    return userService.getEmployeeById(id);
	}
	
	@GetMapping("/user/{id}")
	public Employee getUser(@PathVariable("id") long id){
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") long id){
			userService.deleteUser(id);
	}
	
	@PostMapping("/user")
	public String saveUser(@RequestBody @Valid Employee user) {
		userService.saveOrUpdate(user);
		return "Data saved successfully";
	}
}
