package SampleProJ;

class ThreadEx_10_1 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.print("-");
		}
	}
}

class ThreadEx_10_2 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.print("|");
		}
	}
}

public class ThreadEx_10 {

	public static void main(String[] args) {
		
		long starttime = 0;
		
		Thread t1 = new ThreadEx_10_1();
		Thread t2 = new ThreadEx_10_2();
		
		t1.start();
		t2.start();
		
		starttime = System.currentTimeMillis();//숫자로 현재시간을 표현
		
		try {
			t1.join();//현제 실행되고 있는 쓰레드 즉, main쓰레드에 t1이 조인되어 들어오는 것
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+"소요시간(밀리초) : "+(System.currentTimeMillis() - starttime));

	}
	
}
