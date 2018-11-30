
public class Member extends Person implements Comparable<Member> {
	private int memberNumber;

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

	public String toString() {
		return "Member [memberNumber=" + memberNumber + ", toString()=" + super.toString() + "]";
	}

	public void show() {
		System.out.println(
				this.surName + this.firstName + (this.secondName != null ? this.secondName : "") + this.memberNumber);
	}

	public int compareTo(Member o) {
		return (getMemberNumber() - o.getMemberNumber());
	}

}
