package ProjetBonPlan.demo.test_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjetBonPlan.model.User;
import ProjetBonPlan.repository.UserRepository;

@Service
//get a full user from user Repository (by username) and 
// then build a UserDetails object from it, UserDetails contains neccesary
//info (passwd, authority, username) required for authentication
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
        return (UserDetails) UserDetailsImpl.build(user);
    }
}
