package com.example.test.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.test.demo.dto.EmployeeDTO;
import com.example.test.demo.errorResponse.CustomerAlreadyExistsException;
import com.example.test.demo.errorResponse.InvalidDataException;
import com.example.test.demo.errorResponse.UserNotExistException;
import com.example.test.demo.models.Employee;
//import com.example.test.demo.principle.UserPrinciple;
import com.example.test.demo.repository.UserRepository;

//@Profile("prod")
@Service
public class UserService 
//implements UserDetailsService
{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
    
	public List<Employee> getAllUsers() {
		return userRepository.findAll();
	}
		
	public List<EmployeeDTO> getEmployeeById(long id) {
	    return userRepository.findById(id).stream().map(this::userToDto).collect(Collectors.toList());
	}
	
	public Employee getUserById(long id){
		return userRepository.findById(id).orElseThrow(() -> new CustomerAlreadyExistsException("User does not exist for this id"));
	}
	
	public void deleteUser(long id) {		
		userRepository.findById(id).orElseThrow(() -> new UserNotExistException("User does not exist for this id"));
		userRepository.deleteById(id);	
	}
	
	public void saveOrUpdate(Employee user){
		
		if(user.getAge() < 20) {
			throw new InvalidDataException("Age must be greater than 20");
		}
		else if(!(user.getEmail().endsWith(".com"))) {
			throw new InvalidDataException("Your Email-Id is invalid");
		}
		else if(userRepository.findByFirstnameAndLastnameAndEmailAndAge(user.getFirstname(), user.getLastname(), user.getEmail(), user.getAge()) != null) {
			throw new CustomerAlreadyExistsException("User is already exist");
		}
		else {
			this.userToDto(user);
			userRepository.save(user);
		}		
	}	
	
	public Employee dtoToUser(EmployeeDTO empoyeeDTO) {
		Employee emp = this.modelMapper.map(empoyeeDTO, Employee.class);
		return emp;
	}
	
	public EmployeeDTO userToDto(Employee user) {
		EmployeeDTO empDTO = this.modelMapper.map(user, EmployeeDTO.class);
		return empDTO;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Employee emp = userRepository.findByUsername(username);
//		if(emp == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		return new UserPrinciple(emp);
//	}
}
