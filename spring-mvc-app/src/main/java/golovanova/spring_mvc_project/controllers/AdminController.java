package golovanova.spring_mvc_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golovanova.spring_mvc_project.dao.PersonDAO;
import golovanova.spring_mvc_project.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final PersonDAO personDAO;
	
	public AdminController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@GetMapping()
	public String adminPage(Model model, @ModelAttribute("person") Person person) {
		model.addAttribute("people", personDAO.index());
		return "adminPage";
	}
	
	
	@PatchMapping("/add")
	public String makeAdmin(@ModelAttribute("person") Person person) {
		System.out.println(person.getId());
		
		return "redirect:/people";
	}
	

}
