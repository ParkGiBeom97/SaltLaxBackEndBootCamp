package dailyWorkshop06;
//문제 중복 있어서 3,4번 문제 건너뛰고 5번을 품
//클레스명은 그냥 03부터 시작

import java.util.*;


abstract class Shape{
	
	public Shape() {
		// TODO Auto-generated constructor stub
	}
	
	int width;
	int height;
	String colors;

	public Shape(int width, int height, String colors) {
		super();
		this.width = width;
		this.height = height;
		this.colors = colors;
	}
	
	
	public abstract double getArea();
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	
	@Override
	public String toString() {
		return width + "    " + getArea()+"    " + colors;
	}
	
}

interface Resize{
	public void setResize(int size);
}

class Triangle extends Shape implements Resize{
	

	public Triangle() {
		super();
	}

	public Triangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}
	
	/*
	public double getArea() {
		return width*height*0.5;
	}
	*/
	
	

	@Override
	public double getArea() {
		return (width*height)/2.0;
	}

	@Override
	public void setResize(int size) {
		setHeight(getHeight()+size);
		
	}
}

class Rectangle extends Shape implements Resize{
	

	public Rectangle() {
		super();
	}

	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}
	

	public double getArea() {
		return width*height;
	}
	

	public void setResize(int size) {
		setWidth(getWidth()+size);
	}

}



public class Test03 {
	public static void main(String[] args) {
		Shape shape[] = new Shape[6];
		
		shape[0] = new Triangle(7, 5, "Blue");
		shape[1] = new Rectangle(4,6,"Blue");
		shape[2] = new Triangle(6,7,"Red");
		shape[3] = new Rectangle(8,3,"Red");
		shape[4] = new Triangle(9,8,"white");
		shape[5] = new Rectangle(5,7,"white");
		
		
		System.out.println("====기본 정보====");
		for(int i = 0; i< shape.length; i++) {
			System.out.println(shape[i].toString());
		}
		
		//사이즈 변경할 예정
		for(int i = 0; i< shape.length; i++) {
			((Resize)(shape[i])).setResize(5);
		}
		
		System.out.println("====사이즈 변경 후 정보====");
		for(int i = 0; i< shape.length; i++) {
			System.out.println(shape[i].toString());
		}
	}

}
