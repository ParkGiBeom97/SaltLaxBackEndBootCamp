package Exam01;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

public class Exam01_DateServer {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(3000);
			System.out.println("서버 소켓이 포트 번화 3000번으로 생성되었어요!!");
			//이 서버 소켓을 통해 클라이언트의 접속을 기다려야 해여!
			Socket s = server.accept();//일단 대기(클라이언트가 접속할 떄까지~)
			System.out.println("클라이언트의 접속이 들어왔어요!");
			
			//클라이언트와 연결된 output Stream(데이터를 내보내기 위한)을 사용하기 편한 PrintWriter로 만듬~
			PrintWriter out = new PrintWriter(s.getOutputStream());
			//현재 시간을 보내주는 코드 작성
			DateFormat dateFormat = DateFormat.getInstance();
			String currentDate = dateFormat.format(new Date());
			
			out.println(currentDate);
			out.flush(); //flush를 통해 데이터를 실제로 보냄
			
			
			
			//Stream을 통해 데이터를 보냈으면 데이터를 닫아줘야합니다
			out.close();
			//통신도 끝났으므로 Stream닫고 소캣도 닫아줍니다.
			s.close();
			//서버 소켓도 닫아줌
			server.close();
			
			System.out.println("서버 종료!~!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
