package com.jrp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//how do we get all projects? from the repository we created
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;

	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {

		Map<String, Object> map = new HashMap<>();

		//remember we use Model object to send/receive data from the view
		
		//bring all projects that are in the db. it complains because cannot convert from 	
		List<Project> projects = proRepo.findAll();
		
		//add this list to the actual model that will be passed to the view. key can be projects, or projectsList or whatever
		// as long as the key in html is the same
		model.addAttribute("projectsList", projects);

		List<ChartData> projectData = proRepo.getProjectStatus();

		//Converting a projectData object into a json structure for use in js
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);

		model.addAttribute("projectStatusCnt", jsonString);

		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectCnt", employeesProjectCnt);
		
		return "main/home";
	}
	
	
}
