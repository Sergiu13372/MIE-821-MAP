package model;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public class ComputerRepairRequest implements Identifiable<Integer>, Serializable{
	private int ID;
	private final SimpleStringProperty ownerName = new SimpleStringProperty("");
	private final SimpleStringProperty ownerAddress = new SimpleStringProperty("");
	private final SimpleStringProperty phoneNumber = new SimpleStringProperty("");
	private final SimpleStringProperty model = new SimpleStringProperty("");
	private final SimpleStringProperty date = new SimpleStringProperty("");
	private final SimpleStringProperty problemDescription = new SimpleStringProperty("");
	
	public ComputerRepairRequest (int ID, String ownerName, String ownerAddress, String phoneNumber, String model, String date, String problemDescription){
	    this.ID=ID;
	    this.ownerName.set(ownerName);
		this.ownerAddress.set(ownerAddress);
		this.phoneNumber.set(phoneNumber);
		this.model.set(model);
	    this.date.set(date);
	    this.problemDescription.set(problemDescription);
	}

	public ComputerRepairRequest (){
	    this(0, "", "", "", "", "", "");
	}

	@Override
	public String toString(){
		String s="ID: ";
		s=s+this.ID;
		s=s+", owner name: "+this.ownerName.get();
		s=s+", owner address:"+this.ownerAddress.get();
		s=s+", phone number: "+this.phoneNumber.get();
		s=s+", model: "+this.model.get();
		s=s+", date: "+this.date.get();
		s=s+", problem: "+this.problemDescription.get();
		 
		return s;
	}

	@Override
	public Integer getID() {
		return ID;
	}

	@Override
	public void setID(Integer Id) {
		ID = Id;
	}

	public String getOwnerName() {
		return ownerName.get();
	}

	public void setOwnerName(String ownerName) {
		this.ownerName.set(ownerName);
	}

	public String getOwnerAddress() {
		return ownerAddress.get();
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress.set(ownerAddress);
	}

	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}

	public String getModel() {
		return model.get();
	}

	public void setModel(String model) {
		this.model.set(model);
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}

	public String getProblemDescription() {
		return problemDescription.get();
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription.set(problemDescription);
	}
	
	
}
