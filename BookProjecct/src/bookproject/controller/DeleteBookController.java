package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.BookVO;
import bookproject.vo.RentalVO;
import javafx.collections.ObservableList;

public class DeleteBookController {

	public ObservableList<BookVO> getDelete(String bisbn, String searchKeyword) {
		BookService service = new BookService();
		
		ObservableList<BookVO> list = service.deletBService(bisbn, searchKeyword);
		
		return list;
	}

	public RentalVO getRBDelete(String bisbn) {
		BookService service = new BookService();
		RentalVO deletR = service.deletRService(bisbn);
		return deletR;
	}

}
