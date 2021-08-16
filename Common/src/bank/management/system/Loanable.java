package bank.management.system;

public interface Loanable {
	boolean requestion(double money);
	
	boolean payLoan(double money);
	
	double getLoan();
}
