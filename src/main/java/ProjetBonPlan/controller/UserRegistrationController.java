package ProjetBonPlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ProjetBonPlan.dto.UserRegistrationDto;
import ProjetBonPlan.service.UserService;

@Controller
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserRegistrationController {
    
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    // @ModelAttribute("user")
    // public UserRegistrationDto userRegistrationDto() {
    //     return new UserRegistrationDto();
    // }
    @GetMapping
    public String showRegistrationForm() {  //Model model
        // model.addAttribute("user", new UserRegistrationDto())
        return "registration";
    }

    @PostMapping
    public String registerUserAccout(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
    
}
