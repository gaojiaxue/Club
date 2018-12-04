import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Club {
	// variable
	private int i = 0;
	private ArrayList<Member> members = new ArrayList<Member>();
	private static HashMap<String, Facility> facilities = new HashMap<String, Facility>();
	HashMap<Facility, ArrayList<Booking>> bookinglist = new HashMap<Facility, ArrayList<Booking>>();
	private BookingRegister Cb1 = new BookingRegister(bookinglist);

	// add a new member
	public void addMember(String surName, String firstName, String secondName) {
		i = members.size();
		Member m = new Member(surName, firstName, secondName, i);
		members.add(m);
	}

	// show member
	public void showMemembers() {
		for (Member current : members)
			System.out.println(current);

	}

	// remove member
	public void removeMember(int Mid) {
		members.remove(Mid);

	}

//sort member
	public void sortByMember() {
		int c;
		for (int i = 0; i < members.size() - 1; i++) {
			c = members.get(i).compareTo(members.get(i + 1));
			if (c < 0) {
				Collections.swap(members, i, i + 1);
			}
		}
	}

//add facility
	public void addFacility(String facilityName, Facility facility) {
		facilities.put(facilityName, facility);

	}

//remove facility
	public void removeFacility(String facilityName) {
		facilities.remove(facilityName);

	}

//get
	public Facility getFacility(String facilityName) {
		return facilities.get(facilityName);

	}

//get all
	public HashMap<String, Facility> getFacilities() {

		return facilities;

	}

//show
	public void showFacilities() {
		for (Object key : facilities.keySet()) {
			System.out.println(key + " : " + facilities.get(key));
		}
	}

//show all of club
	public void show() {
		for (Object key : facilities.keySet()) {
			System.out.println(key + " : " + facilities.get(key));
		}
		for (Member current : members)
			System.out.println(current);

	}

//add new booking of the club
	public void addBooking(int mid, String facilityName, LocalDate fromdate, LocalDate enddate)
			throws BadBookingException {
		Member member = null;
		// according to the mid search the member
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberNumber() == mid)
				member = members.get(i);
		}
		// according to the facilityName search the facility
		Facility facility = facilities.get(facilityName);
		// here we use bookingregister's method addBooking
		Cb1.addBooking(member, facility, fromdate, enddate);

	}
//show all the bookings of the club

	public void showBookings(String facilityName, LocalDate fromdate, LocalDate enddate) {
		// according to the facilityName search the facility
		Facility facility = facilities.get(facilityName);
		// use facilty get hashmap Cb1's this facility's booking list
		ArrayList<Booking> bookings = Cb1.get(facility);
		// show the booking number
		System.out.println(bookings.size());
		Iterator<Booking> iterator = bookings.iterator();
		while (iterator.hasNext()) {
			Booking string2 = (Booking) iterator.next();
			System.out.println(string2);
		}

	}
}
