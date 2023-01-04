package bookproject.view;

import java.security.PublicKey;

import bookproject.controller.JoinController;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookJoinView{
   
   private BorderPane logIn=null;
   private Stage primaryStage=null;
   private Scene scene=null;
   
   public BookJoinView() {
      // TODO Auto-generated constructor stub
   }
   
   public BookJoinView(Stage primaryStage,Scene scene,BorderPane root) {
      this.primaryStage=primaryStage;
      this.scene = scene;
      this.logIn=root;
   }


   private Text id;
   private Text pw;
   private Text email;
   private TextField idtf;
   private TextField pwtf;
   private TextField emailtf;
   
   private Button signup;
   private Button login;
   
   public BorderPane getSignUp()
   {
      BorderPane root = new BorderPane();
      root.setPrefSize(700, 500);
      
      id = new Text("아이디 입력");
      id.setWrappingWidth(50);
      
      idtf = new TextField();
      idtf.setPrefSize(200, 40);
      
      pw = new Text("비밀번호 입력");
      pw.setWrappingWidth(50);
      
      pwtf = new TextField();
      pwtf.setPrefSize(200, 40);
      
      email = new Text("이메일 입력");
      email.setWrappingWidth(50);
      
      emailtf = new TextField();
      emailtf.setPrefSize(200, 40);

      
      FlowPane idflowpane = new FlowPane();
      idflowpane.setAlignment(Pos.CENTER);
      idflowpane.setColumnHalignment(HPos.CENTER);
      idflowpane.setPrefSize(700, 60);
      idflowpane.setHgap(10);
      idflowpane.getChildren().add(id);
      idflowpane.getChildren().add(idtf);
      
      FlowPane pwflowpane = new FlowPane();
      pwflowpane.setAlignment(Pos.CENTER);
      pwflowpane.setColumnHalignment(HPos.CENTER);
      pwflowpane.setPrefSize(700, 60);
      pwflowpane.setHgap(10);
      pwflowpane.getChildren().add(pw);
      pwflowpane.getChildren().add(pwtf);

      
      FlowPane emailflowpane = new FlowPane();
      emailflowpane.setAlignment(Pos.CENTER);
      emailflowpane.setColumnHalignment(HPos.CENTER);
      emailflowpane.setPrefSize(700, 60);
      emailflowpane.setHgap(10);
      emailflowpane.getChildren().add(email);
      emailflowpane.getChildren().add(emailtf);
      
      signup = new Button("가입");
      signup.setPrefSize(150, 70);
      signup.setOnAction(e -> {
    	  
    	  
    	  JoinController controller = new JoinController();
    	  ObservableList<UserVO> list = controller.getResult(idtf.getText(), pwtf.getText(), emailtf.getText());
    	  
    	  
    	  //회원가입하면 나와야되는 부분임
			BookMain main = new BookMain();
			try {
				main.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
         
      });
      
      login = new Button("로그인 화면으로...");
      login.setPrefSize(150, 70);
      login.setOnAction(e -> {
			BookMain main = new BookMain();
			try {
				main.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
      });

      FlowPane bottomflowpane = new FlowPane();
      bottomflowpane.setAlignment(Pos.CENTER);
      bottomflowpane.setColumnHalignment(HPos.CENTER);
      bottomflowpane.setPrefSize(700, 100);
      bottomflowpane.setHgap(200);
      bottomflowpane.getChildren().add(signup);
      bottomflowpane.getChildren().add(login);
      
      FlowPane flowpane = new FlowPane();
      flowpane.setAlignment(Pos.CENTER);
      flowpane.setColumnHalignment(HPos.CENTER);
      flowpane.setPrefSize(700, 400);
      flowpane.setVgap(10);
      flowpane.setOrientation(Orientation.VERTICAL);
      flowpane.getChildren().add(idflowpane);
      flowpane.getChildren().add(pwflowpane);
      flowpane.getChildren().add(emailflowpane);
      
      
      root.setCenter(flowpane);
      root.setBottom(bottomflowpane);
      
      return root;
   }
   
   public String getId() {
	   System.out.println(idtf.getText()+"아이디 출력합니다아~~~");
	return idtf.getText();
   }
}
