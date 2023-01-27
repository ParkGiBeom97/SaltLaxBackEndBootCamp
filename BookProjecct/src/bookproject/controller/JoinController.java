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

	//마이바티스 코드 컨트롤 부분 
	public ObservableList<UserVO> getResultMB(String id, String pw, String em) {
		BookService service = new BookService();
		
		ObservableList<UserVO> list = service.joinUserMB(id, pw, em);
		
		return list;
	}



}
