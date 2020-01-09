package edu.tcu.cs.et.domain;
import java.io.Serializable;
import java.math.BigInteger;

/*
 * Class holds the values of each record in the publisher table.
 * values can be retrieved by the getters and setters within the class.
 */
public class Publisher {
	private String Name;
	
	private BigInteger Phone;

	private String City;
	
	
	public Publisher (String Name, BigInteger Phone, String City)
	{
		this.Name = Name;
		this.Phone = Phone;
		this.City = City;
	}
	
	public Publisher() {
		
	}

	@Override
	public String toString() {
		return "Publisher [Name=" + Name + ", Phone=" + Phone + ", City=" + City + "]";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public BigInteger getPhone() {
		return Phone;
	}

	public void setPhone(BigInteger phone) {
		Phone = phone;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
	
}
