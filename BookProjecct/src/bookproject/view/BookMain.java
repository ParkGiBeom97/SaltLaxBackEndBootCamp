package bookproject.view;

import bookproject.controller.BookSearchController;
import bookproject.controller.JoinController;
import bookproject.controller.LoginController;
import bookproject.vo.BookVO;
import bookproject.vo.UserVO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookMain extends Application {
	
	private Text id;
	private Text pw;
	TextField textField1;
	TextField textField2;
	Button loginBtn;
	Button joinBtn;
	
	Scene scene = null;
	BorderPane root = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		BorderPane root1 = new BorderPane();
		root1.setPrefSize(900, 500);
		
		FlowPane flowpane1 = new FlowPane();
		flowpane1.setPadding(new Insets(10,10,10,10));
		flowpane1.setColumnHalignment(HPos.CENTER);
		flowpane1.setPrefSize(900, 40);
		flowpane1.setHgap(10);
		
		FlowPane idFP = new FlowPane();
		id = new Text("아이디 입력");
	    id.setWrappingWidth(100);
		textField1 = new TextField();
		textField1.setPrefSize(250, 40);
		idFP.getChildren().add(id);
		idFP.getChildren().add(textField1);
		idFP.setHgap(15);
		
		FlowPane pwFP = new FlowPane();
		pw = new Text("비밀번호 입력");
      	pw.setWrappingWidth(100);
		textField2 = new TextField();
		textField2.setPrefSize(250, 40);
		pwFP.getChildren().add(pw);
		pwFP.getChildren().add(textField2);
		pwFP.setHgap(15);
		
		flowpane1.getChildren().add(idFP);
		flowpane1.getChildren().add(pwFP);
		
		loginBtn = new Button("로그인하기");
		loginBtn.setPrefSize(150, 40);
		joinBtn = new Button("회원가입하기");
		joinBtn.setPrefSize(150, 40);
		FlowPane flowpane2 = new FlowPane();
		flowpane2.setPadding(new Insets(10,40,10,10));
		flowpane2.getChildren().add(loginBtn);
		flowpane2.getChildren().add(joinBtn);
		
		//프로그램 제목
		Label label = new Label("도서 프로그램에 오신걸 환영합니다!!");
		label.setFont(Font.font("Arial", FontWeight.BOLD, 45));
		FlowPane flowpane3 = new FlowPane();
		flowpane3.setPadding(new Insets(10,10,10,10));
		flowpane3.getChildren().add(label);
		flowpane3.setAlignment(Pos.CENTER);

		
		//플로운 팬 요소 간격 및 요소 배치 설정
		flowpane1.setOrientation(Orientation.VERTICAL);
		flowpane1.setVgap(20);
		flowpane1.setAlignment(Pos.CENTER);
	    flowpane1.setColumnHalignment(HPos.CENTER);
	    
	    
		flowpane2.setHgap(20);
		flowpane2.setAlignment(Pos.CENTER);
		
		
		//로그인 버튼 클릭시 기능 구현
		loginBtn.setOnAction(e->{
			

			
			LoginController controller = new LoginController();
			//Boolean user = controller.getResult(textField1.getText(), textField2.getText());
			
			//마이바티스 로그인 뷰 구현하기..
			Boolean userMB = controller.getResultMB(textField1.getText(), textField2.getText());
			
			if(textField1.getText() == "" || textField2.getText() == "") {
				System.out.println("공백은 안됩니다");
			} else if(userMB) {
				if(textField1.getText().equals("admin")) {
					System.out.println("관리자모드로 실행합니다");
					adminView adminmode = new adminView(primaryStage, scene, root1);
					scene.setRoot(adminmode.getLogin(textField1.getText()));
					primaryStage.setTitle("관리자모드 실행중...");
					
				} else {
				BookSingUp signupview = new BookSingUp(primaryStage, scene, root1);
		        scene.setRoot(signupview.getLogin(textField1.getText()));
		        primaryStage.setScene(scene);
		        primaryStage.setTitle("도서 메인 프로그램 화면");
				}
			}
			
		});
		
		//회원가입 버튼 클릭시 기능 구현
		joinBtn.setOnAction(e->{
			
			
			BookJoinView join = new BookJoinView(primaryStage,scene,root);
	        scene.setRoot(join.getSignUp());
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("회원가입");
	               
	        
		});

		scene = new Scene(root1);
		root1.setTop(flowpane3);
		root1.setCenter(flowpane1);
		root1.setBottom(flowpane2);
	

		
		primaryStage.setScene(scene);
		primaryStage.setTitle("도서 프로그램 로그인");
					
		primaryStage.setOnCloseRequest(e -> {
			//창을 완전히 껏을 때 발생하는 이벤트
			System.out.println("도서 프로그램을 완전히 종료합니다.");
		});
		
		primaryStage.show();
	}

	
	public static void main(String[] args) {
		launch();
	}


	
	
}
