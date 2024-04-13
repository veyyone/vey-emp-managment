package com.cts.internship.project.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.internship.project.ems.Repository.EmployeeRepository;
import com.cts.internship.project.ems.model.EmployeeDetails;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	public void empDetailsSave(EmployeeDetails empdetails) {

		emprepo.save(empdetails);
		
	}
	
	public List<EmployeeDetails> listEmp(){
		return emprepo.findAll();
	}
	
	public EmployeeDetails empDetails(long EmpId) {
		return emprepo.findById(EmpId).get();
	}
	
	public void empDelete(long EmpId) {
		 emprepo.deleteById(EmpId);
	}

}
