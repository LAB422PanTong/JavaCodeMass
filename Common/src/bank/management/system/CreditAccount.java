package bank.management.system;

public class CreditAccount extends Account{
	private double ceiling;//Í¸Ö§¶î¶È
	
	public double getCeiling() {
		return ceiling;
	}

	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}

	@Override
	public boolean withdraw(double money) {
		if(this.ceiling+money>=super.getBalance()) {
			super.setBalance(super.getBalance()-money);
			return true;
		}
		else {
			return false;
		}
	}

}
