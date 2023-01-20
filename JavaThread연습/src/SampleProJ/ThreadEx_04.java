package SampleProJ;





public class ThreadEx_04 implements Runnable{
	

	//field
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new ThreadEx_04());
		t.setDaemon(true);
		
		t.start();
		
		for(int i = 0; i < 20; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i == 5) {
				autoSave = true;
			}
		}
		
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				//쓰레드를 일정시간동안 재움
				Thread.sleep(3000);//객체 생성없이 클레스로 바로 호출하면 static
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(autoSave) {
				System.out.println("자동저장됨");
			}
		}
		
	}
	
	
}
