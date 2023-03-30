package ProjetBonPlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.User;
import ProjetBonPlan.service.RegistrationService;

@RestController
public class RegistrationCtrler {

    @Autowired
    private RegistrationService service;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder = passwordEncoder();

    //PasswordEncoder encoder = passwordEncoderGenerator.passwordEncoder();


    @PostMapping(path = "/register")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        //pouvoir ajouter manuellement le role ??
        if (tempEmail != null && !"".equals(tempEmail)){
            User userobj = service.fetchUserByEmail(tempEmail);
            if(userobj != null){
                throw new Exception("user with email " + tempEmail + " already exists");
            }
        }
        User userObj = null;
        //PasswordEncoder encoder = passwordEncoderGenerator.passwordEncoder();
        String EncodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(EncodedPassword);
        user.setRole("USER");
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping(path="/login")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj = null;

        if(tempEmail != null && tempPassword != null && service.fetchUserByEmail(tempEmail)!=null){
            //si les champs email et password sont non null et que l'utilisateur email existe

            User tempUser = service.fetchUserByEmail(tempEmail);

            if (passwordEncoder.matches(tempPassword,tempUser.getPassword())){
                //si le password entré correspond au hash existant pour l'utilisateur email
                userObj = service.fetchUserByEmail(tempEmail);
              }
        }

        if (userObj == null){
            throw new Exception("Invalid username or password");
        }

        System.out.println("log in : success");
        return userObj;

    }
    
}
