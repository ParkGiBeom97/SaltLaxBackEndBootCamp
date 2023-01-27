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
	
	//마이바티스 책 대여 로그 가져오는 컨트롤러
	public ObservableList<LogVO> getLogMB() {
		BookService service = new BookService();
		ObservableList<LogVO> listMB = service.getLogMB();
		return listMB;
	}

}
