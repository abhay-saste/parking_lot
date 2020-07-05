package com.parking;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class Validations {
	
	public static boolean validate(String input) {
		String[] arr=input.split(" ");
		Commands commands=Commands.getEnum(arr[0]);
		if(commands!=null && M.containsKey(commands)) {
			return M.get(commands)==arr.length-1;
		}
		return false;
	}

	private static Map<Commands, Integer> M = Collections.unmodifiableMap(initMap());

	private static Map<Commands, Integer> initMap() {
		Map<Commands, Integer>map=new EnumMap<Commands, Integer>(Commands.class);
		map.put(Commands.CREATE, 1);
		map.put(Commands.PARK, 1);
		map.put(Commands.LEAVE, 2);
		map.put(Commands.STATUS, 0);
		return map;
	}
}
