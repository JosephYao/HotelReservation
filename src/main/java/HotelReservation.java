import java.util.regex.Pattern;



public class HotelReservation {

	private static final String[] weekDays = new String[]{"mon", "tues", "wed", "thur", "fri"};
	
	public String reserve(String customerAndDates) {
		if (isRegularCustomer(customerAndDates) &&
			getWeekdayCount(customerAndDates) == 1 &&
			getWeekendCount(customerAndDates) == 2)
			return "Bridgewood";
		
		for (String weekDay : weekDays)
			if (customerAndDates.contains(weekDay))
				return "Lakewood";
		
		if (isRewardsCustomer(customerAndDates))
			return "Ridgewood";
		
		return "Bridgewood";
	}
	
	private int getWeekendCount(String customerAndDates) {
		int count = 0;
		
		if (customerAndDates.contains("sat"))
			count += customerAndDates.split("sat").length - 1;
		
		if (customerAndDates.contains("sun"))
			count++;
		
		return count;
	}

	private int getWeekdayCount(String customerAndDates) {
		int count = 0;
		
		for (String weekDay : weekDays)
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
