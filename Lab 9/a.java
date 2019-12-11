public abstract class a{
	public int a;
	private double aa;
	
	public a(){
		a = 0;
		aa = 0;
		System.out.println("Default constructor of Class a is executing now");
	}
	public a(int s, double ss){
		System.out.println("Non default Constructor of Class a is executing now");
		a = s;
		aa = ss;
	}
	
	public void setA(int s){
		a = s;
	}
	public void setAA(double ss){
		aa = ss;
	}
	
	public int getA(){
		return a;
	}
	public double getAA(){
		return aa;
	}
	
	public String toString(){
		String out;
		out = "a: " + a + ", aa: " + aa;
		return out;
	}
	
	public int m2(char a){
		int x = (int)a;
		System.out.println("m2 of A is executing now");
		return x;
	}
	public int m2(int x1){
		int y = 10 + x1;//get the returend value from the first version and add x1
		System.out.println("second version of m2 in A is executing now");
		return y;
	}
	public void m3(){
		System.out.println("m3 of A is executing now");
	}
	public abstract int m1();
}