package SampleProJ;

class ThreadEx_02_1 extends Thread{
	
	public ThreadEx_02_1() {

	}
	
	public ThreadEx_02_1(String name) {
		super();
		this.setName(name);//쓰레드 이름을 설정하는 메소드
		
	}
	
	
	
	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println(this.getName());
		}
	}
}

public class ThreadEx_02 {
	public static void main(String[] args) {
		Thread t1 = new ThreadEx_02_1("My-Thread");
		t1.run();//쓰레드의 인스턴스지만 동기식임 그리고 쓰레드가 아님
		System.out.println("메인종료");
		
	}
}
