package SampleProJ;

class Thread_08_1 implements Runnable{
	
	
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	
	
	@Override
	public void run() {
		
		while(!stopped) {
			
			if(!suspended) {
				
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
	
	public void suspend() {
		suspended = true;
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped = true;
	}
	
}

public class ThreadEx_08 {
	
	public static void main(String[] args) {
		
		Thread_08_1 r1 = new Thread_08_1();
		Thread_08_1 r2 = new Thread_08_1();
		Thread_08_1 r3 = new Thread_08_1();
		
		Thread t1 = new Thread(r1,"*");
		Thread t2 = new Thread(r2,"**");
		Thread t3 = new Thread(r3,"***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(3000);
			r1.suspend();
			Thread.sleep(3000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(3000);
			r3.stop();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 메소드 종료!!");
		
		
	}
	
}
