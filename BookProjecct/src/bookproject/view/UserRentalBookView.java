package bookproject.view;

import java.util.Date;
import java.util.Optional;
import bookproject.controller.PersonalRental;
import bookproject.controller.RentalController;
import bookproject.controller.ReturnBookController;
import bookproject.controller.ReturnLogController;
import bookproject.controller.UserPointController;
import bookproject.vo.BookVO;
import bookproject.vo.LogVO;
import bookproject.vo.RentalVO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class UserRentalBookView {
	private BorderPane logIn = null;
	private Stage primaryStage = null;
	private Scene scene = null;

	public UserRentalBookView() {
		// TODO Auto-generated constructor stub
	}

	public UserRentalBookView(Stage primaryStage, Scene scene, BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.scene = scene;
		this.logIn = root;
	}

	TableView<RentalVO> tableView;
	Button homeBtn;
	Button bMBtn;
	Button rentalTBtn;

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
		
		rentalTBtn = new Button("내가 빌린 책 정보 보기");
		rentalTBtn.setPrefSize(150, 40);
		rentalTBtn.setOnAction(e -> {
			
			PersonalRental controller = new PersonalRental();
			
			//ObservableList<RentalVO> list = controller.getResult(idID);
			//tableView.setItems(list);
			
			//마이바티스로 내가 빌린 책 정보 보기
			ObservableList<RentalVO> listMB = controller.getRentalBookMB(idID);
			tableView.setItems(listMB);

		});
		
		
		flowpane.getChildren().add(rentalTBtn);
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

		TableColumn<RentalVO, Date> retalDay = new TableColumn<>("빌린 날짜");
		retalDay.setMinWidth(200);
		retalDay.setCellValueFactory(new PropertyValueFactory<>("rentalDay"));

		tableView = new TableView<RentalVO>();

		tableView.getColumns().addAll(booknum, btitle, user_ID, retalDay);
		
		
		//반납 화면 구현하기
		// 테이블의 행을 선택했을때의 이벤트처리
		tableView.setRowFactory(e -> {

			TableRow<RentalVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				RentalVO book = row.getItem();

				// 더블클릭했을 때의 이벤트 처리
				if (e1.getClickCount() == 2) {
					Dialog<ButtonType> dialog = new Dialog<>();

					dialog.setTitle("책 상세 정보");
					System.out.println("두번클릭 상세정보 띄우기");

					ButtonType type = new ButtonType("OK", ButtonData.OK_DONE);
					ButtonType rentalBtn = new ButtonType("반납", ButtonData.OK_DONE);
					
					dialog.setContentText(book.getBisbn()+" 해당도서를 반납하시겠습니까??");

					dialog.getDialogPane().setMinSize(700, 200);
					dialog.getDialogPane().getButtonTypes().addAll(rentalBtn, type);

					
					Optional<ButtonType> result = dialog.showAndWait();
					
					 if(result.get().getText().equals("반납")) {
						 System.out.println("반납 버튼 누름");
						 
						 ReturnBookController controller = new ReturnBookController();
				    	 RentalVO list = controller.getRenturn(book.getBisbn(), idID, book.getRentalDay());
				    	 
				    	 BookVO list1 = controller.getPlusBook(book.getBisbn());
				    	 
				    	 ObservableList<RentalVO> list2 = controller.getRenturn1(idID);
				    	 tableView.setItems(list2);
				    	 
				    	 ReturnLogController controllerR = new ReturnLogController();
				    	 LogVO log = controllerR.insertLog(book.getBisbn(), idID, book.getRentalDay());
				    	 
				    	 UserPointController controllerP = new UserPointController();
				    	 LogVO Plog = controllerP.getPoint(book.getBisbn(), idID);
				    	 
				    	 
						 
					 }

				}
			});
			return row;
		});
		


		root.setCenter(tableView);
		root.setBottom(flowpane);


		return root;

	}

}
