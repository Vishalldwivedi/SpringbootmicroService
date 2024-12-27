package in.vishal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vishal.models.AuthenticationRequest;
import in.vishal.models.AuthenticationResponse;
import in.vishal.security.MyUserDetailsService;
import in.vishal.util.JwtUtil;

@RestController
public class MyRestController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private MyUserDetailsService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/authenticate")//generate token after authentication
	public ResponseEntity<?> authentication(@RequestBody AuthenticationRequest request) throws Exception {
		try {//authentication manager will validate if the credentials in reqbody correct or not.
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (Exception e) {
			throw new Exception("Invalid Credentials");
		}

		UserDetails userDetails = service.loadUserByUsername(request.getUsername());

		String jwt = jwtUtil.generateToken(userDetails);//tell jwtUtil to generate token
		// by taking this userDetails

		AuthenticationResponse response = new AuthenticationResponse(jwt);
		//we need to send response to the user via responseEntity which is jwt token

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/hello")//can access went authentication is done
	public String sayHello() {
		return "Hello World";
	}

}
