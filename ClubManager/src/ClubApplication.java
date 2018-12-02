import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClubApplication {

	public static void main(String[] args) throws BadBookingException {
		Person p1 = new Person("dai", "chujian", "daipp");
		Facility f1 = new Facility("desk1");
		Facility f2 = new Facility("desk2", "white");
		Facility f3 = new Facility("desk3", "white");
		Member m1 = new Member("fangbingbing", "fan", "bingbng", 0);
		Club c1 = new Club();
		c1.addMember("fangbingbing", "fan", "bingbng");
		c1.addMember("hh", "gg", "mm");
		c1.showMemembers();
		c1.addFacility("desk1", f1);
		c1.addFacility("desk2", f2);
		c1.addFacility("desk3", f3);
		c1.getFacility("desk1");
		c1.getFacilities();
		c1.showFacilities();
		c1.addBooking(1, "desk1", LocalDate.of(2018, 07, 20), LocalDate.of(2018, 07, 31));
		c1.addBooking(1, "desk1", LocalDate.of(2018, 07, 01), LocalDate.of(2018, 07, 12));
		c1.addBooking(0, "desk1", LocalDate.of(2018, 06, 12), LocalDate.of(2018, 06, 13));
		c1.showBookings("desk1", LocalDate.of(2018, 06, 01), LocalDate.of(2018, 07, 31));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		LocalDate fromdate = LocalDate.parse("8-03-2018", formatter);
		LocalDate enddate = LocalDate.parse("16-03-2018", formatter);
		String bb = fromdate.format(formatter);
		Booking b1 = new Booking(m1, f1, fromdate, enddate);
		System.out.println(bb);

	}

}
