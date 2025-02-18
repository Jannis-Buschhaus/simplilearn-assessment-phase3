package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.TypeOfCab;
import com.repository.TypeOfCabRepository;

@Service
public class TypeOfCabService {
	
	@Autowired
	TypeOfCabRepository tr;
	
	public float getPriceFactor(String cabType) {
		return tr.getPriceFactor(cabType);
	}
	
	public List<TypeOfCab> getCabTypes() {
		return tr.findAll();
	}
}
