package edu.tcu.cs.et.view;

import java.math.BigInteger;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import edu.tcu.cs.et.controller.BookController;
import edu.tcu.cs.et.domain.Book;
import edu.tcu.cs.et.domain.Publisher;
/**
 * Class represents the GUI aspect of the application.
 * @author kendricdspain
 *
 */
public class MainView {
	//MainView holds an instance of BookController
	private BookController controller = new BookController();

	/*
	 * The control flow in run() is 1.print the menu 2.get the input from user
	 * 3.call the corresponding method to update or query the database 4.print
	 * results to user 5.go back to step 1 until the input is exit.
	 */
	public void run() {

		Scanner sc = new Scanner(System.in);
		while (true) {
			// print the menu
			System.out.println("----------------Bookn Manager Software----------------");
			System.out.println("0.Add Publisher 1.Add Book 2.Edit Book 3.Delete Book 4.Search Activity 5.Exit");
			System.out.println("Please select the function, type [1-5] and press enter:");

			int choose = sc.nextInt();

			switch (choose) {
			
			// if user inputs 0
			case 0:
				addPublisher();
				break;
				
			// if user inputs 1
			case 1:
				addBook();
				break;
				
			// if user inputs 2
			case 2:
				editBook();
				break;
				
			// if user inputs 3
			case 3:
				deleteBook();
				break;
				
			// if user inputs 4
			case 4:
				selectBook();
				break;
			
			// if user inputs 5
			case 5:
				System.exit(0);
				break;
			}
		}
	}
	
	/*
	 * 
	 * method listens for user responses and adds publisher into publisher table in database.
	 */
	public void addPublisher() {
		System.out.println("Please enter the following information:");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of the Publisher:");
		String name = sc.nextLine();
		System.out.println("Enter Publisher's phone number:");
		String strphone = sc.nextLine();
		BigInteger phone = new BigInteger(strphone);
		
		System.out.println("Enter Publisher's City:");
		String city = sc.nextLine();
		// creates an instance of the publisher class and saves the values
		Publisher pub = new Publisher(name, phone, city);
		controller.addPublisher(pub);
		System.out.println("Publisher Added Successfully!");
	}

	/*
	 * listens for user response through scanner and saves values to an instance of book class.
	 */
	public void addBook() {
		System.out.println("Please enter the following information:");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter isbn of the book:");
		String strisbn = sc.nextLine();
		//Integer isbn = Integer.valueOf(strisbn);
		try { BigInteger isbn = new BigInteger(strisbn); }
		catch (NumberFormatException e) {e.printStackTrace(); System.out.println("Enter a valid 9 digit number");}
		//Integer isbn = sc.nextLine();
		System.out.println("Enter the title of the book:");
		String title = sc.nextLine();
		System.out.println("Enter year of book published in this format: YYYY ");
		Integer year = Integer.parseInt(sc.nextLine());
		System.out.println("Enter name of the book's publisher: ");
		String published_by = sc.nextLine();
		System.out.println("Enter the book's previous edition isbn: ");
		String previous_edition = sc.nextLine();
		if (previous_edition.equals(""))
			previous_edition = null;
		System.out.println("Enter the price of the book "+title+" : ");
		double price = Double.parseDouble(sc.nextLine());
		//Create an book instance to hold the collected data
		Book bk = new Book(strisbn, title, year, published_by, previous_edition, price);
		//pass the object bk to controller
		controller.addBook(bk);
		System.out.println("Book Added Successfully!");
	}
	/*
	 * user values change the values of a specific recors in book table.
	 */
	public void editBook() {
		// We first display all books to the user
		selectAll();
		System.out.println("Enter ISBN of book you want to edit: ");
		Scanner sc = new Scanner(System.in);
		//System.out.print("Type new ISBN and press enter:");
		String strIsbn = sc.nextLine();
		try { int isbn = Integer.parseInt(strIsbn); }
		catch (NumberFormatException e) { e.printStackTrace(); System.out.println("enter a valid 9 digit isbn: ");}
		System.out.println("Enter the new title of the book:");
		String title = sc.nextLine();
		System.out.println("Enter new year of book published in this format: YYYY ");
		Integer year = Integer.parseInt(sc.nextLine());
		System.out.println("Enter new name of the book's publisher: ");
		String published_by = sc.nextLine();
		System.out.println("Enter the new book's previous edition isbn: ");
		String previous_edition = sc.nextLine();
		if (previous_edition.equals(""))
			previous_edition = null;
		System.out.println("Enter the price of the book "+title+" : ");
		double price = Double.parseDouble(sc.nextLine());
		Book bk = new Book(strIsbn, title, year, published_by, previous_edition, price);
		// Create an Activity instance to encapsulate all the data above
		// pass the object to controller
		controller.editBook(bk);
		System.out.println("Edit Successfully!");
	}
	/*
	 * Method provides different options of searching for a book
	 */
	public void selectBook() {
		System.out.println("1. Search All Books\t                 2. Search Books Based on title \t  3. Search Books Based on ISBN\n" +
						   "4. Search Books Based on publisher \t 5. Search Books Based on price \t  6. Search Books Based on year\n" +
						   "7. Search Books based on tile and publisher");
		Scanner sc = new Scanner(System.in);
		try {
			int selectChooser = Integer.parseInt(sc.nextLine());
			//int selectChooser = sc.nextInt();
			switch (selectChooser) {
			case 1:
				// select all books from DB
				selectAll();
				break;
				
			case 2:
				//select books based on title
				selectTitle();
				break;
				
			case 3:
				//select books based on ISBN
				selectISBN();
				break;
				
			case 4:
				//select books based on Publisher
				selectPublisher();
				break;
				
			case 5:
				//select books based on price range
				selectPrice();
				break;
				
			case 6:
				// select books based on year published
				selectYear();
				break;
				
			case 7:
				// select books based on title and publisher
				selectTitlePublisher();
				break;
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Type in a valid menu option: [1-7] ");
		}
	}

	/*
	 * Searches for all books in the book table in Bookmanager database.
	 */
	public void selectAll() {
		// Call ActivityController's selectAll method
		List<Book> list = controller.selectAll();
		if (list.size() != 0) // at least 1 book is found.
			print(list);
		else
			// no book is found
			System.out.println("No Book is found!");
	}

	/*
	 * Search for a book given the books title entered by the user.
	 */
	public void selectTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title of book: ");
		String title = sc.nextLine();
		List<Book> list = controller.selectTitle(title);
		if (list.size() != 0)
			print(list);
		else
			System.out.println("No Book is found during the specified time period!");
	}
	
