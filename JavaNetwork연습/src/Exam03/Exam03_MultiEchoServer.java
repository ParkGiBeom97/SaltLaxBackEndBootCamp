package Exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class MyRunable implements Runnable {

	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	
	public MyRunable() {
		// TODO Auto-generated constructor stub
	}
	
	public MyRunable(Socket socket) {
		this.socket = socket;
		
		try {
			this.pr = new PrintWriter(socket.getOutputStream());
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public void run() {
		while(true) {
			
			String msg = null;
			
			try {
				msg = br.readLine();
				
				pr.println(msg);
				pr.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(msg.equals("/exit")) {
				break;
			}

		}		
	}
	
}

public class Exam03_MultiEchoServer extends Application {

	TextArea textarea;
	Button startBtn;
	Button stopBtn;
	ServerSocket server;
	Socket socket;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 창의 화면 구성
		//primaryStage가 실제 window 즉 창임.
		
		// Layout을 먼저 만듬
		//BorderPane을 이용해서 만듬
		BorderPane root = new BorderPane();
		
		//실제 화면 구성
		root.setPrefSize(700,500); // Layout의 가로세로 크기
		//창에 텍스트를 칠 수 있는 공간을 구현해줌
		textarea = new TextArea();
		root.setCenter(textarea);
		
		startBtn = new Button("서버시작!!");
		startBtn.setPrefSize(150, 40);
		// 버튼을 클릭했을때(클릭은 ActionEvent) 이벤트 처리가 나와요!
		// 이벤트 처리는 Listener객체(Handler객체)가 담당 => delegation model
		
		//람다시 표현 (arrow function)
		startBtn.setOnAction(e -> {			
			// blocking method!! 실행되는 동안 수행이 잠시 중지되요!
			// 아하 이렇게 하면 안되요!
			// 순차처리를 안하기 위해서 당연히 Thread를 사용해야 되요!
			//이 블럭안에 이벤트 처리 코드를 작성함
			printMsg("서버가 시작되었어요!");
			try {
				server = new ServerSocket(7777);
				printMsg("클라이언트 접속대기중!!!");
				
				(new Thread(() -> {
					try {
						while(true) {
							socket = server.accept();
							printMsg("새로운 클라이언트 접속 성공!!");
							(new Thread(new MyRunable(socket))).start();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				})).start();				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
				
		stopBtn = new Button("서버중지!!");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(null);
		
		FlowPane flowPane = new FlowPane();
		//상하좌우 여백 설정
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER);  // 정렬
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		
		flowPane.getChildren().add(startBtn);
		flowPane.getChildren().add(stopBtn);
		
		root.setBottom(flowPane);
		
		//레이아웃을 이영해서 장면(scene)을 만듬
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		//창의 제목을 정해줌
		primaryStage.setTitle("메아리 프로그램 서버");
		
		//실제로 창을 보여주는 메소드 show
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		//메인 쓰레드에 의해서 최초로 실행되는 메소드
		//entry point
		
		//GUI Thread를 하나 생성
		launch();   // GUI Thread가 생성되서 우리 창이 실행되요!
	}
	
}
