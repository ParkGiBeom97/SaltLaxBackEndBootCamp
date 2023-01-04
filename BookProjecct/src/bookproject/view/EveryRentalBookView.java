package bookproject.view;

import bookproject.controller.EveryBookRentalController;
import bookproject.controller.PersonalRental;
import bookproject.vo.RentalVO;
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

public class EveryRentalBookView {
	private BorderPane logIn = null;
	private Stage primaryStage = null;
	private Scene scene = null;

	public EveryRentalBookView() {
		// TODO Auto-generated constructor stub
	}

	public EveryRentalBookView(Stage primaryStage, Scene scene, BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.scene = scene;
		this.logIn = root;
	}

	TableView<RentalVO> tableView;
	Button homeBtn;
	Button bMBtn;
	Button okBtn;

	String deleteISBN;
	String searchKeyword;
	String detailISBN;
	

	public BorderPane getRentBook(String idID) {
		System.out.println("접속한 유저 아이디 :  " + idID);
		BorderPane root = new BorderPane();
		root.setPrefSize(900, 500);

		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(900, 40);
		flowpane.setHgap(10);
		

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
		
		okBtn = new Button("대여 현황 확인");
		okBtn.setPrefSize(150, 40);
		okBtn.setOnAction(e -> {
			
			EveryBookRentalController controller = new EveryBookRentalController();
			ObservableList<RentalVO> list = controller.getResult();
			
			tableView.setItems(list);
			
		});
		
		
		flowpane.getChildren().add(okBtn);
		flowpane.getChildren().add(bMBtn);
		flowpane.getChildren().add(homeBtn);
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setHgap(50);


		TableColumn<RentalVO, String> booknum = new TableColumn<>("책 번호");
		booknum.setMinWidth(200);
		booknum.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<RentalVO, String> btitle = new TableColumn<>("책 제목");
		btitle.setMinWidth(200);
		btitle.setCellValueFactory(new PropertyValueFactory<>("btitle"));

		TableColumn<RentalVO, String> user_ID = new TableColumn<>("유저 아이디");
		user_ID.setMinWidth(200);
		user_ID.setCellValueFactory(new PropertyValueFactory<>("user_ID"));

		TableColumn<RentalVO, java.sql.Date> retalDay = new TableColumn<>("빌린 날짜");
		retalDay.setMinWidth(200);
		retalDay.setCellValueFactory(new PropertyValueFactory<>("rentalDay"));

		tableView = new TableView<RentalVO>();

		tableView.getColumns().addAll(booknum, btitle, user_ID, retalDay);
		


		root.setCenter(tableView);
		root.setBottom(flowpane);


		return root;

	}
}
