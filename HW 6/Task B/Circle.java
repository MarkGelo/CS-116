public class Circle{
	private double radius;
	
	public Circle(){
		radius = 0;
	}
	public Circle(double r){
		radius = Math.abs(r);
	}
	
	public void setRadius(double r){
		radius = Math.abs(r);
	}
	
	public double getRadius(){
		return radius;
	}
	
	public double circumference(){
		double out;
		out = 2 * Math.PI * radius;
		return out;
	}
	
	public double area(){
		double out;
		out = Math.PI * Math.pow(radius,2.0);
		return out;
	}
	
	public String toString(){
		String out;
		out = "Radius: " + radius + ", Circumference: " + this.circumference() + ", Area: " + this.area();
		return out;
	}
}