import java.util.Date;

public class InventoryCheck {
    private Date date;
    private int actualQuantity;
    private int systemQuantity;

    public InventoryCheck(Date date, int actualQuantity, int systemQuantity) {
        this.date = date;
        this.actualQuantity = actualQuantity;
        this.systemQuantity = systemQuantity;
    }

    public int calculateDifference() {
        return actualQuantity - systemQuantity;
    }
}