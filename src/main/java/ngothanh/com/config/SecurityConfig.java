package ngothanh.com.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ngothanh.com.responsitory.UserResponsitory;
import ngothanh.com.service.UserService;
import ngothanh.com.service.UserUserService;
import ngothanh.com.util.JwtTokenFilter;
import ngothanh.com.util.JwtTokenUtil;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserResponsitory userRes;
	
	@Autowired
	private JwtTokenFilter jwtTokenFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("user").password("password").roles("USER").and()
//		.withUser("admin").password("password").roles("USER", "ADMIN");
		
		auth.userDetailsService(new UserUserService(userService));
//		auth.userDetailsService(username -> userRes.findByUsername(username));
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin().and()
//		.authorizeRequests()
//		.antMatchers("/updateHotel").hasRole("ADMIN")
//		.anyRequest().permitAll();
		
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
		http.authorizeRequests()
		.antMatchers("/api/login").permitAll()
		.anyRequest().authenticated();
		
//		http.csrf().disable();
//		http.authorizeRequests()
//		.anyRequest().permitAll();
//		
		http.exceptionHandling()
        .authenticationEntryPoint(
            (request, response, ex) -> {
                response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    ex.getMessage()
                );
            }
        );
 
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	  @Override
	  @Bean
	  public AuthenticationManager authenticationManagerBean() throws Exception {
		  return super.authenticationManagerBean();
	  }
	     
}