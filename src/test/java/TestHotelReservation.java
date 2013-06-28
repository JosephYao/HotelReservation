import static org.junit.Assert.*;

import org.junit.Test;


public class TestHotelReservation {

	private HotelReservation hotelReservationHelper = new HotelReservation();
	
	@Test
	public void regular_customer_reserve_one_weekday() {
		assertReservedHotelEquals("Lakewood", "Regular: 24Jun2013(mon)");
	}

	@Test
	public void regular_customer_reserve_one_weekend() {
		assertReservedHotelEquals("Bridgewood", "Regular: 29Jun2013(sat)");
	}
	
	@Test
	public void rewards_customer_reserve_one_weekend() {
		assertReservedHotelEquals("Ridgewood", "Rewards: 29Jun2013(sat)");
	}

	private void assertReservedHotelEquals(String expectedReservedHotel, String customerAndDates) {
		String actualReservedHotel = hotelReservationHelper.reserve(customerAndDates);
		assertEquals(expectedReservedHotel, actualReservedHotel);
	}
	
}
