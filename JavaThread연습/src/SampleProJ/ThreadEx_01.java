package SampleProJ;




//아래 클레스는 당연히 쓰레드가 아닙니다.
//Runable이라는 큭별한 인터페이스를 구현한 클레스입니다.
//쓰레드의 getName메소드를 이용하려면 현재 쓰레드를 찾아야합니다.
//Thread.currentThread()를 사용해줍니다.
//currentThread()는 현재 메서드의 쓰레드를 찾아줍니다
class ThreadEx_01_02 implements Runnable{
	
	public void run(){
		for(int i = 0; i<=5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
}




//아래 클레스는 당연히 Thread입니다.
//is-a 관계로 인해...
class ThreadEx_01_1 extends Thread {
	
	
	
	public ThreadEx_01_1() {
	}
	
	//새로운 독립적인 실행 흐름
	//프로그램의 entry point에 준하는 무언가 시작 method가 있다.
	
	@Override
	public void run() {//쓰레드의 엔트리 포인트
		//내가 실행하고 싶은 코드 작성
		for(int i = 0; i<=5; i++) {
			System.out.println(getName());
		}
		
		
	}
}

/*
예전설명
JVM이 메인 메소드를 호출해서 프로그램을 시작합니다.

이제는 쓰레드를 배웠으니..
자바 프로그램이 실행되면 JVM이 내부적으로 쓰레드를 생성합니다.
이 쓰레드가 main이라는 메소드를 호출해서 실행합니다.
이 쓰레드를 메인 쓰레드라고 말합니다.
-----------------
프로그램(process)의 종료는 main method가 시작하면 시작되는거고
main method가 종료되면 전체 프로그램이 종료된다는 설명은 틀린것
------------------
정확하게는 process안에 있는 모든 Thread가 종료되어야지
프로세스가 종료된다는 설명이 옳은 설명이다.

*/
public class ThreadEx_01{
	//
	public static void main(String[] args) {
		//이 메인 메소드는 당연히 하나의 쓰레드에 의해서 실행되는 메소드입니다~
		
		ThreadEx_01_1 t1 = new ThreadEx_01_1();
		//t1객체를 만들었음.
		//이제 실행시키는 방법
		//t1.run();
		//위와 같은 호출방법은 단순히 객체의 메소드를 호출한 것뿐
		//실행시킨 것은 아닙니다.
		//대부분의 메소드는 blocking 메소드입니다.(메소드 수행이 끝나고 return될 때까지 대기하는 것)
		//run을 직접적으로 호출하는 것은 쓰레드가 아니라 그냥 단순히 메소드 호출 후 진행하는 것입니다.
		
		//실행방법은 아래처럼 다른 메소드를 이용해야합니다.
		t1.start();
		//start()메소드를 이용합니다.
		//start메소드를 통해 내부의 run메소드를 찾아갑니다.
		
		//start는 non-Blocking 메소드입니다.
		//쓰레드 스케줄을 통해 진행이 됨
		System.out.println("메인종료!");
		
		
		
		
		//아래의 방식은 인터페이스를 통해 쓰레드를 만들어주는겁니다.
		Runnable r2 = new ThreadEx_01_02(); //쓰레드가 아님
		Thread t2 = new Thread(r2);//Thread가 됩니다.
		
		
		t2.start();
		
	}
}
