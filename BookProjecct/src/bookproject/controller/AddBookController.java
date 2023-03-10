package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.BookVO;
import javafx.collections.ObservableList;

public class AddBookController {

	public ObservableList<BookVO> addBookController(String text, String text2, String text3, int parseInt,
			int parseInt2, String text4, String text5, String text6, String text7, int parseInt3) {
		
		BookService service = new BookService();
		
		ObservableList<BookVO> list = service.addBookService(text, text2, text3, parseInt,
				parseInt2, text4, text5, text6, text7, parseInt3);
		
		return list;
	}
	
	//마이바티스로 책 추가하기 
	public ObservableList<BookVO> addBookControllerMB(String text, String text2, String text3, int parseInt,
			int parseInt2, String text4, String text5, String text6, String text7, int parseInt3) {
		
		BookService service = new BookService();
		ObservableList<BookVO> listMB = service.addBookServiceMB(text, text2, text3, parseInt,
				parseInt2, text4, text5, text6, text7, parseInt3);
		
		return listMB;
	}

}
