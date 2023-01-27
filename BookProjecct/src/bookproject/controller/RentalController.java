package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.RentalVO;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;

public class RentalController {

	public ObservableList<RentalVO> getRental(String bisbn, String btitle, String idID) {
		
		ObservableList<RentalVO> list = 
				BookService.RentalTable(bisbn, btitle, idID);
		
		return list;
	}

}
