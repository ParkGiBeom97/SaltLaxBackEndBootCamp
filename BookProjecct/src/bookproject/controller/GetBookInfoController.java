package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.BookVO;

public class GetBookInfoController {

	public BookVO getBInfoController(String bookISBN) {
		BookService bs = new BookService();
		BookVO book = bs.getBIService(bookISBN);
		return book;
	}

}
