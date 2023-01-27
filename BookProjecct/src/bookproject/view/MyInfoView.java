package bookproject.view;


import bookproject.controller.UserInfoController;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MyInfoView {

	private BorderPane logIn = null;
	private Stage primaryStage = null;
	private Scene scene = null;

	public MyInfoView() {
		// TODO Auto-generated constructor stub
	}

	public MyInfoView(Stage primaryStage, Scene scene, BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.scene = scene;
		this.logIn = root;
	}

	TableView<UserVO> tableView;
	Button infoBtn;
	Button homeBtn;
	Button bMBtn;
	Button rentalTBtn;
	Button upDateBtn;

	String deleteISBN;
	String searchKeyword;
	String detailISBN;

	public BorderPane getInfo(String idID) {
		System.out.println("접속한 유저 아이디 :  " + idID);
		BorderPane root = new BorderPane();
		root.setPrefSize(900, 500);

		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(900, 40);
		flowpane.setHgap(10);

		infoBtn = new Button("내 정보 가져오기");
		infoBtn.setPrefSize(150, 40);

		infoBtn.setOnAction(e -> {

			System.out.println("유저 정보 가져오는 중...");

			UserInfoController controller = new UserInfoController();
			// ObservableList<UserVO> list = controller.getResult(idID);

			// 마이바티스로 가져오기
			ObservableList<UserVO> listMB = controller.getResultMB(idID);
			tableView.setItems(listMB);

		});

		homeBtn = new Button("로그인 화면");
		homeBtn.setPrefSize(150, 40);
		homeBtn.setOnAction(e -> {
			BookMain main = new BookMain();
			try {

				main.start(primaryStage);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		bMBtn = new Button("책 목록 화면");
		bMBtn.setPrefSize(150, 40);
		bMBtn.setOnAction(e -> {
			BookSingUp signupview = new BookSingUp(primaryStage, scene, root);
			scene.setRoot(signupview.getLogin(idID));
			primaryStage.setScene(scene);
			primaryStage.setTitle("도서 메인 프로그램 화면");
		});

		rentalTBtn = new Button("내가 빌린 책");
		rentalTBtn.setPrefSize(150, 40);
		rentalTBtn.setOnAction(e -> {
			UserRentalBookView rentBook = new UserRentalBookView(primaryStage, scene, root);
			scene.setRoot(rentBook.getRentBook(idID));
			primaryStage.setScene(scene);
			primaryStage.setTitle("내가 빌린 책 목록");
		});

		upDateBtn = new Button("내정보 수정");
		upDateBtn.setPrefSize(150, 40);
		upDateBtn.setOnAction(e -> {
			UpdateUserView rentBook = new UpdateUserView(primaryStage, scene, root);
			scene.setRoot(rentBook.setUser(idID));
			primaryStage.setScene(scene);
			primaryStage.setTitle("정보 수정하기");
		});

		flowpane.getChildren().add(infoBtn);
		flowpane.getChildren().add(rentalTBtn);
		flowpane.getChildren().add(bMBtn);
		flowpane.getChildren().add(homeBtn);
		flowpane.getChildren().add(upDateBtn);
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setHgap(50);
		flowpane.setVgap(15);

		TableColumn<UserVO, String> userId = new TableColumn<>("아이디");
		userId.setMinWidth(200);
		userId.setCellValueFactory(new PropertyValueFactory<>("user_ID"));

		TableColumn<UserVO, String> userPw = new TableColumn<>("비밀번호");
		userPw.setMinWidth(200);
		userPw.setCellValueFactory(new PropertyValueFactory<>("user_PW"));

		TableColumn<UserVO, String> userEm = new TableColumn<>("이메일");
		userEm.setMinWidth(200);
		userEm.setCellValueFactory(new PropertyValueFactory<>("user_EM"));

		TableColumn<UserVO, Integer> userP = new TableColumn<>("보유 포인트");
		userP.setMinWidth(200);
		userP.setCellValueFactory(new PropertyValueFactory<>("user_point"));

		tableView = new TableView<UserVO>();

		tableView.getColumns().addAll(userId, userPw, userEm, userP);

		root.setCenter(tableView);
		root.setBottom(flowpane);

		return root;

	}

}
