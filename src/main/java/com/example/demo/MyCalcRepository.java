package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MyCalcRepository extends CrudRepository<MyCalc, Long> { 
	List<MyCalc> findAllByOrderByIdAsc();
	
	List<MyCalc> findAllByOrderByIdDesc();
}