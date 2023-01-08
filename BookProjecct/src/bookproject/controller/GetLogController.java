package bookproject.controller;

import bookproject.service.BookService;
import bookproject.vo.LogVO;
import javafx.collections.ObservableList;

public class GetLogController {

	public ObservableList<LogVO> getlogController() {
		
		BookService service = new BookService();
		
		ObservableList<LogVO> list = service.getLogService();
		

		
		return list;
	}

}
