package bookproject.controller;

import java.util.Date;

import bookproject.service.BookService;
import bookproject.vo.LogVO;

public class ReturnLogController {

	public LogVO insertLog(String bisbn, String idID, Date date) {
		
		BookService service = new BookService();
		LogVO log = service.setReturnBookLogService(bisbn, idID, date);
		
		return log;
	}

}
