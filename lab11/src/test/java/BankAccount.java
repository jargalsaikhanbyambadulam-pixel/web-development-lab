
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {

    // Encapsulation: private static final logger
    private static final Logger logger =
        LogManager.getLogger(BankAccount.class);

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        logger.info("BankAccount vvsgegdlee. Ehnii vzldegdel={}", initialBalance);
    }

    public void deposit(double amount) {
        logger.trace("deposit() method ruu orloo. amount={}", amount);

        if (amount < 0) {
            logger.warn("Buruu orolt: amount={} сөрөг байна", amount);
            return;
        }

        logger.debug("Deposit umnuh vldegdel: {}", balance);
        balance += amount;
        logger.info("Hadgalalt amjilttai. Dvn={}. Shine vldegdel={}", amount, balance);
        logger.trace("deposit() methid garlaa");
    }

    public void withdraw(double amount) {
        logger.trace("withdraw() method ruu orloo. amount={}", amount);

        if (amount < 0) {
            logger.warn("Buruu orolt: amount={} сөрөг байна", amount);
            return;
        }

        if (amount > balance) {
            logger.error("Vldegdelees ih mungu awah gj oroldloo. " +
                "Hvselt={}, Vldegdel={}", amount, balance);
            return;
        }

        logger.debug("Withdraw umnuh vldegdel: {}", balance);
        balance -= amount;
        logger.info("Zarlaga amjilttai. Dvn={}. Shine vldegdel={}", amount, balance);
        logger.trace("withdraw() method garlaa");
    }

    public double getBalance() {
        logger.trace("getBalance() method ruu orloo");
        logger.debug("Odoogiin vldegdel: {}", balance);
        logger.trace("getBalance() method garlaa");
        return balance;
    }

    // FATAL жишээ: системийн критик нөхцөл
    public void simulateFatal() {
        logger.fatal("Kritik aldaa: tohigroo file oldsngvi — system unah duhluu");
    }

    // Нууц мэдээллийг маскалах хэрэгсэл
    private static String mask(String s) {
        if (s == null || s.length() < 4) return "***";
        return s.substring(0, 2) + "****" + s.substring(s.length() - 2);
    }
}