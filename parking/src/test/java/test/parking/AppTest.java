package test.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.parking.ParkingService;
import com.parking.ParkingSeviceImpl;
import com.parking.Vehicle;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
	ByteArrayOutputStream out =new ByteArrayOutputStream();
	
	@Before
	public void init() {
		System.setOut(new PrintStream(out));
	}
	@After
	public void cleanUp() {
		System.setOut(null);
	}
	@Test
	public void createParkingLotTest(){
		ParkingService service=new ParkingSeviceImpl();
		service.createParkingLot(6);
		assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(out.toString().trim().replace(" ", "")));
		service.cleanUp();
	}
	@Test
	public  void parkingCapacityTest() {
		ParkingService service=new ParkingSeviceImpl();
		service.createParkingLot(6);
		service.park(new Vehicle("abc"));
		service.park(new Vehicle("def"));
		service.park(new Vehicle("ghi"));
		assertEquals(3, service.getCurrentParkingCount());
		service.cleanUp();
	}

	@Test
	public void parkingNotCreatedTest() {
		ParkingService service=new ParkingSeviceImpl();
		service.park(new Vehicle("aaa"));
		assertTrue("Parkinglotisnotcreated.".equalsIgnoreCase((out.toString().trim().replace(" ", ""))));	
		service.cleanUp();
	}
	
	@Test
	public void leaveTest() {
		ParkingService service=new ParkingSeviceImpl();
		service.createParkingLot(2);
		service.park(new Vehicle("abc"));
		service.park(new Vehicle("def"));
		service.leave(new Vehicle("def"), 5);
		assertEquals(1, service.getCurrentParkingCount());
		service.cleanUp();
	}
	
}
