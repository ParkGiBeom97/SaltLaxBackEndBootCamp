package assignment;

class BookUpdate{
	
	Book BookDate;
	
	
	public BookUpdate(Book bookDate) {
		BookDate = bookDate;
	}

	//기본생성자
	public BookUpdate() {
		// TODO Auto-generated constructor stub
	}

	public Book getBookDate() {
		return BookDate;
	}

	public void setBookDate(Book bookDate) {
		BookDate = bookDate;
	}

	
	public void updateBookPrice() {
		BookDate.setBookPrice(BookDate.getDiscountBookPrice());
	}
	

	
}

public class Test10 {

	public static void main(String[] args) {
		
		Book book1 = new Book("IT", "HTml", 30000, 15);
		
		BookUpdate book2 = new BookUpdate(book1);
		
		System.out.println("기본정보");
		System.out.println(book2.getBookDate().getBookName() + "     " + 	book2.getBookDate().getBookPrice());
		System.out.println("변경된 정보");
		book2.updateBookPrice();
		System.out.println(book2.getBookDate().getBookName() + "     " + 	book2.getBookDate().getBookPrice());
		
		
		
	}
	
}
