package pl.coderslab.model;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
	protected int id;
	protected String firstname;
	protected String surname;
	protected  Date BdDate;
	
	//creators
	public Customer () {
		
	}
	
	public Customer(int id, String firstname, String surname, Date bdDate) {
		super();
		setId(id);
		setFirstname(firstname);
		setSurname(surname);
		setBdDate(bdDate);
	}


	//getters and setters
	public int getId() {
		return id;
	}
	public Customer setId(int id) {
		this.id = id;
		return this;
	}
	public String getFirstname() {
		return firstname;
	}
	public Customer setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public String getSurname() {
		return surname;
	}
	public Customer setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	public Date getBdDate() {
		return BdDate;
	}
	public Customer setBdDate(Date bdDate) {
		BdDate = bdDate;
		return this;
	}
	
	//
	
}
