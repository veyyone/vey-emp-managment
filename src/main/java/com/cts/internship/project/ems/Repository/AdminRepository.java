package com.cts.internship.project.ems.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.internship.project.ems.model.AdminLogin;

@Repository
public interface AdminRepository extends JpaRepository<AdminLogin, Long>{

	AdminLogin findByAdminEmailId(String adminEmailId);
}
