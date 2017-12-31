package pl.coderslab.model;

import java.sql.Date;

public class Vehicle {
	private int id;
	private String model;
	private String brand;
	private Date productionYear;
	private String registrationNumber;
	private Date nextReviewDate;
	private int clientId;
	
	//creators
	public Vehicle(int id, String model, String brand, Date productionYear, String registrationNumber,
			Date nextReviewDate, int clientId) {
		super();
		setId(id);
		setModel(model);
		setBrand(brand);
		setProductionYear(productionYear);
		setRegistrationNumber(registrationNumber);
		setNextReviewDate(nextReviewDate);
		setClientId(clientId);
	}

	public Vehicle() {
		super();
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public Vehicle setId(int id) {
		this.id = id;
		return this;
	}

	public String getModel() {
		return model;
	}

	public Vehicle setModel(String model) {
		this.model = model;
		return this;
	}

	public String getBrand() {
		return brand;
	}

	public Vehicle setBrand(String brand) {
		this.brand = brand;
		return this;
	}

	public Date getProductionYear() {
		return productionYear;
	}

	public Vehicle setProductionYear(Date productionYear) {
		this.productionYear = productionYear;
		return this;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public Vehicle setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
		return this;
	}

	public Date getNextReviewDate() {
		return nextReviewDate;
	}

	public Vehicle setNextReviewDate(Date nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
		return this;
	}

	public int getClientId() {
		return clientId;
	}

	public Vehicle setClientId(int clientId) {
		this.clientId = clientId;
		return this;
	}

}
