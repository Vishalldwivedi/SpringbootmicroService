package in.vishal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.vishal.request.Passenger;
import in.vishal.response.Ticket;
import in.vishal.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}
	
	@GetMapping("/searchTicket")
	public String searchTicket(@RequestParam("ticketId") String ticketId, Model model) {
		Ticket ticketInfo = service.getTicketInfo(ticketId);
		model.addAttribute("ticket", ticketInfo);
		return "search";
	}

	@PostMapping("/bookTicket")
	public String bookTicket(Passenger request, Model model) {
		Ticket ticketInfo = service.processTicketBooking(request);
		model.addAttribute("ticket", ticketInfo);
		return "success";
	}
	
	
}
