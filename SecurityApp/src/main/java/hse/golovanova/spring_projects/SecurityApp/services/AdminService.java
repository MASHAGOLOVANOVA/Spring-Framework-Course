package hse.golovanova.spring_projects.SecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public void fdoAdminStuff(){
        System.out.println("admin stuff");
    }
}
