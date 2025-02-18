package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Booking;
import com.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository br;
	
	@Autowired
	RestTemplate rt;
	
	public List<Booking> getBookings(){
		
		return br.findAll();
		
	}
	
	public String storeBooking(Booking b, String route, String typeOfCab) {
		
		//Retrieve and apply the fare.
		float price = calculateFare(route, typeOfCab);
		b.setPrice(price);
		
		//Store booking to database.
		br.saveAndFlush(b);
		return "Booking submitted. Your cab will arrive shortly";
		
	}
	
	public float calculateFare(String route, String typeOfCab) {
		
		float fare = rt.getForObject("http://CABFARE/cabfare/farePrice?route="+route+"&typeOfCab="+typeOfCab, Float.class);
		
		return fare;
	}
	
	public List<Booking> getBookings(String email){
		return br.getBookings(email);
	}
	
}
