package SampleProJ;

import javax.swing.JOptionPane;





class ThreadEx_06_1_part1 extends Thread{
	
	public ThreadEx_06_1_part1() {

	}
	
	@Override
	public void run() {
		
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {//this.이 생략됨 thread가 생략됨
			System.out.println(i--);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				interrupt();
			}
			
		
		}
		System.out.println("카운트가 종료되었습니다.");
	}
	
}

public class ThreadEx_06_part1 {
	public static void main(String[] args) {
		
		Thread t = new ThreadEx_06_1_part1();//쓰레드 instance 생성
		
		t.start();//쓰레드를 runable형태로 전환
		//쓰레드 스케줄의 선택을 받으면 실행가능
		
		String data = JOptionPane.showInputDialog("값을 입력하세요~");
		
		System.out.println(data);
		
		t.interrupt();//쓰레드를 방해했지만 쓰레드가 중지나 일시정지가 되지는 않음
		//로직으로 쓰레드의 행동을 제어하면 됨
		//interup이 발생하면 isinterupted가 true값을 반환함
		//t.suspend();//warring이 나옴 쓰는거 아님
		//만약 interupt를 걸었는데 해당 쓰레드가 sleep상태이면 깨면서 interupt 상태를 초기화함
		
		
	}
}
