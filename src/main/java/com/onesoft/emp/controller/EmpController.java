package com.onesoft.emp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.emp.customexception.AgeNotEligibleException;
import com.onesoft.emp.customexception.AgeNotFoundException;
import com.onesoft.emp.customexception.NameNotFoundException;
import com.onesoft.emp.customexception.SalaryNotEligibleException;
import com.onesoft.emp.customexception.SalaryNotFountException;
import com.onesoft.emp.entity.Emp;
import com.onesoft.emp.service.EmpService;

@RestController
@RequestMapping("emp")
public class EmpController {
	@Autowired
	EmpService es;

	private static final Logger logger = Logger.getLogger(EmpController.class);

	@PostMapping(value = "setEmp")
	public String setEmp(@RequestBody Emp e) throws AgeNotEligibleException {
		return es.setEmp(e);
	}

	@PostMapping(value = "setAllEmp")
	public String setAllEmp(@RequestBody List<Emp> e) throws SalaryNotEligibleException {
		logger.info("Set the Employee From logger info");

		return es.setAllEmp(e);
	}

	@GetMapping(value = "getAll")
	public List<Emp> getAll() {

		logger.info("this is gettAll");
		logger.info(es.getAll());
		return es.getAll();
	}

	@GetMapping(value = "/getById/{id}")
	public Emp getbyid(@PathVariable int id) {
		return es.getById(id);
	}

	@DeleteMapping(value = "deleteById/{a}")
	public String delete(@PathVariable int a) {
		return es.detele(a);
	}

	@PutMapping(value = "update")
	public String update(@RequestBody Emp e) {
		return es.update(e);
	}

	@GetMapping(value = "getByName/{a}")
	public List<Emp> getByName(@PathVariable String a) throws NameNotFoundException {
		return es.getByName(a);
	}

	@GetMapping(value = "getByAge/{a}")
	public List<Emp> getByAge(@PathVariable int a) throws AgeNotFoundException {
		return es.getByAge(a);
	}

	@GetMapping(value = "getBySalary/{sal1}/{sal2}")
	public List<Emp> getBySal(@PathVariable int sal1, @PathVariable int sal2) throws SalaryNotFountException {
		return es.getBySal(sal1, sal2);
	}

}
