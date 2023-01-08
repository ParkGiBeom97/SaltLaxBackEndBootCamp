package bookproject.controller;


import java.util.*;

import bookproject.service.BookService;
import bookproject.vo.LogVO;

public class RentalLogController {

	public LogVO insetRLog(String bisbn, String idID, String btitle, Date now) {
		
		BookService service = new BookService();
		LogVO log = service.inlogService(bisbn,idID, btitle, now);
		
		return log;
	}

}
