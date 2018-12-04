import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingRegister {
	// attribute
	HashMap<Facility, ArrayList<Booking>> bookinglist = new HashMap<Facility, ArrayList<Booking>>();
	ArrayList<Booking> exact;

	// constructor
	public BookingRegister(HashMap<Facility, ArrayList<Booking>> bookinglist) {
		super();
		this.bookinglist = bookinglist;
	}

	// property
	public HashMap<Facility, ArrayList<Booking>> getBookinglist() {
		return bookinglist;
	}

	public void setBookinglist(HashMap<Facility, ArrayList<Booking>> bookinglist) {
		this.bookinglist = bookinglist;
	}

//add booking to hashmap
	public void addBooking(Member member, Facility facility, LocalDate fromdate, LocalDate enddate)
			throws BadBookingException {
		// use key to get the exact facility's booking list
		exact = bookinglist.get(facility);
		int j = 0;
		// create a new booking
		Booking newBooking = new Booking(member, facility, fromdate, enddate);
		// if the facility doesn't have a booking,create a list for it
		if (exact == null) {
			exact = new ArrayList<Booking>();
		} else {
			// if it has a booking,check if has overlap ,if not ,add it
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

//remove booking
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

//get all booking of exact facility
	public ArrayList<Booking> get(Facility facility) {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		bookings = bookinglist.get(facility);
		// TODO Auto-generated method stub
		return bookings;
	}

}
