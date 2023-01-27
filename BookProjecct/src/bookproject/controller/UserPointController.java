package bookproject.controller;

import java.util.Date;

import bookproject.service.BookService;
import bookproject.vo.LogVO;

public class UserPointController {

	public LogVO getPoint(String bisbn, String idID) {
		
		BookService service = new BookService();
		LogVO log = service.getPointService(bisbn, idID);
		
		return log;
	}

}