	/*
	 * searches for a book given the user enters the book's ISBN number.
	 */
	public void selectISBN() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ISBN of book 9 digit value: ");
		String ISBN = sc.nextLine();
		List<Book> list = controller.selectISBN(ISBN);
		if (list.size() != 0)
			print(list);
		else
			System.out.println("No Book is found during the specified time period!");
	}
	
	/*
	 * searches for a book based on the a specific publisher the user wants to search by.
	 */
	public void selectPublisher() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Publisher of book: ");
		String publisher = sc.nextLine();
		List<Book> list = controller.selectPublisher(publisher);
		if (list.size() != 0)
			print(list);
		else
			System.out.println("No Book is found during the specified time period!");
	}
	
	/*
	 * Searches by given price bounds given by the user with a min and max value.
	 */
	public void selectPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Max Price of book: ");
		String strPriceMax = sc.nextLine();
		System.out.print("Enter Min Price of book: ");
		String strPriceMin = sc.nextLine();
		
		try { 
			Double priceMax = Double.valueOf(strPriceMax); 
			Double priceMin = Double.valueOf(strPriceMin); 
			List<Book> list = controller.selectPrice(priceMax,priceMin);
			
			if (list.size() != 0)
				print(list);
			else
				System.out.println("No Book is found during the specified time period!");
		}
		catch (NumberFormatException e) { e.printStackTrace(); System.out.println("Enter a valid price");}
	}
	/*
	 * Searches for a book based on a published year criteria.
	 */
	public void selectYear() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Year book was published in format YYYY: ");
		String yearstr = sc.nextLine();
		
		try { 
			Integer year = Integer.valueOf(yearstr); 
			List<Book> list = controller.selectYear(year);
			
			if (list.size() != 0)
				print(list);
			else
				System.out.println("No Book is found during the specified time period!");
		}
		catch (NumberFormatException e) { e.printStackTrace(); System.out.println("Enter a valid price");}
	}
	
	/*
	 * searches for books with a specific title and publisher.
	 */
	public void selectTitlePublisher() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title of book: ");
		String title = sc.nextLine();
		System.out.print("Enter publsher of book: ");
		String publisher = sc.nextLine();
		
		
			List<Book> list = controller.selectTitlePublisher(title,publisher);
			
			if (list.size() != 0)
				print(list);
			else
				System.out.println("No Book is found during the specified time period!");
		
	}
	
	
	/*
	 * Removes a book from the book table in the bookmanager database. 
	 * Book is removed by the given isbn value the user enters.
	 * 
	 */
	public void deleteBook() {
		// First, we display all existing activities to user
		selectAll();
		System.out.println("Enter the ISBN of the book you want to delete and press enter:");
		Scanner sc = new Scanner(System.in);
		String strisbn = sc.nextLine();
		BigInteger isbn = new BigInteger(strisbn);
		//Integer isbn = Integer.valueOf(strisbn);
		// pass the id to the controller
		controller.deleteBook(isbn);
		System.out.println("Activity is deleted.");
	}
	/*
	 * prints out the table of books using a for loop iteration.
	 */
	private void print(List<Book> list) {
		System.out.printf("%-5s %-25s %-35s%-15s%-15s%-30s%n", "ISBN", "      Title", "      Year", "     Published By", " Previous_Edition ", "  Price");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		// Iterate the list and print each item to console
		for (Book bk : list) {
			System.out.printf("%-5s %-25s %-35s%-15s%-15s%-30s%n", bk.getIsbn(), bk.getTitle(), bk.getYear(),
					bk.getPublished_by(), bk.getPrevious_edition(), bk.getPrice());
		}
	}
}
