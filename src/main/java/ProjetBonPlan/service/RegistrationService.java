package ProjetBonPlan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.User;
import ProjetBonPlan.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    
    }

    public User fetchUserByEmail(String email){
        return repo.findByEmail(email);
    }
}