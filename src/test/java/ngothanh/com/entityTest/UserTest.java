package ngothanh.com.entityTest;


import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ngothanh.com.config.PersistenceJPAConfig;
import ngothanh.com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getByUsername() throws UnsupportedEncodingException {
		String usename="ngothanh9901@gmail.com";
		
		PrintStream ps = new PrintStream(System.out,true,"UTF-8");
		
		ps.println(userService.findByUsername(usename));
	}
	
	@Test
	public void getRole() {
		String username="ngothanh9901@gmail.com";
		
		System.out.println(userService.findRole(username));
	}
	
}
