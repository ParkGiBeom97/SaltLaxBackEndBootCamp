package Exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam03_MultiEchoClient extends Application {

	TextArea textarea;
	Button connBtn;
	TextField chattextField;
	TextField idField;
	TextField ipTextField;
	
	
	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 창의 화면 구성을 하게 되요!
		// Layout
		BorderPane root = new BorderPane();
		root.setPrefSize(700,500); // Layout의 가로세로 크기
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		FlowPane upflowPane = new FlowPane();
		upflowPane.setPadding(new Insets(10,10,10,10));
		upflowPane.setColumnHalignment(HPos.CENTER);  // 정렬
		upflowPane.setPrefSize(700, 40);
		upflowPane.setHgap(10);
		
		ipTextField = new TextField();
		ipTextField.setPrefSize(200, 40);
		
		
		connBtn = new Button("서버에 접속하기!!");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e -> {		
			
			try {
				socket = new Socket(ipTextField.getText(), 7777);
				printMsg("서버에 연결이 성공했습니다.");
				
				connBtn.setDisable(true);				
				chattextField.setDisable(false);
				idField.setDisable(false);
				
				pr = new PrintWriter(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e1) {
			}
		});
		
		
		upflowPane.getChildren().add(connBtn);		
		upflowPane.getChildren().add(ipTextField);
		
		idField = new TextField();
		idField.setPrefSize(200, 40);
		idField.setDisable(true);
		
		chattextField = new TextField();
		chattextField.setPrefSize(300, 40);
		chattextField.setDisable(true);
		
		
		chattextField.setOnAction(e -> {
			String msg = chattextField.getText();
			String id = idField.getText();
			
			pr.println(id + "> " + msg);//println()을 사용해야함 print()사용 주의 
			pr.flush();
			
			if(!msg.equals("/exit")) {
				try {
					printMsg(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			} else {
				printMsg("클라이언트가 서버와 연결이 종료되었어요!");
				idField.setDisable(true);
				chattextField.setDisable(true);
			}
			
			chattextField.clear();
		});
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER);  // 정렬
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		
		
		flowPane.getChildren().add(idField);
		flowPane.getChildren().add(chattextField);
		
		root.setTop(upflowPane);
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("메아리 프로그램 고객");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
