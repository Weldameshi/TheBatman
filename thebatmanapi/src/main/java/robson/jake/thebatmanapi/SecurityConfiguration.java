package robson.jake.thebatmanapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import robson.jake.thebatmanapi.model.User;
import robson.jake.thebatmanapi.repository.UserRepository;
import robson.jake.thebatmanapi.security.AuthSuccessHandler;
import robson.jake.thebatmanapi.security.LogoutSuccess;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserRepository userRepository;
	
	private Map<String, User> users = new HashMap<>();
	
	@PostConstruct
	private void initUser() {
		List<User> allUsers = userRepository.findAll();
		for(User u : allUsers) {
			u.setPassword(passwordEncoder().encode(u.getPassword()));
			users.put(u.getUsername(), u);
		}
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return users.get(username);
			}
		};
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers("/").anonymous()
		.antMatchers("/login").permitAll()
		.antMatchers("/tech").hasAuthority("USER")
		.antMatchers("/people").hasAuthority("USER")
		.antMatchers("/lair").hasAuthority("USER")
		.antMatchers("/vehicle").hasAuthority("USER")
		.antMatchers("/user").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
        .formLogin()
        .successHandler(new AuthSuccessHandler())
        .failureHandler(authenticationFailureHandler())
        .permitAll()
        .and()
        .logout()
        .logoutSuccessHandler(logoutSuccessHandler())
        .invalidateHttpSession(true)
        .permitAll()
		.and()
		.csrf().disable()
		.httpBasic();
	}

	/*
	 * @Bean public AuthenticationFailureHandler authenticationFailureHandler() {
	 * return new CustomAuthenticationFailureHandler(); }
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean public AuthSuccessHandler authSuccessHandler() { return new
	 * AuthSuccessHandler(); }
	 */
	@Bean
	public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler();
	}
	@Bean
	public LogoutSuccess logoutSuccessHandler() {
		return new LogoutSuccess();
	}
}
