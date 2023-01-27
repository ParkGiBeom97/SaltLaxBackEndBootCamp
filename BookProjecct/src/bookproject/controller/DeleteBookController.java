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

	// 마이바티스로 삭제하는 삭제 컨트롤부분
	public ObservableList<BookVO> getDeleteMB(String bookISBN, String searchKeyword) {
		BookService service = new BookService();
		ObservableList<BookVO> listMB = service.deletBServiceMB(bookISBN, searchKeyword);

		return listMB;
	}

	// 마이바티스로 대여테이블에서 책 지우기
	public RentalVO getRBDeleteMB(String bookISBN) {
		BookService service = new BookService();
		RentalVO deletR = service.deletRServiceMB(bookISBN);
		return deletR;
	}

}
