package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.BookVO;
import javafx.collections.ObservableList;

public class BookRentMinusController {

	public ObservableList<BookVO> getMinus(String bisbn) {
		
		BookService service = new BookService();
		
		ObservableList<BookVO> list = service.RentBookMinus(bisbn);
		
		return list;
		
	}

}
