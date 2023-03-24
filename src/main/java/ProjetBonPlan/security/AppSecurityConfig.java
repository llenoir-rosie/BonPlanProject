package ProjetBonPlan.security;

import javax.print.attribute.SupportedValuesAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import ProjetBonPlan.security.Roles;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfiguration{
    @Autowired
    private final PasswordEncoder passwordEncoder;
    public AppSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }
    public Roles roles;
    //@Override
    protected void configure(HttpSecurity http) throws Exception{
        //System.out.println(passwordEncoder.encode("password"));
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http/* 
        .csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.DELETE, "/city/delete").hasRole(roles.admin.name())
        .requestMatchers(HttpMethod.POST, "/city/new").hasRole(roles.admin.name())
        .requestMatchers(HttpMethod.POST, "/activite/new").hasRole(roles.admin.name())
        .requestMatchers(HttpMethod.GET,"/cities").hasAnyRole(roles.admin.name(), roles.supervisor.name(), roles.intern.name())
        .requestMatchers(HttpMethod.GET,"/activites").hasAnyRole(roles.admin.name(), roles.supervisor.name(), roles.intern.name())
       */ 
        .authorizeHttpRequests((authz) -> authz
       .anyRequest().authenticated())
        .httpBasic();
        return http.build()
        //.and()
        //.httpBasic(); 
    }

    //@Override
    //@Bean
    protected UserDetailsService userDetailsService(){
        UserDetails timmy = User.builder()
                            .username("timmy")
                            .password(passwordEncoder.encode("password"))
                            .roles(roles.intern.name())
                            .build();
        UserDetails john = User.builder()
                            .username("john")
                            .password(passwordEncoder.encode("password"))
                            .roles(roles.supervisor.name())
                            .build();
        UserDetails sarah = User.builder()
                            .username("sarah")
                            .password(passwordEncoder.encode("password"))
                            .roles(roles.admin.name())
                            .build();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(timmy, john, sarah);
     
        
        return userDetailsManager;

    }

    public void configure(WebSecurity web){
        web.ignoring().requestMatchers("/ignore1","/ignore2");
    }
    





}
