public class Main {
    public static void main(String[] args) {
        // 사람 선언
        Person p1 = new Person();
        p1.setName("김신의");
        p1.setAge(28);
        p1.setCashAmount(30000);

        // 은행 계좌 생성
        BankAccount a1 = new BankAccount();        
        a1.setBalance(100000);
        
        p1.setAccount(a1);
        a1.setOwner(p1);

        // 3 - 4. write code here
        Person p2 = new Person();
        BankAccount a2 = new BankAccount();
        p2.setAccount(a2);
        a2.setOwner(p2);
        p2.setCashAmount(100000);
        a2.setBalance(500000);
        
        System.out.println(a2.deposit(30000));
        System.out.println(a2.withdraw(170000));
        System.out.println(a2.deposit(620000));
        System.out.println(a2.withdraw(890000));
        
    }
}
