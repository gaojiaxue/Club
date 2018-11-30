import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingRegister {
	HashMap<Facility, ArrayList<Booking>> bookinglist = new HashMap<Facility, ArrayList<Booking>>();

	public BookingRegister(HashMap<Facility, ArrayList<Booking>> bookinglist) {
		super();
		this.bookinglist = bookinglist;
	}

	public HashMap<Facility, ArrayList<Booking>> getBookinglist() {
		return bookinglist;
	}

	public void setBookinglist(HashMap<Facility, ArrayList<Booking>> bookinglist) {
		this.bookinglist = bookinglist;
	}

	ArrayList<Booking> exact;

	public void addBooking(Member member, Facility facility, LocalDate fromdate, LocalDate enddate)
			throws BadBookingException {

		exact = bookinglist.get(facility);
		int j = 0;
		Booking newBooking = new Booking(member, facility, fromdate, enddate);
		if (exact == null) {
			exact = new ArrayList<Booking>();
		} else {
			for (int i = 0; i < exact.size(); i++) {
				if (newBooking.overlaps(exact.get(i)) == true) {
					j = -1;
					break;
				}
			}
		}
		if (j == 0) {
			exact.add(newBooking);
			bookinglist.put(facility, exact);
		}
	}

	public void removeBooking(Booking booking) {
		Facility exactfacility = null;
		for (Facility o : bookinglist.keySet()) {
			if (bookinglist.get(o).equals(booking)) {
				exactfacility = o;
			}
			ArrayList<Booking> exact = bookinglist.get(o);
			exact.remove(booking);

		}
	}

	public ArrayList<Booking> get(Facility facility) {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		bookings = bookinglist.get(facility);
		// TODO Auto-generated method stub
		return bookings;
	}

}
