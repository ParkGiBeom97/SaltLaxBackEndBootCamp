package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.BookVO;
import javafx.collections.ObservableList;

public class UpdateBookController {

	public ObservableList<BookVO> updateBookController(String text, String text2, String text3, int parseInt,
			int parseInt2, String text4, String text5, String text6, String text7, int parseInt3, String bookISBN) {

		BookService service = new BookService();

		ObservableList<BookVO> list = service.updateBookService(text, text2, text3, parseInt, parseInt2, text4, text5,
				text6, text7, parseInt3, bookISBN);

		return list;
	}
	
	//마이바티스 책 수정
	public ObservableList<BookVO> updateBookControllerMB(String text, String text2, String text3, int parseInt,
			int parseInt2, String text4, String text5, String text6, String text7, int parseInt3, String bookISBN) {
		BookService service = new BookService();

		ObservableList<BookVO> list = service.updateBookServiceMB(text, text2, text3, parseInt, parseInt2, text4, text5,
				text6, text7, parseInt3, bookISBN);
		return list;
	}

}
