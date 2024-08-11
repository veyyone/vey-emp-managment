package com.cts.internship.project.ems.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import com.cts.internship.project.ems.Service.AdminService;
import com.cts.internship.project.ems.Service.EmployeeService;
import com.cts.internship.project.ems.model.AdminLogin;
import com.cts.internship.project.ems.model.EmployeeDetails;




@Controller
public class AdminIndexController {
	
	@Autowired
	private AdminService adminservice;

	@Autowired
	private  EmployeeService empservice;
	
	
	
	@GetMapping("/")
	public ModelAndView index(AdminLogin adminLogin) {
		ModelAndView mav=new ModelAndView("index");
		return mav;
	}
	
	@PostMapping("/")
	public ModelAndView adminLoginAction(ModelMap modelmap,@RequestParam String adminEmailId, @RequestParam String adminPassword) {
		
		 ModelAndView mav =new ModelAndView();
				System.out.println(adminEmailId+" "+adminPassword);
				if(!adminEmailId.isEmpty() && !adminPassword.isEmpty()) {
					AdminLogin admin=new AdminLogin(adminEmailId, adminPassword);
						if(!admin.getAdminEmailId().equalsIgnoreCase("admin@moon.com")) {
									
								modelmap.put("error", "*This Admin Id not exits");
								mav.setViewName("index");
						}else {
							if(admin.getAdminEmailId().equalsIgnoreCase("admin@moon.com") && admin.getAdminPassword().equalsIgnoreCase("moon@9047.")) {
									mav.setViewName("redirect:/welcome");
							}else {
								modelmap.put("error","*Please provide correct Admin Id or Password");
								mav.setViewName("index");
							}
						}
				}else {
					modelmap.put("errorEmail","*Enter Mail Id Field");
					modelmap.put("errorPswd","*Enter Password Field");
					mav.setViewName("index");
				}
		
			return mav;
	}
	@RequestMapping("/welcome")
	public ModelAndView welcome(Model model) {
		ModelAndView mav=new ModelAndView("welcome");
		List<EmployeeDetails> empList=empservice.listEmp();
		model.addAttribute("empList", empList);
		return mav;
	}
	
	@GetMapping("welcome/employeeDetailsAdding")
	public ModelAndView employeeDetailsAdding(Model model) {
		ModelAndView mav=new ModelAndView("employeeDetailsAdding");
		return mav;
	}
	
	@PostMapping("/welcome")
	public ModelAndView employeeDetailsFetching(EmployeeDetails empDetails) {
		ModelAndView mav=new ModelAndView();
		empservice.empDetailsSave(empDetails);
		mav.setViewName("redirect:/welcome");
		return mav;
	  
	}
	
	@RequestMapping("welcome/view/{EmpId}")
	public ModelAndView viewDetails(@PathVariable(name="EmpId") long empid ) {
		ModelAndView mav=new ModelAndView("view");
		EmployeeDetails employeeDetails=empservice.empDetails(empid);
		mav.addObject("empDetail", employeeDetails);
		return mav;
		
	}
	
	@RequestMapping("/view/update/{EmpId}")
	public ModelAndView UpdatePage(@PathVariable(name="EmpId") long empid ) {
		ModelAndView mav=new ModelAndView("update");
		EmployeeDetails employeeDetails=empservice.empDetails(empid);
		mav.addObject("empDetail", employeeDetails);
		return mav;
		
	}
	
	@RequestMapping("/updateDetails/{EmpId}")
	public ModelAndView UpdateDetails(@PathVariable(name="EmpId") long empid, EmployeeDetails empd) {
		ModelAndView mav=new ModelAndView("redirect:/welcome");
		EmployeeDetails employeeDetailsUpdate=empservice.empDetails(empid);
		
		employeeDetailsUpdate.setEmpFirstName(empd.getEmpFirstName());
		employeeDetailsUpdate.setEmpLastName(empd.getEmpLastName());
		employeeDetailsUpdate.setEmpMailId(empd.getEmpMailId());
		employeeDetailsUpdate.setEmpPhoneNum(empd.getEmpPhoneNum());
		employeeDetailsUpdate.setEmpDomain(empd.getEmpDomain());
		employeeDetailsUpdate.setEmpage(empd.getEmpage());
		employeeDetailsUpdate.setEmpGender(empd.getEmpGender());
		empservice.empDetailsSave(employeeDetailsUpdate);
		return mav;
		
	}
	
	@RequestMapping("delete/{EmpId}")
	public ModelAndView delete(@PathVariable(name="EmpId") long empid) {
		ModelAndView mav=new ModelAndView();
		empservice.empDelete(empid);
		mav.setViewName("redirect:/welcome");
		return mav;
	}
	
}
