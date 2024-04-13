package com.cts.internship.project.ems.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table
public class AdminLogin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column
	private String adminEmailId;
	
	@Column
	private String adminPassword;
	
	

	public AdminLogin() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AdminLogin(int id, String adminEmailIid, String adminPassword) {
		this.id = id;
		this.adminEmailId = adminEmailIid;
		this.adminPassword = adminPassword;
	}



	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailIid) {
		this.adminEmailId = adminEmailIid;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	
	

}
