package bookproject.controller;

import bookproject.service.BookService;

public class LoginController {

	public Boolean getResult(String text, String text2) {
		
		Boolean user = BookService.loginUser(text, text2);
		
		return user;
	}

	//마이바티스로 회원가입 컨트롤러 새로 생성
	public Boolean getResultMB(String text, String text2) {
		BookService service = new BookService();
		
		Boolean loginCheck = service.LoginUserCheck(text, text2);
		
		return loginCheck;
	}
	
}
