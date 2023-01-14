package dailyWorkshop07;

class Point {
	int x;
	int y;
	
	public Point() {
		
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}

abstract class Shape{
	Point point;
	
	
	public Shape(Point point) {
		super();
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public abstract double getArea();
	
	public abstract double getCircumeference();


	
	

}

interface Movable{
	public void move(int x, int y);
}

class Circle extends Shape implements Movable{
	
	int radius;

	public Circle(int x, int y, int radius) {
		super(new Point(x, y));
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * Math.PI;
	}

	@Override
	public double getCircumeference() {
		// TODO Auto-generated method stub
		return 2 * radius * Math.PI;
	}

	@Override
	public String toString() {
		return "x좌표 : " + getPoint().getX() + "   y좌표 : " + getPoint().getY()+"   넓이 : " + getCircumeference();
	}

	@Override
	public void move(int x, int y) {
		point.setX(point.getX() + x + 1);
		point.setY(point.getY() + y + 1);
		
	}

	
	
	
}

class Rectangle extends Shape implements Movable{
	
	int width;
	


	 public Rectangle(int x, int y, int width) { 
		super(new Point(x, y));
	 	this.width = width; 
	 }
	 



	@Override
	public double getArea() {
		
		return width * width;
	}

	@Override
	public double getCircumeference() {
		
		return (width+width)*2;
	}

	@Override
	public String toString() {
		return "x좌표 : " + getPoint().getX() + "   y좌표 : " + getPoint().getY()+"   넓이 : " + getCircumeference();
	}

	@Override
	public void move(int x, int y) {
		point.setX(point.getX() + x + 1);
		point.setY(point.getY() + y + 1);
		
	}
	
	
	
	
	
}

public class Test01 {
	public static void main(String[] args) {
		Shape shape[] = new Shape[4];
		Point point = new Point();
		
		shape[0]=new Rectangle(7, 5, 4);
		shape[1] = new Rectangle(4, 6, 5);
		shape[2] = new Circle(6, 7, 6);
		shape[3] = new Circle(8, 3, 7);
		
		for(int i =0; i<shape.length; i++) {
			System.out.println(shape[i].toString());
		}
		
		for(int i =0; i<shape.length; i++) {
			((Movable)(shape[i])).move(10, 10);
		}
		
		
		System.out.println("==============좌표 이동 후===================");
		for(int i =0; i<shape.length; i++) {
			System.out.println(shape[i].toString());
		}
		
		
	}
}












