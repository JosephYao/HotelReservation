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
	
	private static final Map<String, Integer> REGULAR_CUSTOMER_WEEKDAY_RATE = new HashMap<String, Integer>() {{
		put(HOTEL_LAKEWOOD, 110);
		put(HOTEL_BRIDGEWOOD, 160);
	}};
	
	private static final Map<String, Integer> REGULAR_CUSTOMER_WEEKEND_RATE = new HashMap<String, Integer>() {{
		put(HOTEL_LAKEWOOD, 90);
		put(HOTEL_BRIDGEWOOD, 60);
	}};
	
	private static final Map<String, Integer> REWARDS_CUSTOMER_WEEKDAY_RATE = new HashMap<String, Integer>() {{
		put(HOTEL_LAKEWOOD, 80);
		put(HOTEL_RIDGEWOOD, 100);
	}};
	
	private static final Map<String, Integer> REWARDS_CUSTOMER_WEEKEND_RATE = new HashMap<String, Integer>() {{
		put(HOTEL_LAKEWOOD, 80);
		put(HOTEL_RIDGEWOOD, 40);
	}};
	
	public String reserve(String customerAndDates) {
		if (isCustomer(customerAndDates, CUSTOMER_REGULAR) &&
			hotelPriceForRegular(customerAndDates, HOTEL_LAKEWOOD) > 
			hotelPriceForRegular(customerAndDates, HOTEL_BRIDGEWOOD))
			return HOTEL_BRIDGEWOOD;
		
		if (isCustomer(customerAndDates, CUSTOMER_REWARDS) &&
			hotelPriceForRewards(customerAndDates, HOTEL_LAKEWOOD) >
			hotelPriceForRewards(customerAndDates, HOTEL_RIDGEWOOD))
			return HOTEL_RIDGEWOOD;
		
		return HOTEL_LAKEWOOD;
	}

	private int hotelPriceForRewards(String customerAndDates, String hotel) {
		return allDayCount(customerAndDates, WEEKDAYS) * REWARDS_CUSTOMER_WEEKDAY_RATE.get(hotel) + 
			   allDayCount(customerAndDates, WEEKENDS) * REWARDS_CUSTOMER_WEEKEND_RATE.get(hotel);
	}
	
	private int hotelPriceForRegular(String customerAndDates, String hotel) {
		return allDayCount(customerAndDates, WEEKDAYS) * REGULAR_CUSTOMER_WEEKDAY_RATE.get(hotel) + 
			   allDayCount(customerAndDates, WEEKENDS) * REGULAR_CUSTOMER_WEEKEND_RATE.get(hotel);
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
