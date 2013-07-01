import java.util.HashMap;
import java.util.Map;




public class HotelReservation {

	private static final String[] WEEK_DAYS = new String[]{"mon", "tues", "wed", "thur", "fri"};
	
	private static final Map<String, Integer> REGULAR_CUSTOMER_RATE = new HashMap<String, Integer>() {{
		put("Lakewood", 110);
		put("Bridgewood", 160);
	}};
	
	private static final Map<String, Integer> REWARDS_CUSTOMER_RATE = new HashMap<String, Integer>() {{
		put("Lakewood", 90);
		put("Bridgewood", 60);
	}};
	
	public String reserve(String customerAndDates) {
		if (isRegularCustomer(customerAndDates) &&
			hotelPrice(customerAndDates, "Lakewood") > 
			hotelPrice(customerAndDates, "Bridgewood"))
			return "Bridgewood";
		
		for (String weekDay : WEEK_DAYS)
			if (customerAndDates.contains(weekDay))
				return "Lakewood";
		
		if (isRewardsCustomer(customerAndDates))
			return "Ridgewood";
		
		return "Bridgewood";
	}

	private int hotelPrice(String customerAndDates, String hotel) {
		return getWeekdayCount(customerAndDates) * REGULAR_CUSTOMER_RATE.get(hotel) + 
			   getWeekendCount(customerAndDates) * REWARDS_CUSTOMER_RATE.get(hotel);
	}
	
	private int getWeekendCount(String customerAndDates) {
		return weekendCount(customerAndDates, "sat") + 
			   weekendCount(customerAndDates, "sun");
	}

	private int weekendCount(String customerAndDates, String weekendStr) {
		return customerAndDates.split(weekendStr).length - 1;
	}

	private int getWeekdayCount(String customerAndDates) {
		int count = 0;
		
		for (String weekDay : WEEK_DAYS)
			if (customerAndDates.contains(weekDay))
				count++;
		
		return count;
	}

	private boolean isRewardsCustomer(String customerAndDates) {
		return customerAndDates.startsWith("Rewards");
	}

	private boolean isRegularCustomer(String customerAndDates) {
		return customerAndDates.startsWith("Regular");
	}

}
