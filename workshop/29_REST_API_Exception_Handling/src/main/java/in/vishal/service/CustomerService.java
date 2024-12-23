package in.vishal.service;

import org.springframework.stereotype.Service;

import in.vishal.exception.CustomerNotFoundException;

@Service
public class CustomerService {

	public String getCustomerNameIDD(Integer customerId) {
		if (customerId >= 100) {
			return "vishal dwivedi ";
		} else {
			throw new CustomerNotFoundException("Invalid customer id");
		}
	}
}