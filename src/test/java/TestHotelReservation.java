import static org.junit.Assert.*;

import org.junit.Test;


public class TestHotelReservation {

	@Test
	public void regular_customer_reserve_monday() {
		HotelReservation hotelReservationHelper = new HotelReservation();
		String actualReservedHotel = hotelReservationHelper.reserve("Regular: 16Mar2009(mon)");
		assertEquals("Lakewood", actualReservedHotel);
	}

}
