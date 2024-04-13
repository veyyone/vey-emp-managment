package com.cts.internship.project.ems.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.internship.project.ems.Repository.AdminRepository;
import com.cts.internship.project.ems.model.AdminLogin;


@Service
public class AdminService {

	@Autowired
	private AdminRepository adminrepos;
	
	public AdminLogin admin(String adminEmailId) {
		AdminLogin adLogin=adminrepos.findByAdminEmailId(adminEmailId);
		if(adLogin==null) {
			return null;
		}
		return adLogin;
	}
}
