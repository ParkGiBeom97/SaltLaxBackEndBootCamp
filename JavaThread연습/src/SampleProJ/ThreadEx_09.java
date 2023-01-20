package SampleProJ;

class Thread_09_1 implements Runnable{
	
	
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	
	Thread t;
	
	void setThread(Thread t) {
		this.t = t;
	}
	
	
	
	@Override
	public void run() {
		
		while(!stopped) {
			
			if(!suspended) {
				
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
		
				}
				
			}else {
				Thread.yield();
			}
			
		}
		
	}
	
	public void suspend() {
		suspended = true;
		//현재 쓰레드에 interupt를 걸면 sleep 상태에서 깨어짐
		t.interrupt();
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped = true;
		t.interrupt();
	}
	
}



public class ThreadEx_09 {
	
	public static void main(String[] args) {
		
		Thread_09_1 r1 = new Thread_09_1();
		Thread_09_1 r2 = new Thread_09_1();
		Thread_09_1 r3 = new Thread_09_1();
		
		Thread t1 = new Thread(r1,"*");
		Thread t2 = new Thread(r2,"**");
		Thread t3 = new Thread(r3,"***");
		
		r1.setThread(t1);
		r2.setThread(t2);
		r3.setThread(t3);

		
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
		}
		
		System.out.println("메인 메소드 종료!!");
		
		
	}
	
}
