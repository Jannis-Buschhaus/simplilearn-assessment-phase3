package com.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	private String email;
	private String fareFrom;
	private String fareTo;
	private String typeOfCab;
	private float price;
	private Timestamp time;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(String email, String fareFrom, String fareTo, String typeOfCab, Timestamp time) {
		super();
		this.email = email;
		this.fareFrom = fareFrom;
		this.fareTo = fareTo;
		this.typeOfCab = typeOfCab;
		this.time = time;
	}
	public Booking(int bookingId, String email, String fareFrom, String fareTo, String typeOfCab, float price, Timestamp time) {
		super();
		this.bookingId = bookingId;
		this.email = email;
		this.fareFrom = fareFrom;
		this.fareTo = fareTo;
		this.typeOfCab = typeOfCab;
		this.price = price;
		this.time = time;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFareFrom() {
		return fareFrom;
	}
	public void setFareFrom(String fareFrom) {
		this.fareFrom = fareFrom;
	}
	public String getFareTo() {
		return fareTo;
	}
	public void setFareTo(String fareTo) {
		this.fareTo = fareTo;
	}
	public String getTypeOfCab() {
		return typeOfCab;
	}
	public void setTypeOfCab(String typeOfCab) {
		this.typeOfCab = typeOfCab;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", email=" + email + ", fareFrom=" + fareFrom + ", fareTo="
				+ fareTo + ", typeOfCab=" + typeOfCab + ", price=" + price + ", time=" + time + "]";
	}
}
