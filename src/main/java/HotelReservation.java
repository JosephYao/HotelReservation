
public class HotelReservation {

	public String reserve(String customerAndDates) {
		if (customerAndDates.startsWith("Rewards:"))
			return "Ridgewood";
		
		if (customerAndDates.contains("sat"))
			return "Bridgewood";
			
		return "Lakewood";
	}

}
