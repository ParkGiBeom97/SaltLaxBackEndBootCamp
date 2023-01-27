package bookproject.view;

import java.util.Optional;

import bookproject.controller.BookRentMinusController;
import bookproject.controller.BookSearchController;
import bookproject.controller.DeleteBookController;
import bookproject.controller.RentalController;
import bookproject.controller.UpdateBookController;
import bookproject.vo.BookVO;
import bookproject.vo.RentalVO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class adminView {


	private BorderPane logIn = null;
	private Stage primaryStage = null;
	private Scene scene = null;

	public adminView() {
		// TODO Auto-generated constructor stub
	}

	public adminView(Stage primaryStage, Scene scene, BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.scene = scene;
		this.logIn = root;
	}

	TableView<BookVO> tableView;
	TextField textField;
	TextField textField1;
	TextField textField2;
	
	Button insertBtn;
	Button homeBtn;
	Button rentalBtn;
	Button updateBtn;
	Button deleteBtn;
	Button logBtn;

	String bookISBN;
	String searchKeyword;
	String detailISBN;
	

	public BorderPane getLogin(String idID) {
		System.out.println("접속한 유저 아이디 :  " + idID);
		BorderPane root = new BorderPane();
		root.setPrefSize(900, 500);

		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(900, 40);
		flowpane.setHgap(10);

		textField = new TextField();
		textField.setPrefSize(230, 40);
		
		// 검색창에 엔터를 눌렀을때 이벤트 처리
		textField.setOnAction(e -> {
			BookSearchController controller = new BookSearchController();
			searchKeyword = textField.getText();
			//ObservableList<BookVO> list = controller.getResult(searchKeyword);
			//tableView.setItems(list);
			
			//마이바티스로 검색
			ObservableList<BookVO> listMB = controller.getResultMB(searchKeyword);
			tableView.setItems(listMB);

			textField.clear();
		});


		// 책 삽입 버튼
		insertBtn = new Button("책 추가하기");
		insertBtn.setPrefSize(140, 40);
		insertBtn.setOnAction(e -> {
			
			InsertBookView insertB = new InsertBookView(primaryStage,scene,root);
	        scene.setRoot(insertB.insertBook(idID, searchKeyword));
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("책 추가하기");
      
		});
		
		// 책 수정 버튼
		updateBtn = new Button("책 수정하기");
		updateBtn.setPrefSize(140, 40);
		updateBtn.setDisable(true);
		updateBtn.setOnAction(e -> {
			System.out.println(bookISBN + "책의 수정버튼을 누름");
			
			UpdateBookView updateB = new UpdateBookView(primaryStage,scene,root);
	        scene.setRoot(updateB.setBook(idID, bookISBN, searchKeyword));
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("책 수정하기");

		});
		
		// 책 삭제 버튼

		deleteBtn = new Button("선택된 책 삭제");
		deleteBtn.setPrefSize(140, 40);
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e -> {
			 DeleteBookController controller = new DeleteBookController();
			 ObservableList<BookVO> list = controller.getDelete(bookISBN, searchKeyword);
			 tableView.setItems(list);
	    	 
	    	 RentalVO deleteR = controller.getRBDelete(bookISBN);
		});
		
		
		//로그인으로 돌아가기
		homeBtn = new Button("로그인 화면");
		homeBtn.setPrefSize(140, 40);
		homeBtn.setOnAction(e -> {
			BookMain main = new BookMain();
			try {
				main.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		//로그 기록보는 코드
		logBtn = new Button("로그 보기");
		logBtn.setPrefSize(140, 40);
		logBtn.setOnAction(e -> {
			LogView log = new LogView(primaryStage, scene, root);
			scene.setRoot(log.getLog(idID));
			primaryStage.setScene(scene);
	        primaryStage.setTitle("로그 기록창");
		});
		

		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(insertBtn);
		flowpane.getChildren().add(updateBtn);
		flowpane.getChildren().add(deleteBtn);
		flowpane.getChildren().add(logBtn);
		flowpane.getChildren().add(homeBtn);
		flowpane.setVgap(15);

		
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("책 번호");
		isbnColumn.setMinWidth(140);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<BookVO, String> titleColumn = new TableColumn<>("책 제목");
		titleColumn.setMinWidth(140);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));

		TableColumn<BookVO, String> authorColumn = new TableColumn<>("책 작가");
		authorColumn.setMinWidth(140);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("책 가격");
		priceColumn.setMinWidth(140);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));

		TableColumn<BookVO, Integer> bpageColumn = new TableColumn<>("책 페이지 수");
		bpageColumn.setMinWidth(140);
		bpageColumn.setCellValueFactory(new PropertyValueFactory<>("bpage"));

		TableColumn<BookVO, String> bpublisherColumn = new TableColumn<>("출판사");
		bpublisherColumn.setMinWidth(140);
		bpublisherColumn.setCellValueFactory(new PropertyValueFactory<>("bpublisher"));

		tableView = new TableView<BookVO>();

		tableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, priceColumn, bpageColumn,
				bpublisherColumn);

		

		// 테이블의 행을 선택했을때의 이벤트처리
		tableView.setRowFactory(e -> {

			TableRow<BookVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				BookVO book = row.getItem();
				
				BookVO book1 = row.getItem();
				bookISBN = book1.getBisbn();
				
				updateBtn.setDisable(false);
				deleteBtn.setDisable(false);

				// 더블클릭했을 때의 이벤트 처리
				if (e1.getClickCount() == 2) {
					Dialog<ButtonType> dialog = new Dialog<>();

					dialog.setTitle("책 상세 정보");
					System.out.println("두번클릭 상세정보 띄우기");
					
					
					
					ButtonType type = new ButtonType("OK", ButtonData.OK_DONE);
					ButtonType rentalBtn = new ButtonType("삭제", ButtonData.OK_DONE);
					
					dialog.setContentText("|책 번호 :  "+book.getBisbn()+"| |책 제목 :  "+book.getBtitle()+
							"| |책 페이지수 :  "+book.getBpage()+"| |출판사 :  " +book.getBpublisher()+"| "+"\n 선택하신 도서 정보입니다.??");

					dialog.getDialogPane().setMinSize(700, 200);
					dialog.getDialogPane().getButtonTypes().addAll(rentalBtn, type);

					
					Optional<ButtonType> result = dialog.showAndWait();
					
					 if(result.get().getText().equals("삭제")) {
						 System.out.println("삭제 버튼 누름");
						 
						 //책 테이블 대여테이블 개인대여테이블에서 다 날려야됨
						 DeleteBookController controller = new DeleteBookController();
						 ObservableList<BookVO> list = controller.getDelete(book.getBisbn(), searchKeyword);
						 tableView.setItems(list);
				    	 
				    	 RentalVO deleteR = controller.getRBDelete(book.getBisbn());
				    	 
				    	 System.out.println("|책 번호 :  "+book.getBisbn()+"| |책 제목 :  "+book.getBtitle()+
							"| |책 페이지수 :  "+book.getBpage()+"| |출판사 :  " +book.getBpublisher()+"| "+"\n 해당도서가 삭제되었습니다");
						
					 }
					updateBtn.setDisable(true);
					deleteBtn.setDisable(true);
				}
			});
			return row;
		});
	
		

		root.setCenter(tableView);
		root.setBottom(flowpane);

		return root;

	}
	

}
