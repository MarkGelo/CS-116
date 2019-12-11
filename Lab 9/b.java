public class b extends a{
	public String s;
	
	public b(){
		super();
		s = "test";
		System.out.println("Default constructor of Class b is executing now");
	}
	public b(int a, double aa, String b){
		super(a,aa);
		s = b;
		System.out.println("Non Default constructor of Class b is executing now");
	}
	
	public void setS(String a){
		s = a;
	}
	
	public String getS(){
		return s;
	}
	
	public String toString(){
		String out = super.toString() + "\n";
		out = out + "s: " + s;
		return out;
	}
	
	public int m1(){
		int i1 = 5*a+(int)super.getAA();
		System.out.println("m1 implementation of b is executing now");
		return i1;
	}
}