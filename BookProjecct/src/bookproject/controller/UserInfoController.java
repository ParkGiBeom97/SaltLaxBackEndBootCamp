package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;

public class UserInfoController {

	public ObservableList<UserVO> getResult(String idID) {

		BookService service = new BookService();

		ObservableList<UserVO> list = service.UserInfo(idID);

		return list;
	}

	// 마이바티스로 정보 자기 정보 가져오기
	public ObservableList<UserVO> getResultMB(String idID) {
		BookService service = new BookService();
		ObservableList<UserVO> list = service.userInfoMB(idID);

		return list;

	}

}
