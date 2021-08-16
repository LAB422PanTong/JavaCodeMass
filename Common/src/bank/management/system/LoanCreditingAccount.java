package bank.management.system;

public class LoanCreditingAccount extends CreditAccount implements Loanable{

	private double loanAmount;
	
	@Override
	public boolean requestion(double money) {
		this.loanAmount+=money;
		return true;
	}

	@Override
	public boolean payLoan(double money) {
		if(getBalance()>=money) {
			setBalance(getBalance()-money);
			loanAmount-=money;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public double getLoan() {
		return this.loanAmount;
	}

}
