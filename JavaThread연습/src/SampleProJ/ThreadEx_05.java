package SampleProJ;



class ThreadEx_05_1 extends Thread{
	@Override
	public void run() {
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("아~ 망했어요~");
		}
		
		for(int i = 0; i<300; i++) {
			System.out.print("-");
		}
		System.out.println("\n<< 쓰레드 1 종료 >>");
	}
}

class ThreadEx_05_2 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i<300; i++) {
			System.out.print("|");
		}
		System.out.println("\n<< 쓰레드 2 종료 >>");
	}		
		
}


public class ThreadEx_05 {
	
	public static void main(String[] args) {
		
		Thread t1 = new ThreadEx_05_1();
		Thread t2 = new ThreadEx_05_2();
		
		t1.start();
		t2.start();
		
		/**
		try {
			t1.sleep(5000);//t1을 재우는 것이 아니라 진행 중인 쓰레드인 main 쓰레드를 재운다
			//Thread.sleep()이 맞는 표현방법이다.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/

		System.out.println("메인쓰레드 종료");
		
	}
}
