package com.example.ratings;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

import com.example.ratings.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	List<Employee> findTop5ByOrderByRatingDesc();
}