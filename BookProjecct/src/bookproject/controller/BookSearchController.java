package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.BookVO;
import javafx.collections.ObservableList;

public class BookSearchController {

	public ObservableList<BookVO> getResult(String text) {
		
		BookService service = new BookService();
		
		ObservableList<BookVO> list=  service.BookSerch(text);

		
		
		return list;
	}
	

	
	

}
