import java.util.Scanner;
public class CreateLoans{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Loan[] loans = new Loan[5];
		System.out.println("Input the current prime interest rate in decimals?");
		double r = in.nextDouble();
		for(int i = 0; i < 5; i++){
			System.out.println("Input Loan type(Business/Personal), customer last name, loan amount, term with no spaces. Ex. (Business Gameng 50000 5)");
			String loanType = in.next();
			String name = in.next();
			double amount = in.nextDouble();
			int term = in.nextInt();
			if(loanType.equals("Business")){
				loans[i] = new BusinessLoan(name, amount, term, r);
			}else if(loanType.equals("Personal")){
				loans[i] = new PersonalLoan(name, amount, term, r);
			}else{
				System.out.println("Incorrect Loan type, setting to Personal");
				loans[i] = new PersonalLoan(name, amount, term, r);
			}
			System.out.println("Loan inputted" + "\n");
		}
		System.out.println("Displaying all the loans");
		for(int i = 0; i < loans.length; i++){
			System.out.println(loans[i] + "\n");
		}
	}
}