package in.vishal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.vishal.service.CustomerService;

@RestController
public class CustomerRestController{

	@Autowired
	private CustomerService service;

	@GetMapping("/customer/{customerId}")// excepting customer input in URL
	// this pathVariable will tell the in req get URL u will have CustomerId
	public String getCustomerName(@PathVariable Integer customerId) throws Exception {
		return service.getCustomerNameIDD(customerId);
		// if u put wrong customerID its clint problem but its shwoing 500 status cose
		//which is a server problem
		// there for we need to create exception info class .
		//
	}
}
