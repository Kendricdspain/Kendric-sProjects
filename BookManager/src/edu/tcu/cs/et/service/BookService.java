package edu.tcu.cs.et.service;

import java.math.BigInteger;
import java.util.List;

import edu.tcu.cs.et.dao.BookDao;
import edu.tcu.cs.et.domain.Book;
import edu.tcu.cs.et.domain.Publisher;
/**
 * class's methods are called by the BookController and it passes values to BookDao class.
 * Values being passed could be instances of other classes or attribute values for an instance of an object.
 * @author kendricdspain
 *
 */
public class BookService {
	private BookDao dao = new BookDao();
	/*
	 * Service passes the isbn of the book instance to DAO
	 */
	public void deleteBook(BigInteger isbn) {
		dao.deleteBook(isbn);
	}
	
	/*
	 * Service passes the book object 
	 */
	public void editBook(Book bk) {
		dao.editBook(bk);
	}
	
	/*
	 * Service passes instance of book object
	 */
	public void addBook(Book bk) {
		dao.addBook(bk);
	}
	
	/**
	 * method passes instance of publisher class to Dao class
	 * @param pub
	 */
	public void addPublisher(Publisher pub) {
		dao.addPublisher(pub);
	}
	
	
	/*
	 * Class passes the isbn of the book instance to DAO
	 */
	public List<Book> selectTitle(String title){
		return dao.selectTitle(title);
	}
	
	/*
	 * method passes ISBN string value to Dao class
	 */
	public List<Book> selectISBN(String ISBN){
		return dao.selectISBN(ISBN);
	}
	
	/*
	 * method passes publisher string value to Dao class.
	 */
	public List<Book> selectPublisher(String Publisher){
		return dao.selectPublisher(Publisher);
	}
	
	/*
	 * method passes the maxprice and min price of the book as a double to Dao class.
	 */
	public List<Book> selectPrice(Double PriceMax, Double PriceMin){
		return dao.selectPrice(PriceMax, PriceMin);
	}
	
	/*
	 * method passes year integer value to Dao class.
	 */
	public List<Book> selectYear(Integer year){
		return dao.selectYear(year);
	}
	
	/*
	 * method passes title and publisher values from book class to BookDao.
	 */
	public List<Book> selectTitlePublisher(String title, String publisher){
		return dao.selectTitlePublisher(title, publisher);
	}
	
	/*
	 * Method Searches for all records in the book table.
	 */
	public List<Book> selectAll(){
		return dao.selectAll();
	}

	
	
}
