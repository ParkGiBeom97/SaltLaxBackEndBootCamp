package Exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_DateClient extends Application {
	
	TextArea textarea;
	Button connBtn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//화면 구성을 해보아요~
		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		//component 생성
		textarea = new TextArea();
		root.setCenter(textarea);
		
		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				//서버와 접속하는 코드를 만들어주면 됨
				textarea.clear(); //textarea 공간의 내용을 싹 지움
				//서버 접속 => 소켓 객체 생성을 시도 
				//서버에 접속할려면 IP와 포트 번호를 알아야해여
				//자신을 찾을 때 사용하는 IP는 127.0.0.1임 , localhost 써도 됨
				try {
					Socket s = new Socket("127.0.0.1", 3000);//룩백
					System.out.println("서버에 접속 성공");
					
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					
					String msg = br.readLine();
					
					System.out.println(msg);
					
					br.close();
					s.close();
					System.out.println("서버와 연결 종료~~");
					
					
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		
		//만든 flowpan에 connBtn을 붙임
		flowpane.getChildren().add(connBtn);
		
		
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	
	
	public static void main(String[] args) {
		launch();
	}


}
