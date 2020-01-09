package edu.tcu.cs.et.controller;

import java.math.BigInteger;
import java.util.List;

import edu.tcu.cs.et.domain.Book;
import edu.tcu.cs.et.domain.Publisher;
import edu.tcu.cs.et.service.BookService;

/**
 * Class's methods are called by the MainView class and then pass instances of classes and data on towards
 * the BookService class.
 * @author kendricdspain
 *
 */
public class BookController {
	private BookService service = new BookService();
	/*
	 * Controller passes the id of activity to ActivityService
	 */
	public void deleteBook(BigInteger isbn) {
		service.deleteBook(isbn);
	}
	
	/*
	 * Controller is calling BookService's editBook method and passing act to it.
	 */
	public void editBook(Book bk) {
		service.editBook(bk);
	}
	/*
	 * Controller is invoking the addBook method of BookService
	 * 
	 */
	public void addBook(Book bk) {
		service.addBook(bk);
	}
	
	/**
	 * method passes an instance of publisher class to the addPublisher() in BookService.
	 * @param pub
	 */
	public void addPublisher(Publisher pub) {
		service.addPublisher(pub);
	}
	
	/*
	 * Controller passes title to BookService
	 * and returns the result to MainView
	 */
	public List<Book> selectTitle(String title){
		return service.selectTitle(title);
	}
	
	/*
	 * Controller passes isbn to BookService
	 * and returns the result to MainView
	 */
	public List<Book> selectISBN(String ISBN){
		return service.selectISBN(ISBN);
	}
	
	/*
	 * Controller passes publisher to BookService
	 * and returns the result to MainView
	 */
	public List<Book> selectPublisher(String Publisher){
		return service.selectPublisher(Publisher);
	}
	
	/*
	 * Controller passes price of the book to BookService
	 * and returns the result to MainView
	 */
	public List<Book> selectPrice(Double PriceMax, Double PriceMin){
		return service.selectPrice(PriceMax, PriceMin);
	}
	
	/*
	 * Controller passes year to BookService
	 * and returns the result to MainView
	 */
	public List<Book> selectYear( Integer year){
		return service.selectYear(year);
	}
	
	/*
	 * Controller passes title and publisher to BookService
	 * and returns the result to MainView
	 */
	public List<Book> selectTitlePublisher( String title, String publisher){
		return service.selectTitlePublisher(title,publisher );
	}
	
	/*
	 * Controller is calling BookService's selectAll method.
	 */
	public List<Book> selectAll(){
		return service.selectAll();
	}
}
