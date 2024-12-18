package in.vishal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {

	@GetMapping("/welcome")
	@ResponseBody// to send direct msg to client without view file .
	public String getWelcomeMsg() {
		return "Welcome to vishal app..!!";
	}
	// here i am not returning a view page i am only returning a msg

	@GetMapping("/greet")// spring is rendering that view file in the browser
	// it is cosidering that index as a view file
	public String getGreetMsg(Model model) {
		model.addAttribute("msg", "Good Evening");
		return "index";
	}
}