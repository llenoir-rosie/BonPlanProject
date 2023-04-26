package ProjetBonPlan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	AuthenticationManager authenticationManager;

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

    @Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
        authenticationManager = authenticationManagerBuilder.build();
		// We don't need CSRF for this example
		httpSecurity.cors().and().csrf().disable()
				// dont authenticate this particular request
				.authorizeHttpRequests().requestMatchers("/login", "/registration").permitAll()
										.requestMatchers("/cities").permitAll()
										.requestMatchers("/city/{city}").permitAll()
										.requestMatchers("/activity/{activity}").permitAll()
										.requestMatchers("/{city}/activites").permitAll()
										.requestMatchers("/activities").permitAll()
										.requestMatchers("/user").permitAll()
										.requestMatchers("/{city}/{activity}/mauvaisplan").permitAll()
										.requestMatchers("/{city}/{activity}/bonplan").permitAll()
										.requestMatchers("/villes/{activity}").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().authenticationManager(authenticationManager).
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }

	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	// 	// configure AuthenticationManager so that it knows from where to load
	// 	// user for matching credentials
	// 	// Use BCryptPasswordEncoder
	// 	auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	// }
}
