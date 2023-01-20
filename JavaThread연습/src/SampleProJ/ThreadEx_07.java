package SampleProJ;

class ThreadEx_07_1 implements Runnable{
	
	public ThreadEx_07_1() {
		
	}

	
	@Override
	public void run() {
		
		while(true) {
			System.out.println(Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class ThreadEx_07 {
	
	public static void main(String[] args) {
		
		Runnable r1 = new ThreadEx_07_1();
		Thread t1 = new Thread(r1,"*");
		Thread t2 = new Thread(r1,"**");
		Thread t3 = new Thread(r1,"***");
		
		
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			t1.suspend();
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(2000);
			t1.resume();
			Thread.sleep(2000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
			
		} catch (Exception e) {
			
		}
		
	}

}
