package in.vishal.models;

public class AuthenticationRequest {
	//use to take data given by client
// for req and response we have takein two binding classes
	private String username;//client will put username and password in req body
	//postman
	private String password;

	public AuthenticationRequest() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
