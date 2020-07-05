package com.parking;

public enum Commands {
	CREATE("create_parking_lot"),
	PARK("park"),
	LEAVE("leave"),
	STATUS("status");
	
	Commands(String value){
		this.value=value;
	}
	public String getValue(){
		return value;
	}
	public static Commands getEnum(String value) {
		for ( Commands v : values()) {
			if(v.getValue().equals(value)) {
				return v;
			}
			
		}
		System.out.println("Command not identified.");
		return null;
	}
	String value;
}
