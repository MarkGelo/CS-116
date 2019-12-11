public class d extends c{
	public String str;
	
	public d(){
		super();
		str = "test";
		System.out.println("Default constructor of Class d is executing now");
	}
	public d(int a, double aa, double b, String c){
		super(a,aa,b);
		str = c;
		System.out.println("Non Default constructor of Class d is executing now");
	}
	
	public void setStr(String s){
		str = s;
	}
	
	public String getStr(){
		return str;
	}
	
	public String toString(){
		String out = super.toString() + "\n";
		out = out + "str: " + str;
		return out;
	}
	
	public void m3(){
		super.m3();
		System.out.println("I am executing m3 as implemented in class d");
	}
	
	public int m2(char c){
		int x;
		if(c == 'e'){
			x = super.m2(c);
			System.out.print("The m2(char c) version of d is executing now with returned value = ");
		}else{
			x = super.m2(100);
			System.out.print("The m2(int x1) version of d is executing now with returned value = ");
		}
		return x;
	}
}