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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNum == null) ? 0 : regNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (regNum == null) {
			if (other.regNum != null)
				return false;
		} else if (!regNum.equals(other.regNum))
			return false;
		return true;
	}
	
}
