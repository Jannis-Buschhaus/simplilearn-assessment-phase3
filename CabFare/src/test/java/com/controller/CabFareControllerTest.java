package com.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;

import com.entity.TypeOfCab;
import com.service.CabFaresService;
import com.service.TypeOfCabService;

@SpringBootTest
class CabFareControllerTest {
	
	@Mock
	TypeOfCabService ts;
	
	@Mock
	CabFaresService cs;
	
	@InjectMocks
	CabFareController cc;

	@Test
	void testFactor() {
		MockHttpServletRequest req = new MockHttpServletRequest();
		
		req.setParameter("typeOfCab", "Small");
		Mockito.when(ts.getPriceFactor(req.getParameter("typeOfCab"))).thenReturn((float)0.8);
		String result = cc.factor(req);
		assertEquals(result, "0.8");
		
		req.setParameter("typeOfCab", "Standard");
		Mockito.when(ts.getPriceFactor(req.getParameter("typeOfCab"))).thenReturn((float)1.0);
		result = cc.factor(req);
		assertEquals(result, "1.0");
		
		req.setParameter("typeOfCab", "Premium");
		Mockito.when(ts.getPriceFactor(req.getParameter("typeOfCab"))).thenReturn((float)1.2);
		result = cc.factor(req);
		assertEquals(result, "1.2");
	}

	@Test
	void testGetCabTypes() {
		List<TypeOfCab> lt = new ArrayList<TypeOfCab>();
		lt.add(new TypeOfCab(1, "Standard", (float)1.0));
		Mockito.when(ts.getCabTypes()).thenReturn(lt);
		
		assertFalse(cc.getCabTypes().isEmpty());
	}

	@Test
	void testGetCabFares() {
		List<String> ls = new ArrayList<String>();
		ls.add("Airport -> Train Station");
		Mockito.when(cs.getCabFares()).thenReturn(ls);
		
		assertFalse(cc.getCabFares().isEmpty());
	}

	@Test
	void testFarePrice() {
		MockHttpServletRequest req = new MockHttpServletRequest();
		
		req.setParameter("route", "Airport -> Train Station");
		req.setParameter("typeOfCab", "Standard");
		Mockito.when(cs.getFarePrice("Airport", "Train Station", "Standard")).thenReturn((float)49.0);
		float result = cc.farePrice(req);
		assertEquals(result, 49.0);
	}

}
