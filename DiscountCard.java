public class DiscountCard {
    public String barcode;
    public Customer customer;
    public double discountPercent;
    public boolean active = true;

    public DiscountCard(String barcode, Customer customer, Double discountPercent) {
        this.barcode = barcode;
        this.customer = customer;
        this.discountPercent = discountPercent;
    }

    public void activate() {active = true; }
    public void deactivate() { active = false; }

    @Override
    public String toString() {
        String owner = (customer != null ? customer.name : "<none>");
        return "Card: " + barcode + " (" + discountPercent + "% for " + owner + ")[" +
            (active ? "active": "inactive") + "]";
    }
}