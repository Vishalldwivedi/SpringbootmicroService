package in.vishal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/welcome/randi")
	public ModelAndView getWelcomeMsg() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "Wecome To keys");

		mav.setViewName("index");

		return mav;
	}

	@GetMapping("/greet")
	public ModelAndView getGreetMsg() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "Good Evening...!!");

		mav.setViewName("index");

		return mav;
	}

}
