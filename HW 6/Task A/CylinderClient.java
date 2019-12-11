public class CylinderClient{
	public static void main(String[] args){
		
		Circle circle1 = new Circle(5);
		System.out.println("Circle 1: " + circle1 + "\n");
		
		Cylinder cylinder1 = new Cylinder(4, 3);
		System.out.println("Cylinder 1: " + cylinder1 + "\n");
		
		Cylinder cylinder2 = new Cylinder(circle1, 4);
		System.out.println("Cylinder 2: " + cylinder2 + "\n");
		
		circle1.setRadius(2);
		System.out.println("Changed radius of circle1 to 2: " + circle1 + "\n");
		
		System.out.println("Calling all circle methods on cylinder1");
		System.out.println("Radius: " + cylinder1.getRadius());
		System.out.println("Area: " + cylinder1.area());
		System.out.println("Circumference: " + cylinder1.circumference());
	}
}