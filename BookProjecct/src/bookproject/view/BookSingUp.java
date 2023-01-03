package bookproject.view;

import bookproject.controller.BookSearchController;
import bookproject.vo.BookVO;
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

public class BookSingUp {

	private BorderPane logIn = null;
	private Stage primaryStage = null;
	private Scene scene = null;

	public BookSingUp() {
		// TODO Auto-generated constructor stub
	}

	public BookSingUp(Stage primaryStage, Scene scene, BorderPane root) {
		super();
		this.primaryStage = primaryStage;
		this.scene = scene;
		this.logIn = root;
	}

	TableView<BookVO> tableView;
	TextField textField;
	TextField textField1;
	TextField textField2;
	Button deleteBtn;
	Button myBtn;
	Button homeBtn;

	String deleteISBN;
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
		textField.setPrefSize(250, 40);

		// 검색창에 엔터를 눌렀을때 이벤트 처리
		textField.setOnAction(e -> {
			BookSearchController controller = new BookSearchController();

			ObservableList<BookVO> list = controller.getResult(textField.getText());

			tableView.setItems(list);

			searchKeyword = textField.getText();
			textField.clear();
		});

		// 삭제버튼
		deleteBtn = new Button("선택된 책 삭제");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true);

		deleteBtn.setOnAction(e -> {
		});

		myBtn = new Button("내정보");
		myBtn.setPrefSize(150, 40);
		myBtn.setOnAction(e -> {
			Dialog<String> dialog = new Dialog<String>();
			dialog = new Dialog<String>();
			dialog.setTitle("내 정보 확인");
			System.out.println("내 정보 출력");
			ButtonType type = new ButtonType("OK", ButtonData.OK_DONE);
			dialog.setContentText("내 아이디 : " + idID);

			System.out.println();

			dialog.getDialogPane().setMinSize(700, 200);
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.show();

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

		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(deleteBtn);
		flowpane.getChildren().add(myBtn);
		flowpane.getChildren().add(homeBtn);

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
				deleteBtn.setDisable(false);
				BookVO book = row.getItem();
				deleteISBN = book.getBisbn();

				// 더블클릭했을 때의 이벤트 처리
				if (e1.getClickCount() == 2) {
					Dialog<String> dialog = new Dialog<String>();

					dialog.setTitle("책 상세 정보");
					System.out.println("두번클릭 상세정보 띄우기");

					ButtonType type = new ButtonType("OK", ButtonData.OK_DONE);
					dialog.setContentText("왜 눌림?");

					dialog.getDialogPane().setMinSize(700, 200);
					dialog.getDialogPane().getButtonTypes().add(type);
					dialog.show();
					
					
				}
			});
			return row;
		});

		root.setCenter(tableView);
		root.setBottom(flowpane);

//		Scene scene1 = new Scene(root);
//		
//		primaryStage.setScene(scene1);
//		primaryStage.setTitle("도서 프로그램 메인페이지");
//						
//			primaryStage.setOnCloseRequest(e -> {
//				//창을 완전히 껏을 때 발생하는 이벤트
//				System.out.println("도서 프로그램을 완전히 종료합니다.");
//			});

		return root;

	}

}
