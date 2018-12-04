
public class Facility {
	// attribute
	private String name;
	private String description;

	// constructor
	public Facility(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Facility(String name) {
		super();
		this.name = name;
	}

//property
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

//show
	public String toString() {
		return "Facility [name=" + name + ", description=" + description + "]";
	}

}
