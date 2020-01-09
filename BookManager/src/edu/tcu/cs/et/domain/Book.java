package edu.tcu.cs.et.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

/**
 * Class Book is called JavaBean, it corresponds to the table Book in
 * Database. Each attribute in JavaBean corresponds to each field or column in
 * the table. There should also be setter and getter methods.
 * 
 * @author kendricd
 *
 */
public class Book implements Serializable {
	private String isbn;
	
	private String title;

	private Integer year;

	private String published_by;

	private String previous_edition;

	private Double price;
/**
 * constructor of book class has multiple parameters for the instantiation of the class.
 * @param isbn
 * @param title
 * @param year
 * @param published_by
 * @param previous_edition
 * @param price
 */
	public Book(String isbn, String title, Integer year, String published_by, String previous_edition, Double price) {
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.published_by = published_by;
		this.previous_edition = previous_edition;
		this.price = price;
	}

	public Book() {

	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", year=" + year + ", published_by=" + published_by
				+ ", previous_edition=" + previous_edition + ", price=" + price + "]";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPublished_by() {
		return published_by;
	}

	public void setPublished_by(String published_by) {
		this.published_by = published_by;
	}

	public String getPrevious_edition() {
		return previous_edition;
	}

	public void setPrevious_edition(String previous_edition) {
		this.previous_edition = previous_edition;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
