

public class BankApp {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount(1000);

        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000); // алдаа шалгах

        System.out.println("Final balance: " + acc.getBalance());

        acc.simulateFatal(); // fatal жишээ
    }
}