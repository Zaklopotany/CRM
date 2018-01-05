package pl.coderslab.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Customer {
	protected int id;
	protected String firstname;
	protected String surname;
	private LocalDate BdDate;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	// creators
	public Customer() {
		setId(0);

	}

	public Customer(int id, String firstname, String surname, String bdDate) {
		super();
		setId(id);
		setFirstname(firstname);
		setSurname(surname);
		setBdDate(bdDate);
	}

	// getters and setters
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

	public LocalDate getBdDate() {
		return BdDate;
	}

	public Customer setBdDate(String bdDate) {
		if (bdDate != null) {
			try {
				if (bdDate.length() > 4) {
					this.BdDate = LocalDate.parse(bdDate, dtf);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	//

}
