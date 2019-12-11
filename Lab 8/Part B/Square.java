public class Square extends GeometricFigure implements SidedObject{
	
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
	
	public int displaySides(){
		return 4;
	}
	
	public String toString(){
		String out = super.toString();
		out = out + ", Sides: " + this.displaySides();
		return out;
	}
}