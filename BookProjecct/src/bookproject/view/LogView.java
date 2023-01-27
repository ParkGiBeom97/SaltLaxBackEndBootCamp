package bookproject.view;

import bookproject.controller.GetLogController;
import bookproject.vo.LogVO;
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

public class LogView {
	private BorderPane logIn = null;
	private Stage primaryStage = null;
	private Scene scene = null;

	public LogView() {
		// TODO Auto-generated constructor stub
	}

	public LogView(Stage primaryStage, Scene scene, BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.scene = scene;
		this.logIn = root;
	}

	TableView<LogVO> tableView;
	Button infoBtn;
	Button homeBtn;
	Button bMBtn;

	String deleteISBN;
	String searchKeyword;
	String detailISBN;

	public BorderPane getLog(String idID) {
		System.out.println("접속한 유저 아이디 :  " + idID);
		BorderPane root = new BorderPane();
		root.setPrefSize(900, 500);

		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(900, 40);
		flowpane.setHgap(10);

		infoBtn = new Button("로그 기록 보기");
		infoBtn.setPrefSize(150, 40);
		infoBtn.setOnAction(e -> {

			System.out.println("로그기록 가져오기");

			GetLogController controller = new GetLogController();
			// ObservableList<LogVO> list = controller.getlogController();
			// tableView.setItems(list);

			// 마이바티스로 책 대여로그 보기
			ObservableList<LogVO> listMB = controller.getLogMB();
			tableView.setItems(listMB);
		});

		bMBtn = new Button("책 목록 화면");
		bMBtn.setPrefSize(150, 40);
		bMBtn.setOnAction(e -> {
			System.out.println("관리자모드로 실행합니다");
			adminView adminmode = new adminView(primaryStage, scene, root);
			scene.setRoot(adminmode.getLogin(idID));
			primaryStage.setTitle("관리자모드 실행중...");
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

		flowpane.getChildren().add(infoBtn);
		flowpane.getChildren().add(bMBtn);
		flowpane.getChildren().add(homeBtn);
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setHgap(50);
		flowpane.setVgap(15);

		TableColumn<LogVO, String> bisbn = new TableColumn<>("책 번호");
		bisbn.setMinWidth(180);
		bisbn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<LogVO, String> userId = new TableColumn<>("빌린 사람 아이디");
		userId.setMinWidth(180);
		userId.setCellValueFactory(new PropertyValueFactory<>("user_ID"));

		TableColumn<LogVO, String> btitle = new TableColumn<>("빌린 책");
		btitle.setMinWidth(180);
		btitle.setCellValueFactory(new PropertyValueFactory<>("btitle"));

		TableColumn<LogVO, String> retalDay = new TableColumn<>("빌린 날짜");
		retalDay.setMinWidth(180);
		retalDay.setCellValueFactory(new PropertyValueFactory<>("retalDay"));

		TableColumn<LogVO, Integer> returnDay = new TableColumn<>("반납 날짜");
		returnDay.setMinWidth(180);
		returnDay.setCellValueFactory(new PropertyValueFactory<>("returnDay"));

		tableView = new TableView<LogVO>();

		tableView.getColumns().addAll(bisbn, userId, btitle, retalDay, returnDay);

		root.setCenter(tableView);
		root.setBottom(flowpane);

		return root;

	}
}
