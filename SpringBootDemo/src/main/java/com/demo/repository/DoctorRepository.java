package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
