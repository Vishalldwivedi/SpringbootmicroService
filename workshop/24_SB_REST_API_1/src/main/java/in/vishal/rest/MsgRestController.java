package in.vishal.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//object will bbe createad for reast controller becuase u have
//defined it as spring bean
public class MsgRestController {



	@GetMapping("/welcome")//method URL pattern
	public ResponseEntity<String> getWelcomeMsg() {
		String msg = "Welcome To app";
		return new ResponseEntity<>(msg, HttpStatus.OK);
		//responseEntity - > body and status code(custome statusCode)
	}

	@GetMapping("/greet")// by default it will send 200 as status code
	public String getGreetMsg() {
		String msg = "Good Evening..!!";
		return msg;
	}

}
