public abstract class Loan implements LoanConstants{
	private static int count = 0;
	private int id;
	private String customer;
	private double loan;
	private double rate;
	private int term;
	
	public Loan(){
		count += 1;
		id = count;
		customer = "None";
		loan = 0;
		rate = 0;
		term = 0;
	}
	public Loan(String c, double l, int t){
		count += 1;
		id = count;
		customer = c;
		if(l > maximumLoan){
			System.out.println("$100,000 is max, setting to $100,000 loan amount");
			loan = maximumLoan;
		}else{
			loan = l;
		}
		switch(t){
			case 1: term = shortTerm; break;
			case 3: term = mediumTerm; break;
			case 5: term = longTerm; break;
			default: term = shortTerm; break;
		}
	}
	
	public void setCustomer(String c){
		customer = c;
	}
	public void setLoan(double l){
		loan = l;
	}
	public void setRate(double r){
		rate = r;
	}
	public void setTerm(int t){
		switch(t){
			case 1: term = shortTerm; break;
			case 3: term = mediumTerm; break;
			case 5: term = longTerm; break;
			default: term = shortTerm; break;
		}
	}
	
	public int getId(){
		return id;
	}
	public String getCustomer(){
		return customer;
	}
	public double getLoan(){
		return loan;
	}
	public double getRate(){
		return rate;
	}
	public int getTerm(){
		return term;
	}
	
	public String toString(){
		String out;
		out = "Company name: " + companyName + "\n";
		out = out + "Customer: " + customer + " , ID: " + id + "\n";
		out = out + "Loan: " + loan + " , Interest: " + rate + " , Term: " + term + " year" + "\n";
		out = out + "Amount owed at due date: $" + this.amountDue();
		return out;
	}
	
	public double amountDue(){
		double out;
		out = loan * (1 + rate * (term * 12));//simple interest
		return out;
	}
}