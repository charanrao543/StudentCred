package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.entity.Student;
import com.student.service.StudentService;



@Controller
public class StudentController {

	@Autowired
	StudentService service;
	
	// create
	@PostMapping("/add") 
	public String addStudent(@ModelAttribute Student st) {
		service.addStudent(st);
		return "index";
	}
	
	// read
	@GetMapping("/get")
	public String getStudent(@RequestParam("roll") int roll, Model model) {
		Student st = service.getStudent(roll);
		
		model.addAttribute("student",st);
		//System.out.println(st);
		return "displayStudent";
	}
	
	//get all
	@GetMapping("/getAll")
	public String getAllStudents(Model model){
		List<Student> stList =service.getAllStudents();
		
		model.addAttribute("stList", stList);
		return "displayAll";
	}
	
	// update
		@PostMapping("/update") 
		public String updateStudent(@ModelAttribute Student st) {
			
			service.updateStudent(st);
			
			return "index";
		}
		
		// delete
				@PutMapping("/delete") 
				public String deleteStudent(@RequestParam("roll") int roll) {
					
					service.deleteStudent(roll);
					
					return "index";
				}
}

