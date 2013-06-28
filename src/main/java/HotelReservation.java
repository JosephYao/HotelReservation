
public class HotelReservation {

	public String reserve(String customerAndDates) {
		if (customerAndDates.contains("mon"))
			return "Lakewood";
		
		if (customerAndDates.startsWith("Rewards:"))
			return "Ridgewood";
		
		return "Bridgewood";
	}

}
