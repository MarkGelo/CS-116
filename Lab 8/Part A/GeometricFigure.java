public abstract class GeometricFigure{
	private double height, width, area;
	
	public GeometricFigure(){
		height = 0;
		width = 0;
		area = 0;
	}
	public GeometricFigure(double h, double w){
		height = h;
		width = w;
		area = this.area();
	}
	
	public void setHeight(double h){
		height = h;
	}
	public void setWidth(double w){
		width = w;
	}
	
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public double getArea(){
		return area;
	}
	
	public String toString(){
		String out;
		out = "Height: " + height + ", Width: " + width + ", Area: " + area;
		return out;
	}
	
	public abstract double area();
}