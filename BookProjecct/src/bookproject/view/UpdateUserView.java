package bookproject.view;

import bookproject.controller.GetUserInfoController;
import bookproject.controller.UpdateBookController;
import bookproject.controller.UpdateUserController;
import bookproject.vo.BookVO;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpdateUserView {
	   private BorderPane logIn=null;
	   private Stage primaryStage=null;
	   private Scene scene=null;
	   
	   public UpdateUserView() {
	      // TODO Auto-generated constructor stub
	   }
	   
	   public UpdateUserView(Stage primaryStage,Scene scene,BorderPane root) {
	      this.primaryStage=primaryStage;
	      this.scene = scene;
	      this.logIn=root;
	   }


	   private Text user_ID;
	   private Text user_PW;
	   private Text user_EM;
	   
	   private TextField user_ID_tf;
	   private TextField user_PW_tf;
	   private TextField user_EM_tf;
	   
	   

	   
	   private Button upDateUser;
	   private Button mainModBtn;
	   
	   public BorderPane setUser(String idID)
	   {
	      BorderPane root = new BorderPane();
	      root.setPrefSize(1000, 1500);
	      
	      
	      
	      //원래 접속 회원 정보 받아오기
	      GetUserInfoController controllerUser = new GetUserInfoController();
	      UserVO userInfo = controllerUser.getInfoController(idID);
	      
	      user_ID = new Text("현 아이디 ");
	      user_ID.setWrappingWidth(150);
	      user_ID_tf = new TextField();
	      user_ID_tf.setText(idID);
	      user_ID_tf.setDisable(true);
	      user_ID_tf.setPrefSize(200, 40);
	      
	      UserVO gp = new UserVO();
	      user_PW = new Text("수정할 비번 입력");
	      user_PW.setWrappingWidth(150);
	      user_PW_tf = new TextField();
	      user_PW_tf.setText(userInfo.getUser_PW());
	      user_PW_tf.setPrefSize(200, 40);
	      
	      user_EM = new Text("수정할 이메일 입력");
	      user_EM.setWrappingWidth(150);
	      user_EM_tf = new TextField();
	      user_EM_tf.setText(userInfo.getUser_EM());
	      user_EM_tf.setPrefSize(200, 40);

	      
	      FlowPane bsidfp = new FlowPane();
	      bsidfp.setAlignment(Pos.CENTER);
	      bsidfp.setColumnHalignment(HPos.CENTER);
	      bsidfp.setPrefSize(700, 60);
	      bsidfp.setHgap(10);
	      bsidfp.getChildren().add(user_ID);
	      bsidfp.getChildren().add(user_ID_tf);
	      
	      FlowPane btitlefp = new FlowPane();
	      btitlefp.setAlignment(Pos.CENTER);
	      btitlefp.setColumnHalignment(HPos.CENTER);
	      btitlefp.setPrefSize(700, 60);
	      btitlefp.setHgap(10);
	      btitlefp.getChildren().add(user_PW);
	      btitlefp.getChildren().add(user_PW_tf);
	      
	      FlowPane bdatefp = new FlowPane();
	      bdatefp.setAlignment(Pos.CENTER);
	      bdatefp.setColumnHalignment(HPos.CENTER);
	      bdatefp.setPrefSize(700, 60);
	      bdatefp.setHgap(10);
	      bdatefp.getChildren().add(user_EM);
	      bdatefp.getChildren().add(user_EM_tf);
	      
	      //회원정보 수정하기 수정하기
	      upDateUser = new Button("수정하기");
	      upDateUser.setPrefSize(150, 70);
	      upDateUser.setOnAction(e -> {
	    	  
	    	  UpdateUserController controller = new UpdateUserController();
	    	  UserVO user = controller.upDateUserController(user_ID_tf.getText(), user_PW_tf.getText(), user_EM_tf.getText(), idID);
	    	  
	    	  
				BookMain main = new BookMain();
				try {
					main.start(primaryStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	    	  
	      });
	      
	      mainModBtn = new Button("메인으로");
	      mainModBtn.setPrefSize(150, 70);
	      mainModBtn.setOnAction(e -> {
				BookSingUp signupview = new BookSingUp(primaryStage, scene, root);
		        scene.setRoot(signupview.getLogin(idID));
		        primaryStage.setScene(scene);
		        primaryStage.setTitle("도서 메인 프로그램 화면");
	      });

	      FlowPane bottomflowpane = new FlowPane();
	      bottomflowpane.setAlignment(Pos.CENTER);
	      bottomflowpane.setColumnHalignment(HPos.CENTER);
	      bottomflowpane.setPrefSize(700, 100);
	      bottomflowpane.setHgap(200);
	      bottomflowpane.getChildren().add(upDateUser);
	      bottomflowpane.getChildren().add(mainModBtn);
	      
	      VBox vBox = new VBox();
	      vBox.setAlignment(Pos.CENTER);
	      vBox.getChildren().add(bsidfp);
	      vBox.getChildren().add(btitlefp);
	      vBox.getChildren().add(bdatefp);
	      
	      
	      
	      root.setCenter(vBox);
	      root.setBottom(bottomflowpane);
	      
	      return root;
}
}
