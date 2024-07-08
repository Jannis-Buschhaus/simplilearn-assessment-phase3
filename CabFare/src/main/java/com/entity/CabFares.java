package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CabFares {

	@Id
	private int cabFareId;
	private String fare_from;
	private String fare_to;
	private float price;
	
	public CabFares() {
		super();
	}
	
	
	
	
	public CabFares(int cabFareId, String fare_from, String fare_to, float price) {
		super();
		this.cabFareId = cabFareId;
		this.fare_from = fare_from;
		this.fare_to = fare_to;
		this.price = price;
	}

	public int getCabFareId() {
		return cabFareId;
	}
	public void setCabFareId(int cabFareId) {
		this.cabFareId = cabFareId;
	}
	public String getFare_from() {
		return fare_from;
	}
	public void setFare_from(String fare_from) {
		this.fare_from = fare_from;
	}
	public String getFare_to() {
		return fare_to;
	}
	public void setFare_to(String fare_to) {
		this.fare_to = fare_to;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CabFares [cabFareId=" + cabFareId + ", fare_from=" + fare_from + ", fare_to=" + fare_to + ", price="
				+ price + "]";
	}
}
