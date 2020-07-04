package com.parking;

public interface ParkingService {
	public void createParkingLot(int capacity);
	public void park(Vehicle vehicle);
	public void leave(Vehicle vehicle, int time);
	public void status();

}
