public class c extends a{
	public double c;
	
	public c(){
		super();
		c = 0;
		System.out.println("Default constructor of Class c is executing now");
	}
	public c(int a, double aa, double b){
		super(a,aa);
		c = b;
		System.out.println("Non Default constructor of Class c is executing now");
	}
	
	public void setC(double a){
		c = a;
	}
	
	public double getC(){
		return c;
	}
	
	public String toString(){
		String out = super.toString() + "\n";
		out = out + "c: " + c;
		return out;
	}
	
	public int m1(){
		int i2 = a+(int)(c/2);
		System.out.println("m1 implementation of C is executing now");
		return i2;
	}
}