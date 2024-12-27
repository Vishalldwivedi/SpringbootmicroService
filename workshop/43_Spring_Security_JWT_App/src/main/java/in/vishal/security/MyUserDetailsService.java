package in.vishal.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

// this class is providing service to my authentication by providing username and password
@Service//if user comes with these credentilas i will generate the token other wise i will
//not generate the token
public class MyUserDetailsService implements UserDetailsService{
	// this class will implement UserDetailsService which is in build interface
	@Override
	public UserDetails loadUserByUsername(String s) {
		return new User("admin","$2a$12$LKrFNAHNdv7r2Lx7xeg9HuB47Hq8G1LSKXur8icj.LIE8gBK8ftbO",new ArrayList<>());
	}
//any request with authentication client  will give this to details only
}
