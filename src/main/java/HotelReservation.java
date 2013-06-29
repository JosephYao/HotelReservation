

public class HotelReservation {

	private static final String[] weekDays = new String[]{"mon", "tues", "wed", "thur", "fri"};
	
	public String reserve(String customerAndDates) {
		if (isRegularCustomer(customerAndDates) &&
			customerAndDates.contains("mon") &&
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

	private boolean isRewardsCustomer(String customerAndDates) {
		return customerAndDates.startsWith("Rewards");
	}

	private boolean isRegularCustomer(String customerAndDates) {
		return customerAndDates.startsWith("Regular");
	}

}
