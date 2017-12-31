
package pl.coderslab.model;

public class Status {
	private int id;
	private String status;
	
	//constructor
	public Status() {
		super();
	}
	public Status(int id, String status) {
		super();
		setId(id);
		setStatus(status);
	}
	
	//getters setters
	public int getId() {
		return id;
	}
	public Status setId(int id) {
		this.id = id;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public Status setStatus(String status) {
		this.status = status;
		return this;
	}
	
	

}
