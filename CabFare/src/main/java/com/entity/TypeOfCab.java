package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TypeOfCab {

	@Id
	private int cabId;
	private String cabType;
	private float factor;
	
	public TypeOfCab() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeOfCab(int cabId, String cabType, float factor) {
		super();
		this.cabId = cabId;
		this.cabType = cabType;
		this.factor = factor;
	}
	
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCabType() {
		return cabType;
	}
	public void setCabType(String cabType) {
		this.cabType = cabType;
	}
	public float getFactor() {
		return factor;
	}
	public void setFactor(float factor) {
		this.factor = factor;
	}
	
	@Override
	public String toString() {
		return "TypeOfCab [cabId=" + cabId + ", cabType=" + cabType + ", factor=" + factor + "]";
	}
}