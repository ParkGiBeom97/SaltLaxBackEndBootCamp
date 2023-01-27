package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.UserVO;
import javafx.scene.control.TextField;

public class UpdateUserController {

	public UserVO upDateUserController(String string, String string2, String string3, String idID) {
		
		BookService service = new BookService();
		
		UserVO user = service.setUserDateService(string, string2, string3, idID);
		
		return null;
	}

}
