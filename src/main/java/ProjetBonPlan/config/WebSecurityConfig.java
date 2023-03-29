package ProjetBonPlan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ProjetBonPlan.service.UserService;
import jakarta.annotation.security.PermitAll;



@Configuration
@EnableWebSecurity
//extends WebSecurityConfigurerAdapter : deprecated
public class WebSecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
            
    }
    
    //@Override
    protected void configure_auth(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    
    //@Override
    protected void configure(HttpSecurity security) throws Exception{
        security.httpBasic().disable();
    }


    //@Override
    protected void configure_http(HttpSecurity http) throws Exception {

        //http.authorizeHttpRequests().requestMatchers("/**").permitAll();
        http.authorizeHttpRequests().requestMatchers(
            "/registration").permitAll()
            .anyRequest().authenticated()
            .and()
            // .authorizeHttpRequests().requestMatchers(
            // "/home").hasRole("USER")
            // .and()
            .formLogin()
            .loginPage("/login.html")
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll();
        
        
    }

}


















/*package ProjetBonPlan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import userservicedetailsimplement , authentrypointjwt, authtokenfilter
import ProjetBonPlan.service.UserDetailsServiceImpl;
import ProjetBonPlan.security.AuthEntryPointJwt;
import ProjetBonPlan.security.AuthTokenFilter;


@Configuration
//EnableGlobalMethodSecurity(
    // securedEnabled = true,
    // jsr250Enabled = true,
    //prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl UserDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter(){
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(UserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().requestMatchers("/login").permitAll()
        .requestMatchers("/register").permitAll()
        .anyRequest().authenticated();
    
    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
  }
}*/

