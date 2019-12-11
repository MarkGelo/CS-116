public class Square extends GeometricFigure{
	
	public Square(){
		super();
	}
	public Square(double h, double w){
		super(h,w);
	}
	
	public double area(){
		double a;
		a = this.getWidth() * this.getHeight();
		return a;
	}
}