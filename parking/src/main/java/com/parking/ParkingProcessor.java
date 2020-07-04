package com.parking;

public class ParkingProcessor {

	public void textInputProcessor(String input) {
		
		String[] inputArr = input.split(" ");
		switch (Commands.getEnum(inputArr[0])) {
		case CREATE:
			System.out.println("Create");
			break;
		
		case PARK:
			System.out.println("park");
			break;

		case LEAVE:
			System.out.println("leave");
			break;

		case STATUS:
			System.out.println("sttus");	
			break;

		default:
			break;
		}
		
	}

}
