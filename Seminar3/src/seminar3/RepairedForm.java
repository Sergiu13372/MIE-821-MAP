package seminar3;

public class RepairedForm implements Identifiable<Integer> {
	private int ID;
	private ComputerRepairRequest computerRepairRequest;
	private String services;
	private int price;
	private String date;
	private String employee;

	public RepairedForm() {
		this.computerRepairRequest = new ComputerRepairRequest();
		this.ID = 0;
		this.services = "";
		this.price = 0;
		this.date = "";
		this.employee = "";
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public RepairedForm(int ID, ComputerRepairRequest comp, String services, int price, String date, String employee) {
		this.ID = ID;
		this.computerRepairRequest = comp;
		this.services = services;
		this.date = date;
		this.employee = employee;
	}

	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer id) {
		this.ID = id;
	}

	ComputerRepairRequest getComputerRepairRequest() {
		return this.computerRepairRequest;
	}

	public void setComputerRepairRequest(ComputerRepairRequest comp) {
		this.computerRepairRequest = comp;
	}

	@Override
	public String toString() {
		String s = "";
		s = s + this.ID + " ";
		s = s + this.computerRepairRequest + " ";
		s = s + this.services + " ";
		s = s + this.date + " ";
		s = s + this.employee + " ";
		return s;
	}
}