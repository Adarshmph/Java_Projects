package com.example.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.demo.dto.EmployeeDTO;
import com.example.test.demo.models.Employee;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
	Employee findByFirstnameAndLastnameAndEmailAndAge(String firstname, String lastname, String email, int age);
	EmployeeDTO findByFirstnameAndLastnameAndEmail(String firstname, String lastname, String email);
//	Employee findByUsername(String username);
}
