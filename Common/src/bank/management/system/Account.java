package bank.management.system;

public abstract class Account {
	private static long currentID=1000;
	
	private long id;
	private String password;
	private String name;
	private String personID;
	private String email;
	private double balance;
	
	public long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
		id=++currentID;
	}
	
	public final void deposit(double money){
		balance+=money;
	}
	
	public abstract boolean withdraw(double money);
}
