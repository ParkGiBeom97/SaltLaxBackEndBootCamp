package SampleProJ;


//공용객체
class Aaa {
	
	public Aaa() {

	}
	
	
	
	public synchronized void hell() {
		
		System.out.println(Thread.currentThread().getName());
		
		notify();
		
		try {
			Thread.sleep(1000);
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class ThreadEx_13_1 implements Runnable{
	
	Aaa a = new Aaa();
	
	
	@Override
	public void run() {
		

		for(int i = 0; i<5; i++) {
			a.hell();
		}
	}
}


public class ThreadEx13 {
	
	public static void main(String[] args) {
		
		ThreadEx_13_1 r = new ThreadEx_13_1();
		
		Thread t1 = new Thread(r,"*");
		Thread t2 = new Thread(r,"**");
		
		
		t1.start();
		t2.start();
		

		
		
	}
	

}
