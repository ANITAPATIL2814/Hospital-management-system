package com.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.LabTest;
import com.demo.exception.LabTestNotFoundException;
import com.demo.service.LabTestService;
@RestController////A convenience annotation that is itself annotated with @Controller and @ResponseBody. 

public class LabTestController {
	@Autowired //Marks a constructor, field, setter method
	LabTestService lts;
	
	@GetMapping("/allLabTest")
	public List<LabTest> fetchLabTest(){
		return lts.getAllTest();
	}
	
	
	@GetMapping("/LabTestbyid{labId}")
	public ResponseEntity<LabTest> fetchLabById(@PathVariable("labId") long LabId) throws LabTestNotFoundException
	{
		return new ResponseEntity<LabTest>(lts.getTestById(LabId),HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/allLabTestname/{testName}")
	public List<LabTest> fetchLabTestbyname(@PathVariable String testName){
		return lts.getByTest(testName);
	}
}
