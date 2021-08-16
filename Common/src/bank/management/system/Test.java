package bank.management.system;

import java.util.Scanner;

public class Test {
	private Scanner input=new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("欢迎光临");
		new Test().showSystemMenu();
	}
	
	public void showSystemMenu() {
		System.out.println("..............");
		System.out.println("1开户,2登录");
		int choice=input.nextInt();
		
		switch(choice) {
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			default:
				System.out.println("WRONG!!!");
				break;
		}
	}

	private void login() {
		System.out.println("账号？密码？");
		int id=input.nextInt();
		String password=input.next();
		
		Account account=Bank.login(id, password);
		if(account!=null) {
			System.out.println("成功");
			new AccountMenu(account).showMainMenu();
		}else {
			System.out.println("失败");
			showSystemMenu();
		}
	}

	private void register() {
		System.out.println("1储蓄2信用3贷款储蓄4贷款信用");
		int num=input.nextInt();
		Account account=null;
		switch(num) {
		case 1:
			account=new SavingAccount();
			break;
		case 2:
			account=new CreditAccount();
			break;
		case 3:
			account=new LoanSavingAccount();
			break;
		case 4:
			account=new LoanCreditingAccount();
			break;
		default:
			System.out.println("WRONG!!!");
			break;
		}
		System.out.println("姓名？");
		account.setName(input.next());
		System.out.println("密码？");
		account.setPassword(input.next());
		System.out.println("身份证？");
		account.setPersonID(input.next());
		System.out.println("邮箱？");
		account.setEmail(input.next());
		
		if(account instanceof CreditAccount) {
			System.out.println("信用额度？");
			((CreditAccount) account).setCeiling(input.nextDouble());
		}
		
		if(Bank.register(account)) {
			System.out.println("开户成功"+account.getId());
		}else {
			System.out.println("失败");
		}
		showSystemMenu();
	}
}
