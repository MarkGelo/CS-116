public class Sphere extends CircleVolume{
	
	public Sphere(){
		super();
	}
	public Sphere(double r){
		super(r);
	}
	public Sphere(CircleVolume a){
		super(a.getRadius());
	}
	
	public double volume(){
		double out;
		out = (4.0/3.0) * Math.PI * Math.pow(super.getRadius(), 3.0);
		return out;
	}
	
	public String toString(){
		String out;
		out = super.toString() + "\n" + "Sphere Volume: " + this.volume();
		return out;
	}
}