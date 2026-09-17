import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankSimulation {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        // 2 thread-тэй pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 3 хэрэглэгч
        executor.submit(new Customer(account, "deposit", 500));
        executor.submit(new Customer(account, "withdraw", 700));
        executor.submit(new Customer(account, "withdraw", 600));

        // шинэ ажил авахгүй
        executor.shutdown();

        // бүх ажил дуусахыг хүлээнэ
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}