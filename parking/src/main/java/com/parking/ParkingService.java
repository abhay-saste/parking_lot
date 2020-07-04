package com.parking;

public interface ParkingService {
	public void createParkingLot(int capacity);
	public void park(Vehicle vehicle);
	public void leave(int slot, int time);
	public void status();

}
