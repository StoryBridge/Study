package accessmodifier;

public class BankAccount {
	private int balance;
	private Person owner;

	// 파라미터 : 입금할 액수(정수)
	// 리턴 : 성공여부(불린)
	boolean deposit(int amount) {
		// 1. write code here
		if (amount < 0 || owner.getCashAmount() < amount) {
			System.out.println("입금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
			return false;
		} else {
			balance += amount;
			owner.setCashAmount(owner.getCashAmount() - amount);
			System.out.println(amount + "원 입금하였습니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
			return true;
		}
	}

	// 파라미터 : 출금할 액수(정수)
	// 리턴 : 성공여부(불린)
	boolean withdraw(int amount) {
		// 2. write code here
		if (amount < balance && amount >= 0) {
			balance -= amount;
			owner.setCashAmount(owner.getCashAmount() + amount);
			System.out.println(amount + "원 출금하였습니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
			return true;
		} else {
			System.out.println("출금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
			return false;
		}

	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	// 첫 번째 파라미터: 받는 사람 (Person)
	// 두 번째 파라미터: 이체할 금액 (정수)
	// 리턴 : 성공여부 (불린)
	public boolean transfer(Person to, int amount) {
		boolean success;
		if (amount < 0 || amount > balance) {
			success = false;
		} else {
			balance = balance - amount;
			to.getAccount().setBalance(to.getAccount().getBalance() + amount);
			success = true;
		}
		// 결과값 출력
		System.out.println(success + " - from: " + owner.getName() + ", to: " + to.getName() + ", amount: " + amount
				+ ", balance: " + balance);
		return success;
	}

	// 첫 번째 파라미터: 받는 사람의 계정 (BankAccount)
	// 두 번째 파라미터: 이체할 금액 (정수)
	// 리턴 : 성공여부 (불린)
	public boolean transfer(BankAccount to, int amount) {
		boolean success;
		if (amount < 0 || amount > balance) {
			success = false;
		} else {
			balance -= amount;
			to.setBalance(to.getBalance() + amount);
			success = true;
		}
		// 결과값 출력
		System.out.println(success + " - from: " + owner.getName() + ", to: " + to.getOwner().getName() + ", amount: " + amount
				+ ", balance: " + balance);
		return success;
	}
}
