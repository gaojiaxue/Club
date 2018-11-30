import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Club {
	private int i = 0;
	private ArrayList<Member> members = new ArrayList<Member>();
	private static HashMap<String, Facility> facilities = new HashMap<String, Facility>();
	HashMap<Facility, ArrayList<Booking>> bookinglist = new HashMap<Facility, ArrayList<Booking>>();
	private BookingRegister Cb1 = new BookingRegister(bookinglist);

	public void addMember(String surName, String firstName, String secondName) {
		i = members.size();
		Member m = new Member(surName, firstName, secondName, i);
		members.add(m);
	}

	public void showMemembers() {
		for (Member current : members)
			System.out.println(current);

	}

	public void removeMember(int Mid) {
		members.remove(Mid);

	}

	public void sortByMember() {
		int c;
		for (int i = 0; i < members.size() - 1; i++) {
			c = members.get(i).compareTo(members.get(i + 1));
			if (c < 0) {
				Collections.swap(members, i, i + 1);
			}
		}
	}

	public void addFacility(String facilityName, Facility facility) {
		facilities.put(facilityName, facility);

	}

	public void removeFacility(String facilityName) {
		facilities.remove(facilityName);

	}

	public Facility getFacility(String facilityName) {
		return facilities.get(facilityName);

	}

	public HashMap<String, Facility> getFacilities() {

		return facilities;

	}

	public void showFacilities() {
		for (Object key : facilities.keySet()) {
			System.out.println(key + " : " + facilities.get(key));
		}
	}

	public void show() {
		for (Object key : facilities.keySet()) {
			System.out.println(key + " : " + facilities.get(key));
		}
		for (Member current : members)
			System.out.println(current);

	}

	public void addBooking(int mid, String facilityName, LocalDate fromdate, LocalDate enddate)
			throws BadBookingException {
		Member member = null;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberNumber() == mid)
				member = members.get(i);
		}
		Facility facility = facilities.get(facilityName);
		Cb1.addBooking(member, facility, fromdate, enddate);

	}

	public void getBookings(String facilityName, LocalDate fromdate, LocalDate enddate) {
		Iterator it = facilities.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			ArrayList<Booking> pr = new ArrayList<Booking>();
			bookinglist.put(facilities.get(key), pr);
		}
		Facility facility = getFacility(facilityName);
		ArrayList<Booking> bookings = bookinglist.get(facility);
	}

	public void showBookings(String facilityName, LocalDate fromdate, LocalDate enddate) {

		Facility facility = facilities.get(facilityName);
		ArrayList<Booking> bookings = Cb1.get(facility);
		System.out.println(bookings.size());
		Iterator<Booking> iterator = bookings.iterator();
		while (iterator.hasNext()) {
			Booking string2 = (Booking) iterator.next();
			System.out.println(string2);
		}

	}
}
