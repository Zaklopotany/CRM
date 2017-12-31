package pl.coderslab.model;

import java.sql.Date;

public class Orders {
	
	private int id;
	private Date receiveDate;
	private	Date expRepiarDate;
	private Date beginRepair;
	private int employeeId;
	private	String probDesc;
	private	String repDesc;
	private int statusId;
	private int carId;
	private double customerCost;
	private double partsPrice;
	private double manHour; // take this value from Employee manHour
	private double workHour;
	
	public Orders() {
		super();
	}
	
	public Orders(int id, Date receiveDate, Date expRepiarDate, Date beginRepair, int employeeId, String probDesc,
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
	public Date getReceiveDate() {
		return receiveDate;
	}
	public Orders setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
		return this;
	}
	public Date getExpRepiarDate() {
		return expRepiarDate;
	}
	public Orders setExpRepiarDate(Date expRepiarDate) {
		this.expRepiarDate = expRepiarDate;
		return this;
	}
	public Date getBeginRepair() {
		return beginRepair;
	}
	public Orders setBeginRepair(Date beginRepair) {
		this.beginRepair = beginRepair;
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
