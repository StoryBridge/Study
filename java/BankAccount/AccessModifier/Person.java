package accessmodifier;

public class Person {
	private String name;
	private int age;
	private int cashAmount;
	private BankAccount account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(int cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	// 첫 번째 파라미터: 받는 사람 (Person)
	// 두 번째 파라미터: 이체할 금액 (정수)
	// 리턴 : 성공여부 (불린)
	public boolean transfer(Person to, int amount) {
		boolean success;
		if (amount < 0 || amount > account.getBalance()) {
			success = false;
		} else {
			account.setBalance(account.getBalance() - amount);
			to.getAccount().setBalance(to.getAccount().getBalance() + amount);
			success = true;
		}
		// 결과값 출력
		System.out.println(success + " - from: " + name + ", to: " + to.getName() + ", amount: " + amount
				+ ", balance: " + account.getBalance());
		return success;
	}

	// 첫 번째 파라미터: 받는 사람의 계정 (BankAccount)
	// 두 번째 파라미터: 이체할 금액 (정수)
	// 리턴 : 성공여부 (불린)
	public boolean transfer(BankAccount to, int amount) {
		boolean success;
		if (amount < 0 || amount > account.getBalance()) {
			success = false;
		} else {
			account.setBalance(account.getBalance() - amount);
			to.setBalance(to.getBalance() + amount);
			success = true;
		}
		// 결과값 출력
		System.out.println(success + " - from: " + name + ", to: " + to.getOwner().getName() + ", amount: " + amount
				+ ", balance: " + account.getBalance());
		return success;
	}
}
