import java.util.Scanner;
public class DailySalesClient{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		boolean start = true;
		System.out.print("Enter the number of days(if invalid, 10 days assumed):");
		int days = in.nextInt();
		if(days <= 0){
			days = 10;
		}
		else{
		}
		DailySales sales = new DailySales(days);
		int d;
		int s;
		while(start){
			System.out.println("Enter the day(if you want to quit, enter a negative number):");
			d = in.nextInt();
			if(d < 0){
				start = false;
				break;
			}
			else{
			}
			System.out.println("Enter the sales for day 1:");
			s = in.nextInt();
			if(sales.addSales(d, s)){
				System.out.println("Successfully added the data");
			}
			else{
				System.out.println("Unable to add the data");
			}
			System.out.println(sales);
		}
		int[] daysBelow = sales.daysBelowGoal().clone();
		String out = "";
		for(int i = 0; i < daysBelow.length; i++){
			out = out + "Day " + daysBelow[i] + " : " + sales.getSales(daysBelow[i]) + "\n";
		}
		System.out.println("Completed entering the sales data");
		System.out.println("Final Sales Data Analysis");
		System.out.println(sales);
		System.out.println("Max sales occured on Day " + sales.maxDay());
		System.out.println("Days not meeting the sales goal: ");
		System.out.println(out);
	}
}