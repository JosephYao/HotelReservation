
public class HotelReservation {

	public String reserve(String customerAndDates) {
		if (customerAndDates.contains("sat"))
			return "Bridgewood";
			
		return "Lakewood";
	}

}
