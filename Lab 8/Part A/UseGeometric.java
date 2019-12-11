public class UseGeometric{
	public static void main(String[] args){
		Square square1 = new Square(1,2);
		Square square2 = new Square(2,3);
		Triangle triangle1 = new Triangle(1,1);
		Triangle triangle2 = new Triangle(2,2);
		Triangle triangle3 = new Triangle(3,4);
		GeometricFigure[] array = new GeometricFigure[5];
		array[0] = square1;
		array[1] = square2;
		array[2] = triangle1;
		array[3] = triangle2;
		array[4] = triangle3;
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
	}
}