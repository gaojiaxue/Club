import java.time.LocalDate;

public class Booking {
	// attributes
	Member member;
	Facility facility;
	LocalDate fromdate;
	LocalDate enddate;

	// constructor
	public Booking(Member member, Facility facility, LocalDate fromdate, LocalDate enddate) throws BadBookingException {
		super();
		this.member = member;
		this.facility = facility;
		this.fromdate = fromdate;
		this.enddate = enddate;
		if (member == null) {
			throw new BadBookingException("input a member");
		}
		if (facility == null) {
			throw new BadBookingException("input a facility");
		}
		if (fromdate == null || enddate == null) {
			throw new BadBookingException("input date");
		}
		if (fromdate.isAfter(enddate)) {
			throw new BadBookingException("Your fromdate is later than enddate");
		}
	}

//property
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public LocalDate getFromdate() {
		return fromdate;
	}

	public void setFromdate(LocalDate fromdate) {
		this.fromdate = fromdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

//test if two booking conflict
	public boolean overlaps(Booking b) {
		boolean x = false;
		if ((b.facility == this.facility)) {
			// assume we have two booking only when B booking's enddate is before A's
			// startdate or
			// B's startdate is after A's end ,it won't have a overlaps,so on the opposite
			// is overlap
			if (!(b.enddate.isBefore(this.fromdate) || b.fromdate.isAfter(this.enddate)))
				x = true;
		}
		return x;
	}

//show
	@Override
	public String toString() {
		return "Booking [member=" + member + ", facility=" + facility + ", fromdate=" + fromdate + ", enddate="
				+ enddate + "]";
	}

}
