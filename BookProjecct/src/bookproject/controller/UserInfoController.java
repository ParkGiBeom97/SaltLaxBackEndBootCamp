package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;

public class UserInfoController {

	public ObservableList<UserVO> getResult(String idID) {
		
		BookService service = new BookService();
		
		ObservableList<UserVO> list=  service.UserInfo(idID);

		return list;
	}

}
