
package com.onesoft.emp.gobalhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onesoft.emp.customexception.AgeNotFoundException;
import com.onesoft.emp.customexception.NameNotFoundException;
import com.onesoft.emp.customexception.SalaryNotEligibleException;
import com.onesoft.emp.customexception.SalaryNotFountException;

@RestControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> nameHandler(NameNotFoundException nn) {
		return new ResponseEntity<>(nn.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(SalaryNotFountException.class)
	public ResponseEntity<Object> salaryHandle(SalaryNotFountException sn) {
		return new ResponseEntity<>(sn.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AgeNotFoundException.class)
	public ResponseEntity<Object> ageHandller(AgeNotFoundException an) {
		return new ResponseEntity<>(an.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SalaryNotEligibleException.class)
	public ResponseEntity<Object> SalHandller(SalaryNotEligibleException an) {
		return new ResponseEntity<>(an.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
