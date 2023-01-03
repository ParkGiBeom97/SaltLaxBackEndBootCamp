package bookproject.controller;

import bookproject.service.BookService;

public class LoginController {

	public Boolean getResult(String text, String text2) {
		
		Boolean user = BookService.loginUser(text, text2);
		
		return user;
	}
	
}
