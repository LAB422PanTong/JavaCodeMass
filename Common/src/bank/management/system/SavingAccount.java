package bank.management.system;

public class SavingAccount extends Account {

	@Override
	public boolean withdraw(double money) {
		if(super.getBalance()>=money) {
			super.setBalance(super.getBalance()-money);
			return true;
		}
		else {
			return false;
		}
	}

}
