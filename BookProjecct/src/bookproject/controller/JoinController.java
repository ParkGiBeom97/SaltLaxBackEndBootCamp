package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;


public class JoinController {

	public ObservableList<UserVO> getResult(String id, String pw) {
		
		ObservableList<UserVO> list = 
				BookService.joinUser(id, pw);
		
		return list;
	}

}
