package ProjetBonPlan.service;

import java.util.Arrays;
 
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.Role;
import ProjetBonPlan.model.User;
import ProjetBonPlan.dto.UserRegistrationDto;
import ProjetBonPlan.repository.ActivityRepository;
import ProjetBonPlan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ActivityRepository activityRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), registrationDto.getPassword(), registrationDto.getUsername(), "USER","../assets/img/default_user.jpg");
        
        return userRepository.save(user);
    }

    @Override
    public User fetchUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User fetchUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    
    public String fetchImgByUsername(String username){
        User user = userRepository.findImgByUsername(username);
        return user.getImgProfil();
    }


    @Override
    public User fetchUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void updatePassword(User user){
        User userfromDb = fetchUserByUsername(user.getUsername());
        userfromDb.setPassword(user.getPassword());
        userRepository.save(userfromDb);
    }

    public void updateAccountInfos(User user){
        User userfromDb=fetchUserByUsername(user.getUsername());
        userfromDb.setFirstName(user.getFirstName());
        userfromDb.setLastName(user.getLastName());
        userfromDb.setEmail(user.getEmail());
        userRepository.save(userfromDb);
    }

    public void UserDelete(String username){
        userRepository.deleteByUsername(username);
    }

    public void UpdatePhoto(String imgprofil, String username){
        User userfromDb = fetchUserByUsername(username);
        userfromDb.setImgProfil(imgprofil);
        userRepository.save(userfromDb);
    }
}