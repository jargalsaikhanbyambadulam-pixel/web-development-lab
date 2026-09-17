import java.util.Date;

public class Receipt {
    private Date date;

    public Receipt() {
        date = new Date();
    }

    public void printReceipt() {
        System.out.println("Receipt date: " + date);
    }
}