package bookproject.view;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import bookproject.controller.BookRentMinusController;
import bookproject.controller.BookSearchController;
import bookproject.controller.RentalController;
import bookproject.controller.RentalLogController;
import bookproject.vo.BookVO;
import bookproject.vo.LogVO;
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
	TableView<List> tableViewMB;
	TextField textField;
	TextField textField1;
	TextField textField2;
	Button deleteBtn;
	Button myBtn;
	Button homeBtn;
	Button rentalBtn;
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

			// ObservableList<BookVO> list = controller.getResult(textField.getText());
			// tableView.setItems(list);

			ObservableList<BookVO> listMB = controller.getResultMB(textField.getText());
			tableView.setItems(listMB);

			textField.clear();

		});

		myBtn = new Button("내정보");
		myBtn.setPrefSize(150, 40);
		// 내정보 버튼을 누름
		myBtn.setOnAction(e -> {

			MyInfoView info = new MyInfoView(primaryStage, scene, root);
			scene.setRoot(info.getInfo(idID));
			primaryStage.setScene(scene);
			primaryStage.setTitle("내 정보창");

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

		rentalBtn = new Button("대여 현황 보러가기");
		rentalBtn.setPrefSize(150, 40);
		rentalBtn.setOnAction(e -> {
			EveryRentalBookView every = new EveryRentalBookView(primaryStage, scene, root);
			scene.setRoot(every.getRentBook(idID));
			primaryStage.setScene(scene);
			primaryStage.setTitle("도서 대출 현황");
		});

		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(myBtn);
		flowpane.getChildren().add(rentalBtn);
		flowpane.getChildren().add(homeBtn);
		flowpane.setHgap(20);

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

				// 더블클릭했을 때의 이벤트 처리
				if (e1.getClickCount() == 2) {
					Dialog<ButtonType> dialog = new Dialog<>();

					dialog.setTitle("책 상세 정보");
					System.out.println("두번클릭 상세정보 띄우기");

					ButtonType type = new ButtonType("OK", ButtonData.OK_DONE);
					ButtonType rentalBtn = new ButtonType("대여", ButtonData.OK_DONE);

					dialog.setContentText("|책 번호 :  " + book.getBisbn() + "| |책 제목 :  " + book.getBtitle()
							+ "| |책 페이지수 :  " + book.getBpage() + "| |출판사 :  " + book.getBpublisher() + "| "
							+ "\n 해당 도서를 대여하시겠습니까??");

					dialog.getDialogPane().setMinSize(700, 200);
					dialog.getDialogPane().getButtonTypes().addAll(rentalBtn, type);

					Optional<ButtonType> result = dialog.showAndWait();

					if (result.get().getText().equals("대여")) {
						System.out.println("대여 버튼 누름");

						RentalController controller = new RentalController();
						ObservableList<RentalVO> list = controller.getRental(book.getBisbn(), book.getBtitle(), idID);
						//마이바티스로 책 구현
						
						
						BookRentMinusController controllerM = new BookRentMinusController();
						ObservableList<BookVO> listM = controllerM.getMinus(book.getBisbn());
						//마이바티스로 책 구현 했을 경우 책 갯수 마이너스

						Date now = new Date();
						RentalLogController controllerR = new RentalLogController();
						//마이바티스로 

						LogVO log = controllerR.insetRLog(book.getBisbn(), idID, book.getBtitle(), now);
						//마이바티스로 로그 찍어주기

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
