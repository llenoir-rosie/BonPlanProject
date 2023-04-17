package ProjetBonPlan.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.User;
import ProjetBonPlan.repository.UserRepository;
import ProjetBonPlan.dto.UserRegistrationDto;
 
/**
 * @author Chinna
 * @since 26/3/18
 */
@Service
public interface UserService {

    User save(UserRegistrationDto registrationDto);

    User fetchUserByUsername(String username);

    User fetchUserByEmail(String email);

    User fetchUserByEmailAndPassword(String email, String pass);
 
    // public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;
 
    // User findUserByEmail(String email);
 
    // Optional<User> findUserById(Long id);
 
    // LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
