
public class Person {
    protected String surName;
    protected String firstName;
   protected String secondName;
	public Person(String surName, String firstName, String secondName) {
		super();
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	public Person(String surName, String firstName) {
		super();
		this.surName = surName;
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
    
	public void show()
    {

    		//System.out.println((firstName+secondName+surName).trim());

    	System.out.println(this.surName+this.firstName+(this.secondName!=null?this.secondName:""));
    }
//    public String toString()
//    { String fullName;
//       if(secondName==null)
//       {
//    	   fullName=firstName+surName;
//       }
//    
//       else {
//    	   fullName=firstName+secondName+surName;
//       }
//       return fullName;
//    }

	public String toString() {
		return "Person [surName=" + surName + ", firstName=" + firstName + ", secondName=" + secondName + "]";
	}
	
}
