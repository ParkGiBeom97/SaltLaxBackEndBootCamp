package bookproject.controller;


import bookproject.service.BookService;
import bookproject.vo.BookVO;
import javafx.collections.ObservableList;

public class BookSearchController {

	// 일반 MVC모델
	public ObservableList<BookVO> getResult(String text) {

		BookService service = new BookService();

		ObservableList<BookVO> list = service.BookSerch(text);

		return list;
	}

	// 마이베티스로 검색하는 뷰와 서비스를 연결하는 컨트롤러
	public ObservableList<BookVO> getResultMB(String text) {

		BookService service = new BookService();
		ObservableList<BookVO> list = service.BookSerchM(text);

		return list;
	}

}
