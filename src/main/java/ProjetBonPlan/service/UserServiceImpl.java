package ProjetBonPlan.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import ProjetBonPlan.model.Role;
import ProjetBonPlan.model.User;
import ProjetBonPlan.dto.UserRegistrationDto;
import ProjetBonPlan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
        registrationDto.getLastName(),
        registrationDto.getEmail(),
        passwordEncoder.encode(registrationDto.getPassword()),
        registrationDto.getUsername(),
        "USER");
        return userRepository.save(user);
    }

    final class Role {
        
        public String name;
    
        public Role(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    
    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(username);
        System.out.println(user);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        Collection<Role> tableau_role = new ArrayList<Role>();
        Role role = new Role("USER");
        tableau_role.add(role);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolesToAuthorities(tableau_role));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        
    }
}