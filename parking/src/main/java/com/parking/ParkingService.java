package com.parking;

public interface ParkingService {
	public void createParkingLot(int capacity);
	public void park(Vehicle vehicle);
	public void leave(int lot, int time);
	public void status();

}
