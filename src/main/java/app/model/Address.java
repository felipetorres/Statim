package app.model;


public class Address {
	
	private String name;
	private int number;
	
	public Address() {
	}
	
	public Address(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return this.name + "," + this.number;
	}
}
