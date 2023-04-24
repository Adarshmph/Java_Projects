package com.example.test.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.models.User;
import com.example.test.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	private List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	private User getUser(@PathVariable("id") long id){
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/user/{id}")
	private void deleteUser(@PathVariable("id") long id){
		userService.deleteUser(id);
	}
	
	@PostMapping("/user")
	private void saveUser(@RequestBody User user) {
		userService.saveOrUpdate(user);
	}
}
