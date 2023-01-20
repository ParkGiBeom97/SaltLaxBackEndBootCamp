package SampleProJ;

class ThreadEx_03_1 extends Thread{
	
	public ThreadEx_03_1() {
		// TODO Auto-generated constructor stub
	}
	
	public ThreadEx_03_1(String name) {
		super(name);
	}	
	
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName());
		}
	}
}

public class ThreadEx_03 {
	public static void main(String[] args) {
		
		Thread t1 = new ThreadEx_03_1("Thread-01");
		Thread t2 = new ThreadEx_03_1("Thread-02");
		
		
		//실행시키기전에 우선 순위 매기기
		//우선순위의 범위는 1-10까지임
		t1.setPriority(1);
		t2.setPriority(10);
		//싱글코어일때만 영향이 있음
		
		t1.start();
		t2.start();
		
	}
}





