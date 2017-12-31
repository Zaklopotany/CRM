package pl.coderslab.model;

public class Employee {
	protected int id;
	protected String firstname;
	protected String surname;
	protected String address;
	protected String phoneNumber;
	protected String note;
	protected double manHour;
	
	//creators
	
	public Employee() {
		
	}
	
	
	public Employee(int id, String firstname, String surname, String address, String phoneNumber, String note,
			double manHour) {
		super();
		setId(id);
		setFirstname(firstname);
		setSurname(surname);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setNote(note);
		setManHour(manHour);
	}


	//setters 
	public Employee setId(int id) {
		this.id = id;
		return this;
	}
	public Employee setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public Employee setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	public Employee setAddress(String address) {
		this.address = address;
		return this;
	}
	public Employee setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	public Employee setNote(String note) {
		this.note = note;
		return this;
	}
	public Employee setManHour(double manHour) {
		this.manHour = manHour;
		return this;
	}
	//getters
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getSurname() {
		return surname;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getNote() {
		return note;
	}
	public double getManHour() {
		return manHour;
	}
	
	
}
