package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.UserVO;

public class GetUserInfoController {

	public UserVO getInfoController(String idID) {
		BookService service = new BookService();

		UserVO user = service.getInfoService(idID);
		return user;
	}

	public UserVO getInfoControllerMB(String idID) {
		BookService service = new BookService();

		UserVO user = service.getInfoServiceMB(idID);
		return user;
	}

}
