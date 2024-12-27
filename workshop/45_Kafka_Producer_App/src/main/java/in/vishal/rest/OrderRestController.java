package in.vishal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vishal.model.Order;
import in.vishal.service.OrderService;

@RestController
public class OrderRestController {
	@Autowired
	private OrderService service;
	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		String msg = service.addMsg(order);//what every order i am giving
		// that will beconverted to json
		return msg;
	}
}
