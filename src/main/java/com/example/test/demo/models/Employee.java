package com.example.test.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	@NotBlank(message = "Name is mandatory")
	private String firstname;
	private String lastname;
	@NotBlank(message = "Email-ID is mandatory")
	@Email(message = "Email should be valid")
	private String email;
	@NotNull(message = "Age is mandatory")
	private int age;
	@NotBlank(message = "Username is mandatory")
	private String username;
	@NotBlank(message = "Password is mandatory")
	private String pass;
}
