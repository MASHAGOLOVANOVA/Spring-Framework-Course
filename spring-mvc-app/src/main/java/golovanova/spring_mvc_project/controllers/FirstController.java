package golovanova.spring_mvc_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	@GetMapping("/hello")
	public String helloPage(HttpServletRequest request,
			Model model) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
	//	System.out.println("Hello, "+name+" "+surname);
		model.addAttribute("message","Hello, "+name+" "+surname);
		return "first/hello";
	}

	@GetMapping("/bye")
	public String goodByuPage(@RequestParam(value="name", required=false) String name) {
		System.out.println("Bye, "+name);
		return "first/bye";
	}
	@GetMapping("/calculator")
	public String calculator(@RequestParam(value="a") int a,@RequestParam(value="b") int b, @RequestParam(value="action") String action, Model model) {
		if (action.equals("multiplication"))
			model.addAttribute("answer", a*b);
		if (action.equals("addition"))
			model.addAttribute("answer", a+b);
		if (action.equals("subtration"))
			model.addAttribute("answer", a-b);
		if (action.equals("division"))
			model.addAttribute("answer", (double)a/b);
		return "first/calculator";
	}
}
