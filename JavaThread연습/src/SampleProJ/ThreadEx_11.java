package SampleProJ;


//아래 쓰레드이 인스턴스를 생성하여 실행하면 10초마다 일정량의 메모리 사용량을 감소함
class ThreadEx_11_1 extends Thread{
	
	final static int MAX_MEMORY = 1000;
	//상수 필드는 관용적으로 대문자를 이용함.
	
	int usedMemory = 0;
	
	@Override
	public void run() {
		
		while(true){
			try {
				Thread.sleep(10000);
			
			} catch (InterruptedException e) {

			
			}
			
			gc(); //메모리 청소하는 메소드
			System.out.println("t가 일어니서 수행하고 남은 메모리량~ : "+freeMemory());
		}

	}
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) {
			usedMemory = 0;
		}
	}
	
	//전체 메모리량 보여줌
	public int totalMemory() {
		return MAX_MEMORY;
	}
	//현재 가용한 메모리량 보여줌
	public int freeMemory() {
		return MAX_MEMORY- usedMemory;
	}
	
}


public class ThreadEx_11 {

	public static void main(String[] args) {
		
		ThreadEx_11_1 t = new ThreadEx_11_1(); //상위타입으로 클레스를 잡으면 클레스 안의 메소드나 필드를 사용못함!(한번더 정리 요망)
		t.setDaemon(true); //메인쓰레드 종료시 t쓰레드도 종료
		t.start();
		
		int requiredMemory = 0;
		
		for(int i =0; i<20; i++) {
			requiredMemory = ((int)(Math.random()*10))*20;
			
			//requriedMemory양이 사용할 수 있는 메모리양보다 크면 못사용하게 하기
			//전체 메모리의 60%이상을 사용했을떼 gc()사용하기
			if((t.freeMemory() < requiredMemory) || t.freeMemory() < t.totalMemory()* 0.4) {
				
				//잠들어있느느 t를 깨우기 위한 interupt 발생
				t.interrupt();
				
				//join을 사용해주어 메인쓰레드를 멈추고 일어난 t가 실행될 때까지 대기
				try {
					t.join(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			t.usedMemory += requiredMemory;
			System.out.println("남은 메모리량 : "+t.freeMemory());
			
			
		}
		
		
		
	}
	
	
}









