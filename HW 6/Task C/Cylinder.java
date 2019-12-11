public class Cylinder extends CircleVolume{
	private double height;
	
	public Cylinder(){
		super();
		height = 0;
	}
	public Cylinder(double r,double h){
		super(r);
		height = Math.abs(h);
	}
	public Cylinder(CircleVolume a, double h){
		super(a.getRadius());
		height = Math.abs(h);
	}
	
	public void setHeight(double h){
		height = Math.abs(h);
	}
	
	public double getHeight(){
		return height;
	}
	
	public double volume(){
		double out;
		out = height * Math.PI * Math.pow(super.getRadius(), 2.0);
		return out;
	}
	
	public String toString(){
		String out;
		out = super.toString() + "\n";
		out = out + "Height: " + height + ", Volume: " + this.volume();
		return out;
	}
}