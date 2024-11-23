package com.demo.service;

import java.util.List;

import com.demo.entity.LabTest;
import com.demo.exception.LabTestNotFoundException;

//CRUD declaration for LabTest entity
public interface LabTestService {
	
	//fetch all LabTest details from table
	List<LabTest>getAllTest();
	
	//fetch lab test details based on id from table
	LabTest getTestById(Long LabId) throws LabTestNotFoundException;
	
	//fetch lab test details based on testName from table
	List<LabTest>getByTest(String testName);
	
}
