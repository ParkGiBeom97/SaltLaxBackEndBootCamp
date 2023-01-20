package JavaFxExam;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxExample extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//화면 구성하는 작업을 여기에서 진행(창 사이즈, 요소 배치 우치 등등)
		Button btn = new Button();
		btn.setText("안녕!!");
		
		//버튼에 이벤트 처리하기
		//자바는 delegation model을 이용함
		//웹 자바 스크립트에서도 사용함
		//버튼에 Action이라는 Event를 처리할 수 있는 Listener객체를 붙입니다.
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				//이벤트가 발생되면 자동으로 호출
				System.out.println("안녕하세요~");
				
			}
		});
		
		//레이아웃 만들기
		//컴포넌트가 붙는 방식을 결정하는 객체
		//StackPane은 레이아웃중 추가되는 순서대로 덧붙여서 시각화하는 레이아웃
		StackPane root = new StackPane();
		
		root.getChildren().add(btn);
		
		//한 화면을 지칭하는 객체 scene(가로 세로 길이를 정해줌)
		Scene scene = new Scene(root, 300, 150);
		
		
		
		primaryStage.setTitle("연습입니다");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch();//GUI쓰레드를 시작함
		
	}
	
}
