package com.jrp.pma;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ProjectRepository proRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}


	/*
	@Bean
	CommandLineRunner runner() {
		return args -> {

			Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
			Employee emp2 = new Employee("Mike", "Lanister", "Lanister@gmail.com");
			Employee emp3 = new Employee("Steven", "Reeves", "Reeves@gmail.com");

			Employee emp4 = new Employee("Ronald", "Connor", "Connor@gmail.com");
			Employee emp5 = new Employee("Jim", "Salvator", "Salvator@gmail.com");
			Employee emp6 = new Employee("Peter", "Henley", "Henley@gmail.com");

			Employee emp7 = new Employee("Richard", "Carson", "Carson@gmail.com");
			Employee emp8 = new Employee("Honor", "Miles", "Miles@gmail.com");
			Employee emp9 = new Employee("Tony", "Roggers", "Roggers@gmail.com");

			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for the final deployment");
			Project pro2 = new Project("New Employee Budget", "COMPLETED", "Decitions about bounus for employees budget");
			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "Office has been damaged due to hurracain. Needs to be reconstructed");
			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack the system's security needs to ibe improved");

			pro1.addEmployee(emp1);
			pro1.addEmployee(emp2);
			pro2.addEmployee(emp3);
			pro3.addEmployee(emp1);
			pro4.addEmployee(emp1);
			pro4.addEmployee(emp3);

			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
			emp2.setProjects(Arrays.asList(pro1));
			emp3.setProjects(Arrays.asList(pro2, pro4));

			empRepo.save(emp1);
			empRepo.save(emp2);
			empRepo.save(emp3);
			empRepo.save(emp4);
			empRepo.save(emp5);
			empRepo.save(emp6);
			empRepo.save(emp7);
			empRepo.save(emp8);
			empRepo.save(emp9);

			proRepo.save(pro1);
			proRepo.save(pro2);
			proRepo.save(pro3);
			proRepo.save(pro4);


		};
	}
	*/

}
