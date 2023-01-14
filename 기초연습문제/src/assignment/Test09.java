package assignment;

import java.util.Arrays;

class Book{
	String category;
	String bookName;
	double bookPrice;
	double bookDiscountRate;
	
	public Book(String category, String bookName, double bookPrice, double bookDiscountRate) {
		super();
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}
	
	
	
	public double getDiscountBookPrice(){
		
		double total = 0.0;
		
		total = bookPrice - (bookPrice * (bookDiscountRate*0.01));
		
		return total;
		
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public double getBookPrice() {
		return bookPrice;
	}



	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}



	public double getBookDiscountRate() {
		return bookDiscountRate;
	}



	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}



	@Override
	public String toString() {
		return category+bookName+"     "+bookPrice+"원 "+bookDiscountRate+"%";
	}
	
	
	
	
}

public class Test09 {
	
	
	
	public static void main(String[] args) {
		
		double sumA = 0;
		double sumB = 0;
		
		Book bookArray [] = new Book[5];
		
		bookArray[0] = new Book("IT", "SQL PLUS", 50000.0, 5.0);
		bookArray[1] = new Book("IT", "Java 2.0", 40000.0, 3.0);
		bookArray[2] = new Book("IT", "JSP Servlet", 60000.0, 6.0);
		bookArray[3] = new Book("Nobel", "davincicode", 30000.0, 10.0);
		bookArray[4] = new Book("Nobel", "cloven hoof", 50000.0, 15.0);


		for(int i = 0; i < 5; i++) {
			System.out.println(bookArray[i].toString());
		}
		
		for(int i = 0; i < 5; i++) {
			if(bookArray[i].getCategory()=="IT") {
				sumA += bookArray[i].getBookPrice();
			} else if(bookArray[i].getCategory()=="Nobel") {
				sumB += bookArray[i].getDiscountBookPrice();
			}
		}
		System.out.println("\n"+sumA);
		System.out.println("\n"+sumB);
		
		
		
	}

}
