package com.example.test.demo.errorResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler({CustomerAlreadyExistsException.class})
	public ResponseEntity<Object> exceptionHandler(CustomerAlreadyExistsException exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMsg", exception.getMessage());
		return new ResponseEntity<Object>(errorMap, HttpStatusCode.valueOf(500));
	}
	
	@ExceptionHandler({UserNotExistException.class})
	public ResponseEntity<Object> exceptionHandler(UserNotExistException exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMsg", exception.getMessage());
		return new ResponseEntity<Object>(errorMap, HttpStatusCode.valueOf(404));
	}
	
	@ExceptionHandler({InvalidDataException.class})
	public ResponseEntity<Object> exceptionHandler(InvalidDataException exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMsg", exception.getMessage());
		return new ResponseEntity<Object>(errorMap, HttpStatusCode.valueOf(500));
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
	    List<String> errors = ex.getBindingResult().getFieldErrors()
	            .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
	    return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.BAD_REQUEST);
	}

	private Map<String, List<String>> getErrorsMap(List<String> errors) {
	    Map<String, List<String>> errorResponse = new HashMap<>();
	    errorResponse.put("errors", errors);
	    return errorResponse;
	}
}
