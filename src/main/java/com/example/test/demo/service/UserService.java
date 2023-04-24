package com.example.test.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.demo.models.User;
import com.example.test.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	public void saveOrUpdate(User user) {
		userRepository.save(user);
		
	}
	
	
	
}
