package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

//Note @Controller is not the same than @RestController
@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// we give spring container to inject an instance of the interface repository
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {

		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);
		return "employees/new-employee";
	}

	
	//It will return a String containing the name of the page to 
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {

		// So far we have the form binding complete, now we need to communicate with the
		// database..that's why
		// we do a Crud Repository
		empRepo.save(employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/new";
	}
	
	@GetMapping("")
	public String displayEmployeeList(Model model) {
	
		//remember we use Model object to send/receive data from the view
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		return "employees/list-employees";
	}

}
