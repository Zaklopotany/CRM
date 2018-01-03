package pl.coderslab.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Orders {
	
	private int id;
	private LocalDate receiveDate;
	private	LocalDate expRepiarDate;
	private LocalDate beginRepair;
	private int employeeId;
	private	String probDesc;
	private	String repDesc;
	private int statusId;
	private int carId;
	private double customerCost;
	private double partsPrice;
	private double manHour; // take this value from Employee manHour
	private double workHour;
	private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	
	public Orders() {
		super();
		setCustomerCost(0);
		setPartsPrice(0);
		setWorkHour(0);
	}
	
	public Orders(int id, String receiveDate, String expRepiarDate, String beginRepair, int employeeId, String probDesc,
			String repDesc, int statusId, int carId, double customerCost, double partsPrice, double manHour,
			double workHour) {
		super();
		setId(id);
		setReceiveDate(receiveDate);
		setExpRepiarDate(expRepiarDate);
		setBeginRepair(beginRepair);
		setEmployeeId(employeeId);
		setProbDesc(probDesc);
		setRepDesc(repDesc);
		setStatusId(statusId);
		setCarId(carId);
		setCustomerCost(customerCost);
		setPartsPrice(partsPrice);
		setManHour(manHour);
		setWorkHour(workHour);
	}

	public int getId() {
		return id;
	}
	public Orders setId(int id) {
		this.id = id;
		return this;
	}
	public String getReceiveDate() {
		return this.receiveDate.toString();
	}
	public Orders setReceiveDate(String receiveDate) {
		this.receiveDate = LocalDate.parse(receiveDate, dtf);
		return this;
	}
	public String getExpRepiarDate() {
		return this.expRepiarDate.toString();
	}
	public Orders setExpRepiarDate(String expRepiarDate) {
		this.expRepiarDate = LocalDate.parse(expRepiarDate, dtf);
		return this;
	}
	public String getBeginRepair() {
		return this.beginRepair.toString();
	}
	public Orders setBeginRepair(String beginRepair) {
		this.beginRepair = LocalDate.parse(beginRepair, dtf);
		return this;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public Orders setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	public String getProbDesc() {
		return probDesc;
	}
	public Orders setProbDesc(String probDesc) {
		this.probDesc = probDesc;
		return this;
	}
	public String getRepDesc() {
		return repDesc;
	}
	public Orders setRepDesc(String repDesc) {
		this.repDesc = repDesc;
		return this;
	}
	public int getStatusId() {
		return statusId;
	}
	public Orders setStatusId(int statusId) {
		this.statusId = statusId;
		return this;
	}
	public int getCarId() {
		return carId;
	}
	public Orders setCarId(int carId) {
		this.carId = carId;
		return this;
	}
	public double getCustomerCost() {
		return customerCost;
	}
	public Orders setCustomerCost(double customerCost) {
		this.customerCost = customerCost;
		return this;
	}
	public double getPartsPrice() {
		return partsPrice;
	}
	public Orders setPartsPrice(double partsPrice) {
		this.partsPrice = partsPrice;
		return this;
	}
	public double getManHour() {
		return manHour;
	}
	public Orders setManHour(double manHour) {
		this.manHour = manHour;
		return this;
	}
	public double getWorkHour() {
		return workHour;
	}
	public Orders setWorkHour(double workHour) {
		this.workHour = workHour;
		return this;
	}
	
	

}
