package ProjetBonPlan.service;

import java.util.Map;
import java.util.Optional;
 
import ProjetBonPlan.model.User;
import ProjetBonPlan.dto.UserRegistrationDto;
 
/**
 * @author Chinna
 * @since 26/3/18
 */
public interface UserService {
    User save(UserRegistrationDto registrationDto);
 
    // public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;
 
    // User findUserByEmail(String email);
 
    // Optional<User> findUserById(Long id);
 
    // LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
