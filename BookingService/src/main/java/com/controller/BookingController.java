package com.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.entity.Booking;
import com.service.BookingService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bs;
	
	@Autowired
	RestTemplate rt;
	
	private void getFormInfo(Model m){
		List<Object> cabTypes = rt.getForObject("http://CABFARE/cabfare/cabTypes", List.class);
		m.addAttribute("cabTypes", cabTypes);
		List<String> cabFares = rt.getForObject("http://CABFARE/cabfare/cabFares", List.class);
		m.addAttribute("cabFares", cabFares);
	}
	
	@GetMapping(value={"/", "welcome"})
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping(value="/bookingForm")
	public String bookingForm(Model m) {
		getFormInfo(m);
		return "bookingForm";
	}
	
	@PostMapping(value="placeBooking")
	public String placeBooking(Model m, HttpServletRequest req){
		// retrieve POST-Request Parameters
		String route = req.getParameter("route");
		String typeOfCab = req.getParameter("typeOfCab");
		String[] from_to = route.split(" -> ");
		
		//Initialize a new Cab Booking
		Booking b = new Booking(
			req.getParameter("email"),
			from_to[0],
			from_to[1],
			typeOfCab,
			new Timestamp(System.currentTimeMillis())
		);
		
		// Pass down the booking object to the Service layer.
		m.addAttribute("msg", bs.storeBooking(b, route, typeOfCab));
		
		//Get CabTypes and Routes for next page.
		getFormInfo(m);
		
		return "bookingForm";
		
	}
	
	@GetMapping(value="calculateFare")
	public String calculateFare(Model m) {
		getFormInfo(m);
		return "calculateFare";
	}
	
	@PostMapping(value="calculateFare")
	public String calculateFarePost(Model m, HttpServletRequest req) {
		
		String route = req.getParameter("route");
		String typeOfCab = req.getParameter("typeOfCab");
		
		Float price = bs.calculateFare(route, typeOfCab);
		m.addAttribute("price", price);
		
		getFormInfo(m);
		
		return "calculateFare";
	}
	
	@GetMapping(value="listBookings")
	public String listBookings(Model m) {
		return "listBookings";
	}
	
	@PostMapping(value="listBookings")
	public String listBookingsPost(Model m, HttpServletRequest req) {
		
		String email = req.getParameter("email");
		List<Booking> lb = bs.getBookings(email);
		m.addAttribute("email", email);
		m.addAttribute("bookings", lb);
		
		return "listBookings";
	}
	
}
