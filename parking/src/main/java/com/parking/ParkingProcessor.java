package com.parking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	public void fileInputProcessor(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
		String line=null;
			try {
				while((line=reader.readLine())!=null) {
					textInputProcessor(line.trim());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
