package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.RentalVO;
import javafx.collections.ObservableList;

public class PersonalRental {

	public ObservableList<RentalVO> getResult(String idID) {
		
		BookService service = new BookService();
		
		ObservableList<RentalVO> list = service.getPersonalRentalInfo(idID);
		
		
		return list;
	}

}
