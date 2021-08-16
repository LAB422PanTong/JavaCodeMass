package bank.management.system;

public class Bank {

	static Account[] accounts=new Account[100];
	
	static int count=0;
	
	//开户
	public static boolean register(Account account) {
		if(count<accounts.length) {
			accounts[count++]=account;
			return true;
		}else {
			return false;
		}
	}
	
	//登陆
	public static Account login(long id,String password) {
		for(int i=0;i<count;++i) {
			if(accounts[i].getId()==id&&accounts[i].getPassword().equals(password)) {
				return accounts[i];
			}
		}
		return null;
	}
	
	//统计总贷款
	public static double getTotalLoan() {
		double sum=0;
		for(int i=0;i<count;++i) {
			if(accounts[i] instanceof Loanable) {
				Loanable loan=(Loanable)accounts[i];
				sum+=loan.getLoan();
			}
		}
		return sum;
	}
	
	//查找账户
	public static Account getClient(long id) {
		for(int i=0;i<count;++i) {
			if(accounts[i].getId()==id) {
				return accounts[i];
			}
		}
		return null;
	}
}
