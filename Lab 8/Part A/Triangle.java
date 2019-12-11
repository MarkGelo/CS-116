public class Triangle extends GeometricFigure{
	
	public Triangle(){
		super();
	}
	public Triangle(double h, double w){
		super(h,w);
	}
	
	public double area(){
		double a;
		a = 0.5 * this.getWidth() * this.getHeight();
		return a;
	}
}