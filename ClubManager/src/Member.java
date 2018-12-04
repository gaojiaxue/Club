
public class Member extends Person implements Comparable<Member> {
	// attribute
	private int memberNumber;

//constructor
	public Member(String surName, String firstName, String secondName, int memberNumber) {
		super(surName, firstName, secondName);
		this.memberNumber = memberNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

//show
	public String toString() {
		return "Member [memberNumber=" + memberNumber + ", toString()=" + super.toString() + "]";
	}

	// compare memberid
	public int compareTo(Member o) {
		return (getMemberNumber() - o.getMemberNumber());
	}

}
