package com.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Booking;
import com.repository.BookingRepository;

@SpringBootTest
class BookingServiceTest {

	@Autowired BookingService bs;
	
	@Autowired BookingRepository br;
	
	@Test
	void testGetBookings() {
		assertDoesNotThrow(() -> bs.getBookings());
	}

	@Test
	void testStoreBooking() {
		Booking b = new Booking(
				"test@example.com", 
				"Airport", 
				"Train Station", 
				"Standard",
				new Timestamp(System.currentTimeMillis())
				);
		String route = "Airport -> Train Station";
		String typeOfCab = "Standard";
		String result = bs.storeBooking(b, route, typeOfCab);
		assertEquals(result, "Booking submitted. Your cab will arrive shortly");
		
		List<Booking> lb = br.getBookings(b.getEmail());
		assertFalse(lb.isEmpty());
		
		Booking bb = lb.get(0);
		assertEquals(bb.getFareFrom(), "Airport");
		assertEquals(bb.getFareTo(), "Train Station");
		assertEquals(bb.getTypeOfCab(), "Standard");
		
		br.delete(bb);
		
	}

	@Test
	void testCalculateFare() {
		String route = "Airport -> Train Station";
		String typeOfCab = "Standard";
		
		float result = bs.calculateFare(route, typeOfCab);
		assertEquals(result, (float)49.0);
	}

	@Test
	void testGetBookingsString() {
		assertDoesNotThrow(() -> bs.getBookings("test@example.com"));
	}

}
