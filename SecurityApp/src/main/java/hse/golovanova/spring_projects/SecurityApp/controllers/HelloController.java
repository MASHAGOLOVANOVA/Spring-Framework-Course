package hse.golovanova.spring_projects.SecurityApp.controllers;

import hse.golovanova.spring_projects.SecurityApp.security.PersonDetails;
import hse.golovanova.spring_projects.SecurityApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

    private final AdminService adminService;

    @Autowired
    public HelloController(final AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("/auth/welcome")
    public String sayHello(){
        return "hello";
    }
    @GetMapping("/auth/user")
    public String getLogin(){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails);
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.fdoAdminStuff();
        return "admin";
    }

}
