package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CabFares;
import com.repository.CabFaresRepository;

@Service
public class CabFaresService {
	
	@Autowired
	CabFaresRepository cr;
	@Autowired
	TypeOfCabService ts;
	
	public List<String> getCabFares(){
		
		List<CabFares> lc = cr.findAll();
		Iterator<CabFares> ii = lc.iterator();
		List<String> formList = new ArrayList<String>() ;
	
		while(ii.hasNext()) {
			CabFares cc = ii.next();
			formList.add(cc.getFare_from()+" -> "+cc.getFare_to());
		}
		return formList;
	}
	
	public float getFarePrice(String fare_from, String fare_to, String typeOfCab){
		float farePrice = cr.getFarePrice(fare_from, fare_to);
		float factor = ts.getPriceFactor(typeOfCab);
		return farePrice*factor;
	}
}
