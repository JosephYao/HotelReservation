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
	public void regular_customer_reserve_both_weekday_and_weekend_within_one_week() {
		assertReservedHotelEquals("Bridgewood", "Regular: 24Jun2013(mon), 29Jun2013(sat), 30Jun2013(sun)");
		assertReservedHotelEquals("Lakewood", "Regular: 24Jun2013(mon), 25Jun2013(tues), 29Jun2013(sat), 30Jun2013(sun)");
		assertReservedHotelEquals("Bridgewood", "Regular: 25Jun2013(tues), 29Jun2013(sat), 30Jun2013(sun)");
		assertReservedHotelEquals("Lakewood", "Regular: 24Jun2013(mon), 1Jul2013(mon), 29Jun2013(sat), 30Jun2013(sun)");
	}
	
	@Test
	public void regular_customer_reserve_both_weekday_and_weekend_within_two_weeks() {
		assertReservedHotelEquals("Bridgewood", "Regular: 25Jun2013(tues), 29Jun2013(sat), 6Jul2013(sat)");
		assertReservedHotelEquals("Bridgewood", "Regular: 25Jun2013(tues), 30Jun2013(sun), 7Jul2013(sun)");
		assertReservedHotelEquals("Bridgewood", "Regular: 24Jun2013(mon), 25Jun2013(tues), 29Jun2013(sat), 30Jun2013(sun), 6JUl2013(sat), 7Jul2013(sun)");
	}
	
	@Test
	public void rewards_customer_reserve_both_weekday_and_weekend_within_one_week() {
		assertReservedHotelEquals("Ridgewood", "Rewards: 24Jun2013(mon), 29Jun2013(sat)");
		assertReservedHotelEquals("Ridgewood", "Rewards: 24Jun2013(mon), 25Jun2013(tues), 29Jun2013(sat), 30Jun2013(sun)");
	}
	
	@Test
	public void rewards_customer_get_reserved_hotel_by_rank() {
		assertReservedHotelEquals("Ridgewood", "Rewards: 24Jun2013(mon), 25Jun2013(tues), 29Jun2013(sat)");
	}
	
	@Test
	public void regular_customer_get_reserved_hotel_by_rank() {
		assertReservedHotelEquals("Bridgewood", "Regular: 24Jun2013(mon), 25Jun2013(tues), 26Jun2013(wed), 29Jun2013(sat), 30Jun2013(sun), 6JUl2013(sat), 7Jul2013(sun), 13Jul2013(sat)");
	}
	
	@Test
	public void acceptance_test() {
		assertReservedHotelEquals("Lakewood", "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		assertReservedHotelEquals("Bridgewood", "Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)");
		assertReservedHotelEquals("Ridgewood", "Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
	}
	
	private void assertReservedHotelEquals(String expectedReservedHotel, String customerAndDates) {
		String actualReservedHotel = hotelReservationHelper.reserve(customerAndDates);
		assertEquals(expectedReservedHotel, actualReservedHotel);
	}
	
}
