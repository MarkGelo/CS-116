package Client;
import java.util.Scanner;
import java.io.*;
import java.text.*;
import Client.Services.Classes.MyBills;
import Client.Services.BillsType;
public class MyBillsClient{
	public static void main(String[] args){
		try{
			File text = new File("myexpenses.txt");
			Scanner in = new Scanner(text);
			int count = 0;
			while(in.hasNextLine()){//reads how many lines
				in.nextLine();
				count += 1;
			}
			in = new Scanner(text);
			MyBills[] bill = new MyBills[count/2];
			String data;//instantiates variables
			String num;
			BillsType t;
			String m;
			for(int i = 0; i < bill.length; i++){//reads the lines 2 at a time
				data = in.nextLine();
				num = in.nextLine();
				String[] category = data.split(":");
				String[] mon = num.split(",");
				double[] money = new double[mon.length];
				for(int j = 0; j < money.length; j++){//reads the costs
					money[j] = Double.parseDouble(mon[j]);
				}
				if(category[3].equals("School")){//makes an enum based on the string
					t = BillsType.School;
				}
				else if(category[3].equals("Restaurant")){
					t = BillsType.Restaurant;
				}
				else if(category[3].equals("Clothing")){
					t = BillsType.Clothing;
				}
				else{
					t = BillsType.Other;
				}
				m = category[1];
				bill[i] = new MyBills(m, t, money, money.length);//makes an object
			}
			for(int i = 0; i < bill.length; i++){
				System.out.println(bill[i]);//displays the values
			}
			MyBillsClient no = new MyBillsClient();
			String[] output = no.totalExpensesPerMonth(bill);
			for(int i = 0; i < output.length; i++){//calculates total for each month there is
				System.out.println(output[i]);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public String[] totalExpensesPerMonth(MyBills[] bill){
			String[] out;
			double[] total = {0,0,0,0,0,0,0,0,0,0,0,0};
			String[] month = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}; 
			double[] temp;
			for(int k = 0; k < month.length; k++){//adds up all the costs for each month
				for(int i = 0; i < bill.length; i++){
					if(bill[i].getMonth().equals(month[k])){
						for(int j = 0; j < bill[i].getDays(); j++){
							temp = bill[i].getExpenses();
							total[k] += temp[j];
						}
					}
				}
			}
			int count = 0;
			for(int i = 0; i < total.length; i++){
				if(total[i] > 0){
					count += 1;
				}
			}
			int[] forMonth = new int[count];
			int k = 0;
			for(int i = 0; i < total.length; i++){//so i can reference which months the totals are
				if(total[i] > 0){
					forMonth[k] = i;
					k += 1;
				}
			}
			out = new String[count];
			NumberFormat f = NumberFormat.getCurrencyInstance();
			for(int i = 0; i < out.length; i++){//only for the months where there are inputs
				out[i] = "The Total of all expense for the month of " + month[forMonth[i]] + " is: " + f.format(total[forMonth[i]]);
			}
			return out;
		}
}