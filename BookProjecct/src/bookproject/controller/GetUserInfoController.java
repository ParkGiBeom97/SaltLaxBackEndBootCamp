package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.UserVO;

public class GetUserInfoController {

	public UserVO getInfoController(String idID) {
		BookService service = new BookService();
		
		UserVO user = service.getInfoService(idID);
		return user;
	}

}
