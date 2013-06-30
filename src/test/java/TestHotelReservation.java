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
	
	@Test
	public void rewards_customer_reserve_one_weekday() {
		assertReservedHotelEquals("Lakewood", "Rewards: 24Jun2013(mon)");
		assertReservedHotelEquals("Lakewood", "Rewards: 25Jun2013(tues)");
		assertReservedHotelEquals("Lakewood", "Rewards: 26Jun2013(wed)");
		assertReservedHotelEquals("Lakewood", "Rewards: 27Jun2013(thur)");
		assertReservedHotelEquals("Lakewood", "Rewards: 28Jun2013(fri)");
	}
	
	@Test
	public void regular_customer_reserve_both_weekday_and_weekend() {
		assertReservedHotelEquals("Bridgewood", "Regular: 24Jun2013(mon), 29Jun2013(sat), 30Jun2013(sun)");
		assertReservedHotelEquals("Lakewood", "Regular: 24Jun2013(mon), 25Jun2013(tues), 29Jun2013(sat), 30Jun2013(sun)");
		assertReservedHotelEquals("Bridgewood", "Regular: 25Jun2013(tues), 29Jun2013(sat), 30Jun2013(sun)");
	}
	
	private void assertReservedHotelEquals(String expectedReservedHotel, String customerAndDates) {
		String actualReservedHotel = hotelReservationHelper.reserve(customerAndDates);
		assertEquals(expectedReservedHotel, actualReservedHotel);
	}
	
}
