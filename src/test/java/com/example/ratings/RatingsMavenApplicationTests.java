package com.example.ratings;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RatingsMavenApplicationTests {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSaveEmployee() {
		Employee e=new Employee(10, "Asd", "asd@a.com", 98765, 7);
		doReturn(e).when(employeeRepository).save(any());
		
		Employee returnedEmployee=employeeService.saveEmployee(e);
		
		Assertions.assertNotNull(returnedEmployee, "Employee returned is not null");
	}
	
	@Test
	void testTopRated() {
		Employee e1=new Employee(10, "Asd", "asd@a.com", 98765, 7);
		Employee e2=new Employee(11, "Qwe", "qwe@p.com", 12365, 5);
		Employee e3=new Employee(12, "Zxc", "zxc@l.com", 56984, 8);
		doReturn(Arrays.asList(e3,e1,e2)).when(employeeRepository).findTop5ByOrderByRatingDesc();
		
		List<Employee> topEmployees=employeeService.top5employees();
		
		Assertions.assertEquals(Arrays.asList(e3,e1,e2), topEmployees);
	}
}
