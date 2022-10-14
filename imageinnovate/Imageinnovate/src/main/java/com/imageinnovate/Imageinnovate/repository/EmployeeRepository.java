package com.imageinnovate.Imageinnovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imageinnovate.Imageinnovate.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
