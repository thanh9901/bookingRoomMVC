package ngothanh.com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import ngothanh.com.entity.AuthRequest;
import ngothanh.com.entity.AuthResponse;
import ngothanh.com.entity.Users;
import ngothanh.com.util.JwtTokenUtil;

@RestController
public class AuthApi {
	
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	
	@PostMapping("/api/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request){
		
		try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword())
            );
             
            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);
             
            return ResponseEntity.ok().body(response);
             
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
	}
	
	
}
