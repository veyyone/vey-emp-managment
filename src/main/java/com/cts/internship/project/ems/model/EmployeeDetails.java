package com.cts.internship.project.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long EmpId;
	
	@Column(name="Employee_FirstName")
	private String EmpFirstName;
	
	@Column(name="Employee_LastName")
	private String EmpLastName;
	
	@Column(name="Employee_MailId")
	private String EmpMailId;
	
	@Column(name="Employee_Domain")
	private String EmpDomain;
	
	@Column(name="Employee_PhoneNumber")
	private String EmpPhoneNum;
	
	@Column(name="Employee_Age")
	private int Empage;
	
	@Column(name="Employee_Gender")
	private String EmpGender;
	
	
	
	public EmployeeDetails() {
	
	}


	public EmployeeDetails(long empId, String empFirstName, String empLastName, String empMailId, String empDomain, String empPhoneNum,
			int empage, String empGender) {
	
		EmpId = empId;
		EmpFirstName = empFirstName;
		EmpLastName = empLastName;
		EmpMailId = empMailId;
		EmpDomain = empDomain;
		EmpPhoneNum = empPhoneNum;
		Empage = empage;
		EmpGender = empGender;
	}

	public long getEmpId() {
		return EmpId;
	}


	public void setEmpId(long empId) {
		EmpId = empId;
	}


	public String getEmpFirstName() {
		return EmpFirstName;
	}


	public void setEmpFirstName(String empFirstName) {
		EmpFirstName = empFirstName;
	}


	public String getEmpLastName() {
		return EmpLastName;
	}


	public void setEmpLastName(String empLastName) {
		EmpLastName = empLastName;
	}


	public String getEmpMailId() {
		return EmpMailId;
	}


	public void setEmpMailId(String empMailId) {
		EmpMailId = empMailId;
	}


	public String getEmpPhoneNum() {
		return EmpPhoneNum;
	}


	public void setEmpPhoneNum(String empPhoneNum) {
		EmpPhoneNum = empPhoneNum;
	}


	
	public String toString() {
		return "EmployeeDetails [EmpId=" + EmpId + ", EmpFirstName=" + EmpFirstName + ", EmpLastName=" + EmpLastName
				+ ", EmpMailId=" + EmpMailId + "]";
	}


	public int getEmpage() {
		return Empage;
	}


	public void setEmpage(int empage) {
		Empage = empage;
	}


	public String getEmpGender() {
		return EmpGender;
	}


	public void setEmpGender(String empGender) {
		EmpGender = empGender;
	}


	public String getEmpDomain() {
		return EmpDomain;
	}


	public void setEmpDomain(String empDomain) {
		EmpDomain = empDomain;
	}
	
	
	

}
