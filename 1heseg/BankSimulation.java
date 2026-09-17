public class BankSimulation {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread[] customers = new Thread[3];

        customers[0] = new Thread(new Customer(account, "deposit", 500));
        customers[1] = new Thread(new Customer(account, "withdraw", 700));
        customers[2] = new Thread(new Customer(account, "withdraw", 600));

        
        for (Thread t : customers) {
            t.start();
        }

        
        for (Thread t : customers) {
            t.join();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}