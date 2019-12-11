public class CylinderSphereClient{
	public static void main(String[] args){
		Cylinder cylinder1 = new Cylinder(2,3);
		System.out.println(cylinder1 + "\n");
		
		Sphere sphere1 = new Sphere(2);
		System.out.println(sphere1 + "\n");
		
		Cylinder cylinder2 = new Cylinder(2,3);
		CircleVolume circle2;
		circle2 = cylinder2;
		System.out.println("Cylinder to a reference of the abstract class: ");
		System.out.println("Radius: " + circle2.getRadius() + ", Volume: " + circle2.volume() + "\n");
		
		Sphere sphere2 = new Sphere(2);
		CircleVolume circle3;
		circle3 = sphere2;
		System.out.println("Sphere to a reference of the abstract class: ");
		System.out.println("Radius: " + circle3.getRadius() + ", Volume: " + circle3.volume() + "\n");
		
		CircleVolume[] array = new CircleVolume[4];
		array[0] = cylinder1;
		array[1] = cylinder2;
		array[2] = sphere1;
		array[3] = sphere2;
		for(int i = 0; i < array.length; i++){
			System.out.println("Index " + i + ": " + array[i]);
		}
	}
}