package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.repository.CabFaresRepository;

@SpringBootTest
class CabFaresServiceTest {
	
	@Autowired
	CabFaresService cs;
	@Autowired CabFaresRepository cr;

	@Test
	void testGetCabFares() {
		List<String> result = cs.getCabFares();
		assertFalse(result.isEmpty());
	}

	@Test
	void testGetFarePrice() {
		float result = cs.getFarePrice("Airport", "Train Station", "Standard");
		assertEquals(result, (float)49.0);
	}

}
