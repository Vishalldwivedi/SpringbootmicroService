package in.vishal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

	// http://localhost:8080/car/101/hyd
	@GetMapping("/car/{carId}/uttra")
	public ModelAndView getCarColor(@PathVariable Integer carId) {
		ModelAndView mav = new ModelAndView();

		String color = null;

		if (carId >= 100) {
			color = "blue";
		} else {
			color = "Black";
		}

		mav.addObject("msg", "Car Color is :" + color);

		mav.setViewName("index");

		return mav;
	}

	// http://localhost:8080/stock/tesla/location/uttrakhand

	@GetMapping("/stock/{brand}/location/{loc}")
	public ModelAndView getCarStock(@PathVariable String brand, @PathVariable String loc) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "In " + loc + " " + brand + " cars Out Of Stock");

		mav.setViewName("index");
		return mav;
	}

}
