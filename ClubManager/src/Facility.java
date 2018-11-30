
public class Facility {
  private String name;
  private String description;
public Facility(String name, String description) {
	super();
	this.name = name;
	this.description = description;
}
public Facility(String name) {
	super();
	this.name = name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public void show()
{
	System.out.println(this.name+(this.description!=null?this.description:""));
}
public String toString() {
	return "Facility [name=" + name + ", description=" + description + "]";
}

}
