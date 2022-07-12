package ngothanh.com.entity;

public class AuthResponse {
	
	private String username;
	private String accessToken;
	public AuthResponse(String username, String accessToken) {
		super();
		this.username = username;
		this.accessToken = accessToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public AuthResponse() {
		super();
	}
	
}
