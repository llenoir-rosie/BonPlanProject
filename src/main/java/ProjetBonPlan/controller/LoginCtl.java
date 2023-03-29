package ProjetBonPlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import ProjetBonPlan.service.UserServiceImpl;
import ProjetBonPlan.model.User;

@Controller
//@RestController
//@RequestMapping(value = "/login", method={RequestMethod.GET, RequestMethod.POST})
//@RequestMapping("/login")
public class LoginCtl {
    
    @Autowired
    private UserServiceImpl userServiceImpl;
    //@GetMapping("/login")
    @GetMapping("/login")
    public String login(){
        return "loginPage";
    } 
    
    /*@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)*/
    
    
    
    @PostMapping(path = "/checkuser")
    public org.springframework.security.core.userdetails.User test_login(String username){
        username = "test";

        org.springframework.security.core.userdetails.User user = userServiceImpl.loadUserByUsername(username);
        return user;
    }
    

}
