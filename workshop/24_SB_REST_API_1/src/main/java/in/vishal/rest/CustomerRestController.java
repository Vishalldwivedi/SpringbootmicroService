package in.vishal.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vishal.binding.Customer;

@RestController
public class CustomerRestController {

	@GetMapping(
			value="/customer",
			produces = {"application/xml" , "application/json"}// this method can send
			// data in xml and json both
			// here it will by default return xml data to client
	)
	public Customer getCustomer() {// java object to json -> jackson api code no need.
		//jackson api logic is internally working .
		Customer c = new Customer();
		c.setName("John");
		c.setEmail("john@gmail.com");
		c.setGender("Male");
		return c;
		// if i write the logic of converting object to json then it will become tightly coupled with json

	}
	
	@PostMapping(// same URL pattern to both methods how? as different http request mapping
			value = "/customer",
			consumes = {"application/xml", "application/json"},
			produces = {"text/plain"}// this restApi produces text/plain as response
	)
	//client will send json or xml data as input in restAPI
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		// logic to insert customer in db
		return new ResponseEntity<>("Customer Saved", HttpStatus.CREATED);
	}
	// in the body put xml or json data in post man
	// and add content type application.xml or appilcation.json
	//@RequestBody Customer customer ,  if we dont add & requestBody it will print
	// all null values of the object data.
	// so we need to tell that this customer data will get from requestBody .
	//then my dispatcher servelet will under stand the data of customer is coming iwth request body
	//that that xml or json data and convert it to java object .
	// then restapi will use jaxB api to convert that xml to object using marshelling and unmarshelling
	// and pass that java object as parameter of that method.
}
