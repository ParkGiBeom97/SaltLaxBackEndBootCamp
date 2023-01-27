package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.RentalVO;
import javafx.collections.ObservableList;

public class EveryBookRentalController {

	public ObservableList<RentalVO> getResult() {

		BookService service = new BookService();

		ObservableList<RentalVO> list = service.RentBookS();

		return list;
	}

	public ObservableList<RentalVO> getRentalNowController() {
		BookService service = new BookService();

		ObservableList<RentalVO> list = service.RentBookSMB();

		return list;
	}

}
