package com.parking;

public class Vehicle {
	private String regNum;

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public Vehicle(String regNum) {
		this.regNum = regNum;
	}

	@Override
	public String toString() {
		return "Vehicle [regNum=" + regNum + "]";
	}
}
