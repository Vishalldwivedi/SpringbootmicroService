package in.vishal.config;

import org.springframework.batch.item.ItemProcessor;

import in.vishal.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {

		// logic

		return item;
	}

}
