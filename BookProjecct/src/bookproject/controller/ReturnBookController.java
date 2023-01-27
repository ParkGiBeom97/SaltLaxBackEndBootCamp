package bookproject.controller;

import java.util.Date;

import bookproject.service.BookService;
import bookproject.vo.BookVO;
import bookproject.vo.RentalVO;
import javafx.collections.ObservableList;

public class ReturnBookController {

	public RentalVO getRenturn(String bisbn, String idID, Date date) {
		BookService service = new BookService();

		RentalVO returnBook = service.returnBookService(bisbn, idID, date);

		return returnBook;
	}

	public BookVO getPlusBook(String bisbn) {
		BookService service = new BookService();

		BookVO plusBook = service.plusBookService(bisbn);

		return plusBook;
	}

	// 책 반납후 테이블 리플래쉬
	public ObservableList<RentalVO> getRenturn1(String idID) {
		BookService service = new BookService();
		ObservableList<RentalVO> list = service.returnBookReflesh(idID);
		return list;
	}

}
