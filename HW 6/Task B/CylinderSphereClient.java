public class CylinderSphereClient{
	public static void main(String[] args){
		Cylinder cylinder1 = new Cylinder(28,35);
		System.out.println("cylinder1: " + cylinder1 + "\n");
		
		Sphere sphere1 = new Sphere(6);
		System.out.println("sphere1: " + sphere1 + "\n");
		
		System.out.println("Number of spheres in the cylinder: " + cylinder1.volume() / sphere1.volume() + "\n");
		
		Circle circle1 = new Circle(4);
		System.out.println("circle1: " + circle1 + "\n");
		
		Cylinder cylinder2 = new Cylinder(2,3);
		Circle circle2;
		circle2 = cylinder2;
		System.out.println("Superclass object reference(Cylinder to Circle): " + "\n" + circle2 + "\n");
		
		Sphere sphere2 = new Sphere(5);
		Circle circle3;
		circle3 = sphere2;
		System.out.println("Superclass object reference(Sphere to Circle): " + "\n" + circle3 + "\n");
		//is what im doing right?
		
		System.out.println("Array of 3 Circle objects");
		Circle[] circles = new Circle[3];
		circles[0] = new Circle(2);
		circles[1] = new Cylinder(3,3);
		circles[2] = new Sphere(2);
		for(int i = 0; i < circles.length; i++){
			System.out.println(circles[i]);
		}
	}
}