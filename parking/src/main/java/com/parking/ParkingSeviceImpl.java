package com.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class ParkingSeviceImpl implements ParkingService{

	int availability=0;
	Map<Integer, Vehicle>parkingLayout=new HashMap<Integer, Vehicle>();
	TreeSet<Integer> freeSlot=new TreeSet<Integer>();
	public void createParkingLot(int capacity) {
		this.availability=capacity;
		for (int i = 1; i <=capacity ; i++) {
			parkingLayout.put(i, null);
			freeSlot.add(i);
		}
		System.out.println("Created parking lot with "+capacity+" slots");
	}

	public void park(Vehicle vehicle) {
		if(availability==0) {
			System.out.println("Sorry, parking lot is full");
		}else if(parkingLayout.containsValue(vehicle)){
			System.out.println("Already parked");
		}else {
			Integer slot = freeSlot.first();
			parkingLayout.put(slot, vehicle);
			availability--;
			freeSlot.remove(slot);
			System.out.println("Allocated slot number: "+slot);
		}
		
	}

	public void leave(Vehicle vehicle, int time) {
		int slot = 0;
		for ( Entry<Integer, Vehicle> entry : parkingLayout.entrySet()) {
			if(vehicle.equals(entry.getValue())) {
				slot=entry.getKey();
			}
		}
		if(parkingLayout.get(slot)==null){
			System.out.println("Registration number "+vehicle.getRegNum()+" not found");
		}else {
			int charges=calculateCharges(time);
			
			parkingLayout.put(slot,null);
			availability++;
			freeSlot.add(slot);		
			System.out.println("Registration number "+vehicle.getRegNum()+" with Slot Number "+slot+" is free with Charge "+charges);
		}
	}

	
	public void status() {
		System.out.println("Slot No.   Registration No.");
		for ( Entry<Integer, Vehicle> map : parkingLayout.entrySet()) {
			if(map.getValue()!=null) {
				System.out.println(map.getKey()+"   "+map.getValue().getRegNum());
			}
			
		}
	}
	private int calculateCharges(int time) {
		return (time<=2)?10:10+(time-2)*10;
		
	}
}
