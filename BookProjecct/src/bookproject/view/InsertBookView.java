package bookproject.view;

import bookproject.controller.AddBookController;
import bookproject.controller.JoinController;
import bookproject.vo.BookVO;
import bookproject.vo.UserVO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertBookView {
	   private BorderPane logIn=null;
	   private Stage primaryStage=null;
	   private Scene scene=null;
	   
	   public InsertBookView() {
	      // TODO Auto-generated constructor stub
	   }
	   
	   public InsertBookView(Stage primaryStage,Scene scene,BorderPane root) {
	      this.primaryStage=primaryStage;
	      this.scene = scene;
	      this.logIn=root;
	   }


	   private Text bsid;
	   private Text btitle;
	   private Text bdate;
	   private Text bpage;
	   private Text bprice;
	   private Text bauthor;
	   private Text btranslator;
	   private Text bsupplementl;
	   private Text bpublisher;
	   private Text BookRental;
	   
	   private TextField bsidtf;
	   private TextField btitletf;
	   private TextField bdatetf;
	   private TextField bpagetf;
	   private TextField bpricetf;
	   private TextField bauthortf;
	   private TextField btranslatortf;
	   private TextField bsupplementltf;
	   private TextField bpublishertf;
	   private TextField BookRentaltf;
	   
	   
	   private Button addBookBtn;
	   private Button mainModBtn;
	   
	   public BorderPane insertBook(String idID, String searchKeyword)
	   {
	      BorderPane root = new BorderPane();
	      root.setPrefSize(1000, 1500);
	      
	      bsid = new Text("책 번호 입력");
	      bsid.setWrappingWidth(150);
	      bsidtf = new TextField();
	      bsidtf.setPrefSize(200, 40);
	      
	      btitle = new Text("책 제목 입력");
	      btitle.setWrappingWidth(150);
	      btitletf = new TextField();
	      btitletf.setPrefSize(200, 40);
	      
	      bdate = new Text("책 발행일 입력");
	      bdate.setWrappingWidth(150);
	      bdatetf = new TextField();
	      bdatetf.setPrefSize(200, 40);
	      
	      bpage = new Text("책 페이지 입력");
	      bpage.setWrappingWidth(150);
	      bpagetf = new TextField();
	      bpagetf.setPrefSize(200, 40);
	      
	      bprice = new Text("책 가격 입력");
	      bprice.setWrappingWidth(150);
	      bpricetf = new TextField();
	      bpricetf.setPrefSize(200, 40);
	      
	      bauthor = new Text("책 작가 입력");
	      bauthor.setWrappingWidth(150);
	      bauthortf = new TextField();
	      bauthortf.setPrefSize(200, 40);
	      
	      btranslator = new Text("책 번역가 입력");
	      btranslator.setWrappingWidth(150);
	      btranslatortf = new TextField();
	      btranslatortf.setPrefSize(200, 40);
	      
	      bsupplementl = new Text("책 추가지원 입력");
	      bsupplementl.setWrappingWidth(150);
	      bsupplementltf = new TextField();
	      bsupplementltf.setPrefSize(200, 40);
	      
	      bpublisher = new Text("책 출판사 입력");
	      bpublisher.setWrappingWidth(150);
	      bpublishertf = new TextField();
	      bpublishertf.setPrefSize(200, 40);
	      
	      BookRental = new Text("책 입고 갯수 입력");
	      BookRental.setWrappingWidth(150);
	      BookRentaltf = new TextField();
	      BookRentaltf.setPrefSize(200, 40);

	      
	      FlowPane bsidfp = new FlowPane();
	      bsidfp.setAlignment(Pos.CENTER);
	      bsidfp.setColumnHalignment(HPos.CENTER);
	      bsidfp.setPrefSize(700, 60);
	      bsidfp.setHgap(10);
	      bsidfp.getChildren().add(bsid);
	      bsidfp.getChildren().add(bsidtf);
	      
	      FlowPane btitlefp = new FlowPane();
	      btitlefp.setAlignment(Pos.CENTER);
	      btitlefp.setColumnHalignment(HPos.CENTER);
	      btitlefp.setPrefSize(700, 60);
	      btitlefp.setHgap(10);
	      btitlefp.getChildren().add(btitle);
	      btitlefp.getChildren().add(btitletf);
	      
	      FlowPane bdatefp = new FlowPane();
	      bdatefp.setAlignment(Pos.CENTER);
	      bdatefp.setColumnHalignment(HPos.CENTER);
	      bdatefp.setPrefSize(700, 60);
	      bdatefp.setHgap(10);
	      bdatefp.getChildren().add(bdate);
	      bdatefp.getChildren().add(bdatetf);

	      FlowPane bpagefp = new FlowPane();
	      bpagefp.setAlignment(Pos.CENTER);
	      bpagefp.setColumnHalignment(HPos.CENTER);
	      bpagefp.setPrefSize(700, 60);
	      bpagefp.setHgap(10);
	      bpagefp.getChildren().add(bpage);
	      bpagefp.getChildren().add(bpagetf);
	      
	      FlowPane bpricefp = new FlowPane();
	      bpricefp.setAlignment(Pos.CENTER);
	      bpricefp.setColumnHalignment(HPos.CENTER);
	      bpricefp.setPrefSize(700, 60);
	      bpricefp.setHgap(10);
	      bpricefp.getChildren().add(bprice);
	      bpricefp.getChildren().add(bpricetf);
	      
	      FlowPane bauthorfp = new FlowPane();
	      bauthorfp.setAlignment(Pos.CENTER);
	      bauthorfp.setColumnHalignment(HPos.CENTER);
	      bauthorfp.setPrefSize(700, 60);
	      bauthorfp.setHgap(10);
	      bauthorfp.getChildren().add(bauthor);
	      bauthorfp.getChildren().add(bauthortf);
	      
	      FlowPane btranslatorfp = new FlowPane();
	      btranslatorfp.setAlignment(Pos.CENTER);
	      btranslatorfp.setColumnHalignment(HPos.CENTER);
	      btranslatorfp.setPrefSize(700, 60);
	      btranslatorfp.setHgap(10);
	      btranslatorfp.getChildren().add(btranslator);
	      btranslatorfp.getChildren().add(btranslatortf);
	      
	      FlowPane bsupplementfp = new FlowPane();
	      bsupplementfp.setAlignment(Pos.CENTER);
	      bsupplementfp.setColumnHalignment(HPos.CENTER);
	      bsupplementfp.setPrefSize(700, 60);
	      bsupplementfp.setHgap(10);
	      bsupplementfp.getChildren().add(bsupplementl);
	      bsupplementfp.getChildren().add(bsupplementltf);
	      
	      FlowPane bpublisherfp = new FlowPane();
	      bpublisherfp.setAlignment(Pos.CENTER);
	      bpublisherfp.setColumnHalignment(HPos.CENTER);
	      bpublisherfp.setPrefSize(700, 60);
	      bpublisherfp.setHgap(10);
	      bpublisherfp.getChildren().add(bpublisher);
	      bpublisherfp.getChildren().add(bpublishertf);
	      
	      FlowPane BookRentalfp = new FlowPane();
	      BookRentalfp.setAlignment(Pos.CENTER);
	      BookRentalfp.setColumnHalignment(HPos.CENTER);
	      BookRentalfp.setPrefSize(700, 60);
	      BookRentalfp.setHgap(10);
	      BookRentalfp.getChildren().add(BookRental);
	      BookRentalfp.getChildren().add(BookRentaltf);
	      
	      
	      //책 추가하기
	      addBookBtn = new Button("추가하기");
	      addBookBtn.setPrefSize(150, 70);
	      addBookBtn.setOnAction(e -> {
	    	  
	    	 System.out.println("책을 삽입합니다~");
	         
	    	 AddBookController controller = new AddBookController();
	    	 ObservableList<BookVO> list = controller.addBookController(bsidtf.getText()
	    			 , btitletf.getText(), bdatetf.getText(), Integer.parseInt(bpagetf.getText()),
	    			 Integer.parseInt(bpricetf.getText()), bauthortf.getText(), btranslatortf.getText(),
	    			 bsupplementltf.getText(), bpublishertf.getText(), Integer.parseInt(BookRentaltf.getText())
	    			 );
	    	 
	    	 //마이바티스로 책 삽입하기
	    	 ObservableList<BookVO> listMB = controller.addBookControllerMB(bsidtf.getText()
	    			 , btitletf.getText(), bdatetf.getText(), Integer.parseInt(bpagetf.getText()),
	    			 Integer.parseInt(bpricetf.getText()), bauthortf.getText(), btranslatortf.getText(),
	    			 bsupplementltf.getText(), bpublishertf.getText(), Integer.parseInt(BookRentaltf.getText())
	    			 );
	    	 
			System.out.println("관리자모드로 실행합니다");
			adminView adminmode = new adminView(primaryStage, scene, root);
			scene.setRoot(adminmode.getLogin(idID));
			primaryStage.setTitle("관리자모드 실행중...");
	    	  
	      });
	      
	      mainModBtn = new Button("관리자 메인으로");
	      mainModBtn.setPrefSize(150, 70);
	      mainModBtn.setOnAction(e -> {
				System.out.println("관리자모드로 실행합니다");
				adminView adminmode = new adminView(primaryStage, scene, root);
				scene.setRoot(adminmode.getLogin(idID));
				primaryStage.setTitle("관리자모드 실행중...");
	      });

	      FlowPane bottomflowpane = new FlowPane();
	      bottomflowpane.setAlignment(Pos.CENTER);
	      bottomflowpane.setColumnHalignment(HPos.CENTER);
	      bottomflowpane.setPrefSize(700, 100);
	      bottomflowpane.setHgap(200);
	      bottomflowpane.getChildren().add(addBookBtn);
	      bottomflowpane.getChildren().add(mainModBtn);
	      
//	      FlowPane flowpane = new FlowPane();
//	      flowpane.setAlignment(Pos.CENTER);
//	      flowpane.setColumnHalignment(HPos.CENTER);
//	      flowpane.setPrefSize(800, 1000);
//	      flowpane.setVgap(10);
//	      flowpane.setOrientation(Orientation.VERTICAL);
//	      flowpane.getChildren().add(bsidfp);
//	      flowpane.getChildren().add(btitlefp);
//	      flowpane.getChildren().add(bpagefp);
//	      //flowpane.getChildren().add(bpagefp);
//	      flowpane.getChildren().add(bpricefp);
//	      flowpane.getChildren().add(bauthorfp);
//	      flowpane.getChildren().add(btranslatorfp);
//	      flowpane.getChildren().add(bsupplementfp);
//	      flowpane.getChildren().add(bpublisherfp);
//	      flowpane.getChildren().add(BookRentalfp);
	      
	      VBox vBox = new VBox();
	      vBox.setAlignment(Pos.CENTER);
//	      vBox.setColumnHalignment(HPos.CENTER);
//	      vBox.setPrefSize(800, 1000);
//	      vBox.setVgap(10);
//	      vBox.setOrientation(Orientation.VERTICAL);
	      vBox.getChildren().add(bsidfp);
	      vBox.getChildren().add(btitlefp);
	      vBox.getChildren().add(bdatefp);
	      vBox.getChildren().add(bpagefp);
	      vBox.getChildren().add(bpricefp);
	      vBox.getChildren().add(bauthorfp);
	      vBox.getChildren().add(btranslatorfp);
	      vBox.getChildren().add(bsupplementfp);
	      vBox.getChildren().add(bpublisherfp);
	      vBox.getChildren().add(BookRentalfp);
	      
	      
	      
	      root.setCenter(vBox);
//	      root.setCenter(flowpane);
	      root.setBottom(bottomflowpane);
	      
	      return root;
	   }
}
