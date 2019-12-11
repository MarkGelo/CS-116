package Client.Services.Classes;
import Client.Services.BillsType;
public class MyBills{
	private String month;//instance variables
	private BillsType type;
	private double[] expenses;
	private int days;
	private static int count = 0;
	private int id;
	
	public MyBills(){//default
		month = "any month";
		type = null;
		expenses = null;
		days = 0;
		count += 1;
		id = count;
	}
	public MyBills(String m, BillsType t, double[] e, int d){//non default
		month = m;
		type = t;
		expenses = e;
		days = d;
		count += 1;
		id = count;
	}
	
	//accessors
	public String getMonth(){
		return month;
	}
	public BillsType getType(){
		return type;
	}
	public double[] getExpenses(){
		return expenses;
	}
	public int getDays(){
		return days;
	}
	public int getId(){
		return id;
	}
	public int getStaticId(){
		return count;
	}
	
	//mutators
	public void setMonth(String m){
		month = m;
	}
	public void setType(BillsType t){
		type = t;
	}
	public void setExpenses(double[] e){
		expenses = e;
	}
	public void setDays(int d){
		days = d;
	}
	public void setId(int i){
		id = i;
	}
	
	public boolean equals(MyBills a){
		if(this.getType().equals(a.getType()) && this.getDays() == this.getDays()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		String exp = "";
		for(int i = 0; i < expenses.length; i++){
			exp = exp + expenses[i] + " ";
		}
		return ("Month: " + month + "\n" + "Type: " + type + "\n" + "Expenses: " + exp + "\n" + "Days: " + days + "\n" + "ID: " + id + "\n" + "Static ID: " + count);
	}
}