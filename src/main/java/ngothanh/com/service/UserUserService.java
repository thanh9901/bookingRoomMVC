package ngothanh.com.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ngothanh.com.entity.Users;

public class UserUserService  implements UserDetailsService{
	
	private UserService userService;
	
	
	
	public UserUserService(UserService userService) {
		super();
		this.userService = userService;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userService.findByUsername(username);
		
		if(user!=null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			String role = userService.findRole(username);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
			return new User(user.getUsername(),user.getPassword(),authorities);
//			return new User(user.getUsername(),"hehe",authorities);
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}

}
