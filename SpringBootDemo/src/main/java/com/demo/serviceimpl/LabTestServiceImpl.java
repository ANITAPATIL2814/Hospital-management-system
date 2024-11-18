package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entity.LabTest;
import com.demo.exception.LabTestNotFoundException;
import com.demo.repository.LabTestRepository;
import com.demo.service.LabTestService;

//logic of LabTestService CRUD()
@Service  //to mark class as service class
public class LabTestServiceImpl implements  LabTestService{

	@Autowired //to get all method like getter, setter ....
	LabTestRepository lrepo;//get all methods of repository  	

	@Override
	public List<LabTest> getAllTest() {
		return lrepo.findAll();
	}
	

	@Override
	public LabTest getTestById(Long LabId) throws LabTestNotFoundException{
		return lrepo.findById(LabId).orElseThrow(()->(new LabTestNotFoundException("Lab test does not exist ")));
	}

	@Override
	public List<LabTest> getByTest(String testName) {
		return lrepo.findByTest(testName);
	}

}
