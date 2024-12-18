package in.ashokit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
	
	private Logger logger =  LoggerFactory.getLogger(MessageController.class);

	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model) {

		logger.info("***** welcomeMsg() execution started *****");
		
		model.addAttribute("msg", "Welcome To Thymeleaf App");
		
		logger.info("***** welcomeMsg() execution ended *****");

		return "index";
	}
}
