package edu.tcu.cs.et.dao;
/*
 
 */

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.tcu.cs.et.domain.Book;
import edu.tcu.cs.et.domain.Publisher;
import edu.tcu.cs.et.tools.JDBCUtils;

/**
 * class's methods are called in the BookService class and consist of different searching queries as well as
 * adding, deleting updating existing book records. Class interacts with MySQL server.
 * @author kendricdspain
 *
 */
public class BookDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	/*
	 * passes a BigInteger value and uses query runner to update the Book table by using the
	 * delete query.
	 */
	public void deleteBook(BigInteger isbn) {
		try {
			// Write SQL statement with placeholder
			String sql = "DELETE FROM Book WHERE isbn=?";
			qr.update(sql, isbn);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Delete Exception!");
		}
	}

	/*
	 * method passes an instance of the book class. Updates a specific
	 * record in the book table with user specified values.
	 */
	public void editBook(Book bk) {
		try {
			// Write SQL statement with placeholder
			String sql = "UPDATE Book SET title=?,year=?,published_by=?,previous_edition=?,price=? WHERE isbn=?";
			//
			Object[] params = {bk.getTitle(), bk.getYear(), bk.getPublished_by(), bk.getPrevious_edition(),
					bk.getPrice(), bk.getIsbn() };
			//
			qr.update(sql, params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Edit Exception!");
		}
	}

	/*
	 * method passes an instance of the book class. User values are inserted into the query to add
	 * a book record into the book table.
	 */
	public void addBook(Book bk) {
		try {
			// Write SQL statement with placeholder
			String sql = "INSERT INTO Book (isbn,title,year,published_by,previous_edition,price) VALUES(?,?,?,?,?,?)";
			// retrieve the parameters needed for the update sql query runner.
			Object[] params = { bk.getIsbn(), bk.getTitle(), bk.getYear(), bk.getPublished_by(),bk.getPrevious_edition(), bk.getPrice() };
			//
			qr.update(sql, params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Add Exception!");
		}
	}
	/**
	 * method inserts values of publisher attributes into publisher table by sending query to mysql.
	 * @param p1 instance of publisher class.
	 */
	public void addPublisher(Publisher p1) {
		try {
			// Write SQL statement with placeholder
			String sql = "INSERT INTO Publisher (name,phone,city) VALUES(?,?,?)";
			// 
			Object[] params = { p1.getName(), p1.getPhone(), p1.getCity() };
			//
			qr.update(sql, params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Add Exception!");
		}
	}
	
	/*
	 * title is passed from BookService. Query statement is sent to MySql server.
	 */
	public List<Book> selectTitle(String title) {
		try {
			//
			String sql = "SELECT * FROM Book WHERE title=?";
			// Put the two parameters in an array
			Object[] params = { title };
			//
			return qr.query(sql, new BeanListHandler<>(Book.class), params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select Exception!");
		}
	}
	
	/*
	 * Isbn is passed from BookService. Query statement is sent to MySql server.
	 */
	public List<Book> selectISBN(String ISBN) {
		try {
			//
			String sql = "SELECT * FROM Book WHERE ISBN=?";
			// Put the two parameters in an array
			Object[] params = { ISBN };
			// converts table to objects.
			return qr.query(sql, new BeanListHandler<>(Book.class), params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select Exception!");
		}
	}

	/*
	 * Published_By is passed from BookService. Query statement is sent to MySql server.
	 */
	public List<Book> selectPublisher(String Published_By) {
		try {
			//
			String sql = "SELECT * FROM Book WHERE Published_by=?";
			// Put the two parameters in an array
			Object[] params = { Published_By };
			//
			return qr.query(sql, new BeanListHandler<>(Book.class), params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select Exception!");
		}
	}
	/*
	 * PriceMax and PriceMin are passed from BookService. Query statement is sent to MySql server.
	 */
	public List<Book> selectPrice(Double PriceMax, Double PriceMin) {
		try {
			//
			String sql = "SELECT * FROM Book WHERE price <= ? and price >= ?";
			// Put the two parameters in an array
			Object[] params = { PriceMax, PriceMin };
			//
			return qr.query(sql, new BeanListHandler<>(Book.class), params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select Exception!");
		}
	}
	
	/*
	 * Year of book published is passed from BookService. Query statement is sent to MySql server.
	 */
	public List<Book> selectYear(Integer Year) {
		try {
			//
			String sql = "SELECT * FROM Book WHERE year= ?";
			// Put the two parameters in an array
			Object[] params = { Year };
			//
			return qr.query(sql, new BeanListHandler<>(Book.class), params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select Exception!");
		}
	}
	/*
	 * method searches in a complex query for books with title and specific publisher.
	 * Beanlisthandler converts tables to objects.
	 */
	public List<Book> selectTitlePublisher(String title, String publisher) {
		try {
			//
			String sql = "SELECT * FROM Book WHERE title= ? and published_by= ?";
			// Put the two parameters in an array
			Object[] params = { title, publisher };
			//
			return qr.query(sql, new BeanListHandler<>(Book.class), params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select Exception!");
		}
	}
	
	/*
	 * method returns the entire table of books. 
	 */
	public List<Book> selectAll() {
		try {
			String sql = "SELECT * FROM Book";
			//
			List<Book> list = qr.query(sql, new BeanListHandler<>(Book.class));
			return list;
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select All Exception!");
		}
	}

}
