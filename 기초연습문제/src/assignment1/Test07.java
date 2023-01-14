package assignment1;

class Tv{
	
	public Tv() {
		// TODO Auto-generated constructor stub
	}
	
	
	String name;
	int price;
	String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Tv(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return name + "  " + price + "   " + description ;
	}
	
	
	
	
}

public class Test07 {
	
	public static void main(String[] args) {
		
		Tv tvArray[] = new Tv[3];
		int sum = 0;
		
		tvArray[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvArray[1]= new Tv("XCANVAS", 1000000, "LCD TV");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D TV");
		
		for(int i = 0; i<tvArray.length;i++) {
			System.out.println(tvArray[i].toString());
		}
		
		for(int i= 0; i< 3; i++) {
			sum += tvArray[i].getPrice();
		}
		
		System.out.println("가격의 합 : "+sum);
		
		
		
	}

}
