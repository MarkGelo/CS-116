public class Client{
	public static void main(String[] args){
		b bb = new b();
		c cc = new c();
		System.out.println(bb.m1());
		System.out.println(cc.m1());
		
		d dd = new d();
		dd.m3();
		
		System.out.println(dd.m2('e'));
		System.out.println(dd.m2('n'));
	}
}