package com.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Welcome to parking service" );
        System.out.println( "Enter input...(Type 'exit' to close)" );
        ParkingProcessor processor=new ParkingProcessor();
        switch (args.length) {
		case 0:
			while(true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        String input = reader.readLine().trim();
			if(input.equalsIgnoreCase("exit")) {
				System.out.println("Thank you. Bye.");
				break;
			}
			 processor.textInputProcessor(input);
		        
			}
			break;
		case 1:
			processor.fileInputProcessor(args[0]);
			break;

		default:
			break;
		}
        
    }
}
