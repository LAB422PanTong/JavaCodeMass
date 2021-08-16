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
		System.out.println("1��2ȡ3��4ת5��6��7��8ע");
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
			System.out.println("�����뻹���");
			double money=input.nextDouble();
			Loanable loanableAccount=(Loanable) account;
			loanableAccount.payLoan(money);
			System.out.println("��ǰ�����ܶ�Ϊ��"+loanableAccount.getLoan());
		}else {
			System.out.println("���˻����ܴ���");
		}
		showMainMenu();
	}
	private void requestLoan() {
		if(account instanceof Loanable) {
			System.out.println("����������");
			double money=input.nextDouble();
			Loanable loanableAccount=(Loanable) account;
			loanableAccount.requestion(money);
			System.out.println("��ǰ�����ܶ�Ϊ��"+loanableAccount.getLoan());
		}else {
			System.out.println("���˻����ܴ���");
		}
		showMainMenu();
	}
	private void giveOther() {
		System.out.println("ת��˭��ת���٣�");
		long client=input.nextInt();
		double money=input.nextDouble();
		
		Account targetAccount=Bank.getClient(client);
		if(targetAccount!=null) {
			if(account.getBalance()>=money) {
				account.setBalance(account.getBalance()-money);
				targetAccount.setBalance(targetAccount.getBalance()+money);
				System.out.println("�ɹ�����ʣ"+account.getBalance());
			}else{
				System.out.println("ûǮ�ˣ���ʣ"+account.getBalance());
			}
			
			targetAccount.deposit(money);
		}else {
			System.out.println("û����");
		}

		showMainMenu();	
		
	}
	private void ask() {
		System.out.println("��ʣ"+account.getBalance());
		System.out.println(".......................");
		showMainMenu();	
	}
	private void withdraw() {
		System.out.println("ȡ���٣�");
		double money=input.nextDouble();
		if(!account.withdraw(money)) {
			System.out.println("ûǮ��");
		}
		showMainMenu();	
	}
	
	private void logout() {
		new Test().showSystemMenu();	
	}
	private void deposite() {
		System.out.println("����٣�");
		double money=input.nextDouble();
		account.deposit(money);
		showMainMenu();
	}
}
