package golovanova.spring_mvc_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello-world")
	public String sayHello(){
	return "helloWorld";
	}
	
	
}


