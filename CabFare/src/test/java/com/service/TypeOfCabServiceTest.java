package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.TypeOfCab;

@SpringBootTest
class TypeOfCabServiceTest {
	
	@Autowired
	TypeOfCabService ts;

	@Test
	void testGetPriceFactor() {
		float factor=ts.getPriceFactor("Standard");
		assertEquals(factor, (float)1.0);
		
		factor=ts.getPriceFactor("Small");
		assertEquals(factor, (float)0.8);
		
		factor=ts.getPriceFactor("Premium");
		assertEquals(factor, (float)1.2);
	}

	@Test
	void testGetCabTypes() {
		List<TypeOfCab> lt = ts.getCabTypes();
		assertTrue(lt.size() == 3);
	}

}
