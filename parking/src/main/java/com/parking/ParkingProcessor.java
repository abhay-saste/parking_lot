package com.parking;

public class ParkingProcessor {
	ParkingService service = new ParkingSeviceImpl();
	public void textInputProcessor(String input) {		
		String[] inputArr = input.split(" ");
		switch (Commands.getEnum(inputArr[0])) {
		case CREATE:
			int capacity=Integer.parseInt(inputArr[1]);
			service.createParkingLot(capacity);
			break;
		
		case PARK:
			Vehicle vehicle=new Vehicle(inputArr[1]);
			service.park(vehicle);
			break;

		case LEAVE:
			Vehicle v=new Vehicle(inputArr[1]);
			int time=Integer.parseInt(inputArr[2]);
			service.leave(v, time);
			break;

		case STATUS:
			service.status();
			break;

		default:
			break;
		}
		
	}

}
