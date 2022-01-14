package seminar3;

public class ComputerRepairRequest implements Identifiable<Integer> {
	private int ID;
	private String ownerName;
	private String ownerAddress;
	private String phoneNumber;
	private String model;
	private String date;
	private String problemDescription;

	public ComputerRepairRequest() {
		this.ID = 0;
		this.ownerName = "";
		this.ownerAddress = "";
		this.phoneNumber = "";
		this.model = "";
		this.date = "";
		this.problemDescription = "";
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ComputerRepairRequest(int ID, String ownerName, String ownerAddress, String phoneNumber, String model,
			String date, String problemDescription) {
		this.ID = ID;
		this.ownerName = ownerName;
		this.ownerAddress = ownerAddress;
		this.phoneNumber = phoneNumber;
		this.model = model;
		this.date = date;
		this.problemDescription = problemDescription;
	}

	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer id) {
		this.ID = id;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		String s = "";
		s = s + this.ID + " ";
		s = s + this.ownerName + " ";
		s = s + this.ownerAddress + " ";
		s = s + this.phoneNumber + " ";
		s = s + this.model + " ";
		s = s + this.date + " ";
		s = s + this.problemDescription + " ";
		return s;
	}
}