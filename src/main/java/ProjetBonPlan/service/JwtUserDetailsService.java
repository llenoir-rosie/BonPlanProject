package ProjetBonPlan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// import ProjetBonPlan.model.User;
import ProjetBonPlan.repository.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (userRepository.findByUsername(username) == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {
			return new User(userRepository.findByUsername(username).getUsername(), bcryptEncoder.encode(userRepository.findByUsername(username).getPassword()),
			new ArrayList<>());
		}
	}
	// public UserDao save(UserDTO user) {
	// 	DAOUser newUser = new DAOUser();
	// 	newUser.setUsername(user.getUsername());
	// 	newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	// 	return userDao.save(newUser);
	// }
}