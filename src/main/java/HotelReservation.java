

public class HotelReservation {

	private static final String[] weekDays = new String[]{"mon", "tues", "wed", "thur", "fri"};
	
	public String reserve(String customerAndDates) {
		for (String weekDay : weekDays)
			if (customerAndDates.contains(weekDay))
				return "Lakewood";
		
		if (customerAndDates.startsWith("Rewards:"))
			return "Ridgewood";
		
		return "Bridgewood";
	}

}
