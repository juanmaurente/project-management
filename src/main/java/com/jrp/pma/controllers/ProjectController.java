package com.jrp.pma.controllers;

import java.util.List;

import com.jrp.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.web.bind.annotation.RequestParam;

//Note @Controller is not the same than @RestController
@Controller
@RequestMapping("/projects")
public class ProjectController {

	// we give spring container to inject an instance of the interface repository
		@Autowired
		ProjectRepository proRepo;

		@Autowired
		EmployeeRepository empRepo;

	@GetMapping("")
	public String displayProjects(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();

		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);

		return "projects/new-project";
	}
	
	@PostMapping("/save")
	/*public String createProject(Project project, @RequestParam List<Long> employees, Model model) {*/
	public String createProject(Project project, Model model) {
		proRepo.save(project);


		/*Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);

		for (Employee emp: chosenEmployees) {
			emp.setProjects(project);
			empRepo.save(emp);
		}
		*/

		//use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
	

	
}
