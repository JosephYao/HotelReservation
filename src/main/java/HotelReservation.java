import java.util.HashMap;
import java.util.Map;

public class HotelReservation {

	private static final String CUSTOMER_REWARDS = "Rewards";
	private static final String CUSTOMER_REGULAR = "Regular";
	private static final String HOTEL_RIDGEWOOD = "Ridgewood";
	private static final String HOTEL_BRIDGEWOOD = "Bridgewood";
	private static final String HOTEL_LAKEWOOD = "Lakewood";
	private static final String[] WEEKDAYS = new String[]{"mon", "tues", "wed", "thur", "fri"};
	private static final String[] WEEKENDS = new String[]{"sat", "sun"};
	
	private static final Map<String, Integer> CUSTOMER_WEEKDAY_RATE = new HashMap<String, Integer>() {{
		put(HOTEL_LAKEWOOD + CUSTOMER_REGULAR, 110);
		put(HOTEL_BRIDGEWOOD + CUSTOMER_REGULAR, 160);
		put(HOTEL_LAKEWOOD + CUSTOMER_REWARDS, 80);
		put(HOTEL_RIDGEWOOD + CUSTOMER_REWARDS, 100);
	}};
	
	private static final Map<String, Integer> CUSTOMER_WEEKEND_RATE = new HashMap<String, Integer>() {{
		put(HOTEL_LAKEWOOD + CUSTOMER_REGULAR, 90);
		put(HOTEL_BRIDGEWOOD + CUSTOMER_REGULAR, 60);
		put(HOTEL_LAKEWOOD + CUSTOMER_REWARDS, 80);
		put(HOTEL_RIDGEWOOD + CUSTOMER_REWARDS, 40);
	}};
	
	public String reserve(String customerAndDates) {
		if (isCustomer(customerAndDates, CUSTOMER_REGULAR) &&
			isHotelPriceLargerOrEquals(customerAndDates, CUSTOMER_REGULAR, 
					HOTEL_LAKEWOOD, HOTEL_BRIDGEWOOD))
			return HOTEL_BRIDGEWOOD;
		
		if (isCustomer(customerAndDates, CUSTOMER_REWARDS) &&
			isHotelPriceLargerOrEquals(customerAndDates, CUSTOMER_REWARDS, 
					HOTEL_LAKEWOOD, HOTEL_RIDGEWOOD))
			return HOTEL_RIDGEWOOD;
		
		return HOTEL_LAKEWOOD;
	}

	private boolean isHotelPriceLargerOrEquals(String customerAndDates, String customerType, String firstHotel, String secondHotel) {
		return hotelPrice(customerAndDates, firstHotel, customerType) >= 
		hotelPrice(customerAndDates, secondHotel, customerType);
	}

	private int hotelPrice(String customerAndDates, String hotel, String customer) {
		return allDayCount(customerAndDates, WEEKDAYS) * CUSTOMER_WEEKDAY_RATE.get(hotel + customer) + 
			   allDayCount(customerAndDates, WEEKENDS) * CUSTOMER_WEEKEND_RATE.get(hotel + customer);
	}
	
	private int allDayCount(String customerAndDates, String[] days) {
		int count = 0;
		
		for (String day : days)
			count += oneDayCount(customerAndDates, day);
		
		return count;
	}

	private int oneDayCount(String customerAndDates, String weekendStr) {
		return customerAndDates.split(weekendStr).length - 1;
	}
	
	private boolean isCustomer(String customerAndDates, String customerType) {
		return customerAndDates.startsWith(customerType);
	}

}
