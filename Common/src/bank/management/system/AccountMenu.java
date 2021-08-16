package bank.management.system;

import java.util.Scanner;

public class AccountMenu {

	Account account;
	private Scanner input=new Scanner(System.in);
	
	public AccountMenu() {}
	public AccountMenu(Account account) {
		this.account=account;
	}
	
	public void showMainMenu() {
		System.out.println("1存2取3查4转5贷6还7修8注");
		int choice=input.nextInt();
		
		switch(choice) {
		case 1:
			deposite();
			break;
		case 2:
			withdraw();
			break;		
		case 3:
			ask();
			break;
		case 4:
			giveOther();
			break;
		case 5:
			requestLoan();
			break;
		case 6:
			payLoan();
			break;		
		case 7:
			break;
		case 8:
			logout();
			break;
		default:
			break;
		}
	}

	private void payLoan() {
		if(account instanceof Loanable) {
			System.out.println("请输入还款金额：");
			double money=input.nextDouble();
			Loanable loanableAccount=(Loanable) account;
			loanableAccount.payLoan(money);
			System.out.println("当前贷款总额为："+loanableAccount.getLoan());
		}else {
			System.out.println("该账户不能贷款");
		}
		showMainMenu();
	}
	private void requestLoan() {
		if(account instanceof Loanable) {
			System.out.println("请输入贷款金额：");
			double money=input.nextDouble();
			Loanable loanableAccount=(Loanable) account;
			loanableAccount.requestion(money);
			System.out.println("当前贷款总额为："+loanableAccount.getLoan());
		}else {
			System.out.println("该账户不能贷款");
		}
		showMainMenu();
	}
	private void giveOther() {
		System.out.println("转给谁？转多少？");
		long client=input.nextInt();
		double money=input.nextDouble();
		
		Account targetAccount=Bank.getClient(client);
		if(targetAccount!=null) {
			if(account.getBalance()>=money) {
				account.setBalance(account.getBalance()-money);
				targetAccount.setBalance(targetAccount.getBalance()+money);
				System.out.println("成功，还剩"+account.getBalance());
			}else{
				System.out.println("没钱了，还剩"+account.getBalance());
			}
			
			targetAccount.deposit(money);
		}else {
			System.out.println("没这人");
		}

		showMainMenu();	
		
	}
	private void ask() {
		System.out.println("还剩"+account.getBalance());
		System.out.println(".......................");
		showMainMenu();	
	}
	private void withdraw() {
		System.out.println("取多少？");
		double money=input.nextDouble();
		if(!account.withdraw(money)) {
			System.out.println("没钱了");
		}
		showMainMenu();	
	}
	
	private void logout() {
		new Test().showSystemMenu();	
	}
	private void deposite() {
		System.out.println("存多少？");
		double money=input.nextDouble();
		account.deposit(money);
		showMainMenu();
	}
}
