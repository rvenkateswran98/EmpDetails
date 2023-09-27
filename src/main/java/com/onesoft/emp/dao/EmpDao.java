package com.onesoft.emp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.emp.controller.EmpController;
import com.onesoft.emp.entity.Emp;
import com.onesoft.emp.repository.EmpRepository;

@Repository
public class EmpDao {

	@Autowired
	EmpRepository er;
	private static final Logger logger = Logger.getLogger(EmpDao.class);

	public String setEmp(Emp e) {

		er.save(e);
		return "Saved Successfully";
	}

	public String setAllEmp(List<Emp> e) {
		er.saveAll(e);
		return "All file saved done";
	}

	public List<Emp> getAll() {
		PropertyConfigurator.configure("log4j");
		logger.info(er.findAll());

		return er.findAll();
	}

	public Emp getById(int a) {

		return er.findById(a).get();
	}

	public String delete(int a) {
		er.deleteById(a);

		return "Deleted successfully";
	}

	public String update(Emp e) {
		er.save(e);
		return "Updated successfully";
	}

	public List<Emp> getBySal(int sal1, int sal2) {
		// TODO Auto-generated method stub
		return er.getBySal(sal1,sal2);
	}


	public List<Emp> getByAge(int a) {
		// TODO Auto-generated method stub
		return er.getByAge(a);
	}

}
