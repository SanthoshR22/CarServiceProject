package com.practice.csa.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practice.csa.entity.Car;
import com.practice.csa.exception.CarNotFoundByIdException;
import com.practice.csa.exception.ServiceNotFoundByIdException;

@RestControllerAdvice
public class ApplicationException {
 
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> carNotFoundException(CarNotFoundByIdException ex){
		
		ErrorStructure<String> errorStructure = new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("The Requested Data is Not Found in Database.Please try Valid ID");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> serviceNotFoundException(ServiceNotFoundByIdException ex){
		ErrorStructure<String> errorStructure = new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("The Requested Data is Not Found in Database.Please try Valid ID");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
}
