public class BusinessLoan extends Loan{
	
	public BusinessLoan(){
		super();
	}
	public BusinessLoan(String c, double l, int t, double r){
		super(c,l,t);
		super.setRate(0.01 + r);
	}
}