package com.onesoft.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onesoft.emp.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	@Query(value = "select * from emp_details where salary>=? and salary<=?", nativeQuery = true)
	List<Emp> getBySal(int sal1, int sal2);


	@Query(value = "select e from Emp e where e.age<:a")
	List<Emp> getByAge(@Param(value = "a") int a);

}
