package model;

import java.io.Serializable;

public class RepairedForm implements Identifiable<Integer>, Serializable{
	private int ID;
    private ComputerRepairRequest computerRepairRequest;
    private String services;
    private int price;
    private String date;
    private String employee;

	public RepairedForm(int ID, ComputerRepairRequest computerRepairRequest, String services, int price,String date, String employee){
	    this.ID=ID;
	    this.computerRepairRequest = computerRepairRequest;
	    this.services=services;
	    this.price=price;
	    this.date=date;
	    this.employee=employee;
	}
	
	public RepairedForm(){
	    this.ID=0;
	    this.computerRepairRequest = null;
	    this.services="";
	    this.price=0;
	    this.date="";
	    this.employee="";
	}
	
	@Override
	public String toString(){
		return "RepairedForm with id: " + this.ID + ", service: " + this.services + ", price: " + this.price + ", date: " + this.date + ", employee: " + this.employee + ", request: "+ this.computerRepairRequest;
	}

	@Override
	public Integer getID() {
		return ID;
	}

	@Override
	public void setID(Integer id) {
		ID = id;
		
	}

	public ComputerRepairRequest getComputerRepairRequest() {
		return computerRepairRequest;
	}

	public void setComputerRepairRequest(ComputerRepairRequest computerRepairRequest) {
		this.computerRepairRequest = computerRepairRequest;
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




}
