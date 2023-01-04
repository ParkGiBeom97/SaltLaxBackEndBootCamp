package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.RentalVO;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;


public class JoinController {

	public ObservableList<UserVO> getResult(String id, String pw, String em) {
		
		ObservableList<UserVO> list = 
				BookService.joinUser(id, pw, em);
		
		return list;
	}



}
