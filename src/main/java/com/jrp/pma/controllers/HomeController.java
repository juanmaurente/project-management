package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
public class HomeController {

	//how do we get all projects? from the repository we created
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;

	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		//remember we use Model object to send/receive data from the view
		
		//bring all projects that are in the db. it complains because cannot convert from 	
		List<Project> projects = proRepo.findAll();
		
		//add this list to the actual model that will be passed to the view. key can be projects, or projectsList or whatever
		// as long as the key in html is the same
		model.addAttribute("projectsList", projects);
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		return "main/home";
	}
}
