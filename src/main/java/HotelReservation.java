import java.util.HashMap;
import java.util.Map;

public class HotelReservation {

	private static final String[] WEEKDAYS = new String[]{"mon", "tues", "wed", "thur", "fri"};
	private static final String[] WEEKENDS = new String[]{"sat", "sun"};
	
	private static final Map<String, Integer> REGULAR_CUSTOMER_RATE = new HashMap<String, Integer>() {{
		put("Lakewood", 110);
		put("Bridgewood", 160);
	}};
	
	private static final Map<String, Integer> REWARDS_CUSTOMER_RATE = new HashMap<String, Integer>() {{
		put("Lakewood", 90);
		put("Bridgewood", 60);
	}};
	
	public String reserve(String customerAndDates) {
		if (isCustomer(customerAndDates, "Regular") &&
			hotelPrice(customerAndDates, "Lakewood") > 
			hotelPrice(customerAndDates, "Bridgewood"))
			return "Bridgewood";
		
		for (String weekDay : WEEKDAYS)
			if (customerAndDates.contains(weekDay))
				return "Lakewood";
		
		if (isCustomer(customerAndDates, "Rewards"))
			return "Ridgewood";
		
		return "Bridgewood";
	}

	private int hotelPrice(String customerAndDates, String hotel) {
		return allDayCount(customerAndDates, WEEKDAYS) * REGULAR_CUSTOMER_RATE.get(hotel) + 
			   allDayCount(customerAndDates, WEEKENDS) * REWARDS_CUSTOMER_RATE.get(hotel);
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
