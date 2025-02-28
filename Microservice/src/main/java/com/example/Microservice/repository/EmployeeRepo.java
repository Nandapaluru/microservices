package com.example.Microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Microservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
