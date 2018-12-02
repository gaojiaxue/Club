import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
	Member member;
	Facility facility;
	LocalDate fromdate;
	LocalDate enddate;

	public Booking(Member member, Facility facility, LocalDate fromdate, LocalDate enddate) throws BadBookingException {
		super();
		this.member = member;
		this.facility = facility;
		this.fromdate = fromdate;
		this.enddate = enddate;
		if (member == null) {
			throw new BadBookingException("input a member");
		}
//		if (facility==null) {
//			throw new BadBookingException("input a facility");
//		}
		if (fromdate == null || enddate == null) {
			throw new BadBookingException("input date");
		}
		if (fromdate.isAfter(enddate)) {
			throw new BadBookingException("Your fromdate is later than enddate");
		}
	}

	public Booking(Member m1, Facility f1, LocalDateTime fromdate2, LocalDateTime enddate2) {
		// TODO Auto-generated constructor stub
	}

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

	public boolean overlaps(Booking b) {
		boolean x = false;
		if ((b.facility == this.facility)) {
			if (!(b.enddate.isBefore(this.fromdate) || b.fromdate.isAfter(this.enddate)))
				x = true;
		}
		return x;
	}

	@Override
	public String toString() {
		return "Booking [member=" + member + ", facility=" + facility + ", fromdate=" + fromdate + ", enddate="
				+ enddate + "]";
	}

}
