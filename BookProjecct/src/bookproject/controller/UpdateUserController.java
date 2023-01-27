package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.UserVO;

public class UpdateUserController {

	public UserVO upDateUserController(String string, String string2, String string3, String idID) {

		BookService service = new BookService();

		UserVO user = service.setUserDateService(string, string2, string3, idID);

		return null;
	}

	// 마이바티스 유저정보수정 컨트롤 부분
	public UserVO upDateUserControllerMB(String text, String text2, String text3, String idID) {
		BookService service = new BookService();
		UserVO user = service.setUserDateServiceMB(text, text2, text3, idID);
		return user;
	}

}
