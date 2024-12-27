package in.vishal.models;

public class AuthenticationResponse {//to give data to client

	private final String jwt;// this will be send as a response to the client

	public AuthenticationResponse(String jwt) {//constructor
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
}
