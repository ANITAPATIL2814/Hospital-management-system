package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.LabTest;

public interface LabTestRepository extends JpaRepository <LabTest,Long> {
	//custom query - to fetch test details based on test name
	//@Query: Annotation to declare finder queries directly on repository methods.
	
	@Query("SELECT lt FROM LabTest lt WHERE lt.testName = :testName")
	List<LabTest> findByTest(@Param("testName") String testName);

}
