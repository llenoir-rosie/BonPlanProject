package ProjetBonPlan.service;

import java.util.Arrays;
 
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.Role;
import ProjetBonPlan.model.User;
import ProjetBonPlan.dto.UserRegistrationDto;
import ProjetBonPlan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), registrationDto.getPassword(), registrationDto.getUsername(), Arrays.asList(new Role("ROLE_USER")));
        
        return userRepository.save(user);
    }
}