package ngothanh.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ngothanh.com.entity.Users;
import ngothanh.com.responsitory.UserResponsitory;

@Service
public class UserService {

	@Autowired
	private UserResponsitory userResponsitory;
	
	public Users findByUsername(String username) {
		return userResponsitory.findByUsername(username);
	}
	
	public String findRole(String username) {
		return userResponsitory.findRole(username);
	}
}
