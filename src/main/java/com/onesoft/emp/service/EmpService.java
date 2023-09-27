package com.onesoft.emp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesoft.emp.customexception.AgeNotEligibleException;
import com.onesoft.emp.customexception.AgeNotFoundException;
import com.onesoft.emp.customexception.NameNotFoundException;
import com.onesoft.emp.customexception.SalaryNotEligibleException;
import com.onesoft.emp.customexception.SalaryNotFountException;
import com.onesoft.emp.dao.EmpDao;
import com.onesoft.emp.entity.Emp;

@Service
public class EmpService {

	@Autowired
	EmpDao ed;
	private static final Logger logger = Logger.getLogger(EmpService.class);

	public String setEmp(Emp e) throws AgeNotEligibleException {

		try {
			if (e.getAge() > 18) {
				return ed.setEmp(e);
			} else {
				throw new AgeNotEligibleException("Not eligible");

			}

		} catch (AgeNotEligibleException a) {
//			throw new AgeNotEligibleException("Not eligible");

			return "Not eligible";

		}
	}

	public String setAllEmp(List<Emp> e) throws SalaryNotEligibleException {

		List<Emp> l = e.stream().filter(s -> s.getSalary() < 50000).toList();
		try {

			if (l.isEmpty()) {
				throw new SalaryNotEligibleException("You are Not Eligible");
			} else {
				return ed.setAllEmp(l);

			}
		} catch (SalaryNotEligibleException a) {
			return a.getMessage();
		}

	}

	public List<Emp> getAll() {
		PropertyConfigurator.configure("log4j");
		logger.info(ed.getAll());

		return ed.getAll();
	}

	public Emp getById(int a) {
		return ed.getById(a);
	}

	public String detele(int a) {

		return ed.delete(a);
	}

	public String update(Emp e) {
		return ed.update(e);
	}

	public List<Emp> getByName(String a) throws NameNotFoundException {

		List<Emp> list = ed.getAll().stream().filter(x -> x.getName().equalsIgnoreCase(a)).collect(Collectors.toList());

		if (list.isEmpty()) {
			throw new NameNotFoundException("there is no data for this name: " + a);
		} else {
			return list;
		}
	}

	public List<Emp> getByAge(int a) throws AgeNotFoundException {
		// return ed.getAll().stream().filter(w -> w.getAge() > a).toList();
		List<Emp> j = ed.getByAge(a);
		if (j.isEmpty()) {
			throw new AgeNotFoundException("Not found data for this Age: " + a);

		} else {
			return j;
		}

	}

	public List<Emp> getBySal(int sal1, int sal2) throws SalaryNotFountException {

		List<Emp> l = ed.getBySal(sal1, sal2);
		if (l.isEmpty()) {
			throw new SalaryNotFountException("No Data for given value:" + sal1 + "to" + sal2);
		} else {
			return l;
		}
	}

}
