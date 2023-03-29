package ProjetBonPlan.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import ProjetBonPlan.model.User;
import ProjetBonPlan.dto.UserRegistrationDto;
 
/**
 * @author Chinna
 * @since 26/3/18
 */
public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
 
    // public User r egisterNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;
 
    // User findUserByEmail(String email);
 
    // Optional<User> findUserById(Long id);
 
    // LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
