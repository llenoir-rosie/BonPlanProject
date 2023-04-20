package ProjetBonPlan.controller;

import java.rmi.ServerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.dto.UserRegistrationDto;
import ProjetBonPlan.model.User;
import ProjetBonPlan.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserRegistrationController {
    
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping(path = "/registration", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> registerUserAccout(@RequestBody UserRegistrationDto registrationDto) throws Exception {
        String tempEmail = registrationDto.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)) {
            User user = userService.fetchUserByEmail(tempEmail);
            if ( user != null) {
                throw new Exception("User already exist!!");
            }
        }
        User user = userService.save(registrationDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }    
    
    @GetMapping(path = "/{username}/Details")
    public ResponseEntity<User> loginUser(@PathVariable("username") @RequestBody String username) {
        User userObj = userService.fetchUserByUsername(username);
        return new ResponseEntity<>(userObj, HttpStatus.CREATED);
     }
}
