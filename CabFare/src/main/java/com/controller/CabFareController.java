package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CabFares;
import com.entity.TypeOfCab;
import com.service.CabFaresService;
import com.service.TypeOfCabService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/cabfare")
public class CabFareController {

	@Autowired
	TypeOfCabService ts;
	@Autowired 
	CabFaresService cs;
	
	@GetMapping(value="factor", produces=MediaType.TEXT_PLAIN_VALUE)
	public String factor(HttpServletRequest req) {
		return String.valueOf(ts.getPriceFactor(req.getParameter("typeOfCab")));
	}
	
	@GetMapping(value="cabTypes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TypeOfCab> getCabTypes() {
		return ts.getCabTypes();
	}
	
	@GetMapping(value="cabFares", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCabFares(){
		return cs.getCabFares();
	}
	
	@GetMapping(value="farePrice", produces=MediaType.APPLICATION_JSON_VALUE)
	public float farePrice(HttpServletRequest req){
		String[] route = req.getParameter("route").split(" -> ");
		String fare_from = route[0];
		String fare_to = route[1];
		
		return cs.getFarePrice(fare_from, fare_to, req.getParameter("typeOfCab"));
	}
}
