package bank.management.system;

import java.util.Scanner;

public class Test {
	private Scanner input=new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("��ӭ����");
		new Test().showSystemMenu();
	}
	
	public void showSystemMenu() {
		System.out.println("..............");
		System.out.println("1����,2��¼");
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
		System.out.println("�˺ţ����룿");
		int id=input.nextInt();
		String password=input.next();
		
		Account account=Bank.login(id, password);
		if(account!=null) {
			System.out.println("�ɹ�");
			new AccountMenu(account).showMainMenu();
		}else {
			System.out.println("ʧ��");
			showSystemMenu();
		}
	}

	private void register() {
		System.out.println("1����2����3�����4��������");
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
		System.out.println("������");
		account.setName(input.next());
		System.out.println("���룿");
		account.setPassword(input.next());
		System.out.println("���֤��");
		account.setPersonID(input.next());
		System.out.println("���䣿");
		account.setEmail(input.next());
		
		if(account instanceof CreditAccount) {
			System.out.println("���ö�ȣ�");
			((CreditAccount) account).setCeiling(input.nextDouble());
		}
		
		if(Bank.register(account)) {
			System.out.println("�����ɹ�"+account.getId());
		}else {
			System.out.println("ʧ��");
		}
		showSystemMenu();
	}
}
