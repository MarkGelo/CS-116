import java.util.Scanner;
public class SpinnerClient{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.println("Input the value you want for spinner 2");
		int val = in.nextInt();
		Spinner d1 = new Spinner();
		Spinner d2 = new Spinner(val);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println("The sum of the arrows are " + (d1.getArrow() + d2.getArrow()));
		
		d1.spin();
		d2.spin();
		
		System.out.println(d1);
		System.out.println(d2);
		if(d1.equal(d2)){
			System.out.println("The objects are equal");
		}
		else{
			System.out.println("The objects are not equal");
		}
		System.out.println("The sum of the arrows are " + (d1.getArrow() + d2.getArrow()));
	}
}