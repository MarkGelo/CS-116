public class Triangle extends GeometricFigure implements SidedObject{
	
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
	
	public int displaySides(){
		return 3;
	}
	
	public String toString(){
		String out = super.toString();
		out = out + ", Sides: " + this.displaySides();
		return out;
	}
}