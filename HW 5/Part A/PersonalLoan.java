public class PersonalLoan extends Loan{
	
	public PersonalLoan(){
		super();
	}
	public PersonalLoan(String c, double l, int t, double r){
		super(c,l,t);
		super.setRate(0.02 + r);
	}
}