package pl.coderslab.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vehicle {
	private int id;
	private String model;
	private String brand;
	private LocalDate productionYear;
	private String registrationNumber;
	private LocalDate nextReviewDate;
	private int clientId;
	private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	
	//creators
	public Vehicle(int id, String model, String brand, String productionYear, String registrationNumber,
			String nextReviewDate, int clientId) {
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

	public LocalDate getProductionYear() {
		return productionYear;
	}

	public Vehicle setProductionYear(String productionYear) {
		if (productionYear!= null) {
			if (productionYear.length() > 4) {
				this.productionYear = LocalDate.parse(productionYear, dtf);
			}
		}
		return this;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public Vehicle setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
		return this;
	}

	public LocalDate getNextReviewDate() {
		return nextReviewDate;
	}

	public Vehicle setNextReviewDate(String nextReviewDate) {
		if (nextReviewDate != null) {
			if (nextReviewDate.length() > 4) {
				this.nextReviewDate = LocalDate.parse(nextReviewDate, dtf);			
			}
		}
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
