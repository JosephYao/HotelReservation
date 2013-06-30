

public class HotelReservation {

	private static final String[] weekDays = new String[]{"mon", "tues", "wed", "thur", "fri"};

	public String reserve(String customerAndDates) {
		if (isRegularCustomer(customerAndDates) &&
			getWeekdayCount(customerAndDates) == 1 &&
			customerAndDates.contains("sat") &&
			customerAndDates.contains("sun"))
			return "Bridgewood";
		
		for (String weekDay : weekDays)
			if (customerAndDates.contains(weekDay))
				return "Lakewood";
		
		if (isRewardsCustomer(customerAndDates))
			return "Ridgewood";
		
		return "Bridgewood";
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
