package lab2;

public class Person {
	private String firstName;
	private String secondName;
	private int yearBorn;
	private String monthBorn;
	private int dayBorn;
	private int height;
	private String description;
	private boolean gender;
	
	public Person(String firstName, String secondName, int yearBorn, String monthBorn, int dayBorn, int height, String description, boolean gender){
		this.firstName = firstName;
		this.secondName = secondName;
		this.yearBorn = yearBorn;
		this.monthBorn = monthBorn;
		this.dayBorn = dayBorn;
		this.height = height;
		this.description = description;
		this.gender = gender;
	}
	
	public Person(){
		this.firstName = "";
		this.secondName = "";
		this.yearBorn = 0;
		this.monthBorn = "";
		this.dayBorn = 0;
		this.height = 0;
		this.description = "";
		this.gender = false;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getSecondName(){
		return this.secondName;
	}
	
	public void setSecondName(String secondName){
		this.secondName= secondName;
	}
	
	public int getYearBorn(){
		return this.yearBorn;
	}
	
	public void setYearBorn( int yearBorn){
		this.yearBorn = yearBorn;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void setHeight( int height){
		this.height = height;
	}
	
	public String getMonthBorn() {
		return this.monthBorn;
	}

	public void setMonthBorn(String monthBorn) {
		this.monthBorn = monthBorn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getGender() {
		return this.gender;
	}

	public void setNoPages(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString(){
		String s = "";
		s = s + this.firstName;
		s = s + ",";
		s = s + this.secondName;
		s = s + ",";
		s = s + " Born in: ";
		s = s + this.yearBorn;
		s = s + " ";
		s = s + this.monthBorn;
		s = s + " ";
		s = s + this.dayBorn;
		s = s + ",";
		s = s + " with a height of: ";
		s = s + this.height;
		s = s + ",";
		s = s + this.description;
		s = s + ",";
		s = s + this.gender;
		return s;
	}
	
	public boolean equals(Object ob){
		if(ob instanceof Person){
			Person book = (Person)ob;
			if(book.firstName.equals(firstName) && book.secondName.equals(secondName) && book.yearBorn == yearBorn &&
			book.monthBorn.equals(monthBorn) && book.dayBorn == dayBorn && book.description.equals(description) &&
			book.gender==gender && book.height==height)
			return true;
		}
		return false;
	}
}
