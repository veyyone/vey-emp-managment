package com.cts.internship.project.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class EmployeeManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagmentSystemApplication.class, args);
	}

}
