public class Customer {

    public String name;
    public String address;
    public String phoneNumber;
    public DiscountCard discountCard;


    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void assignCard(DiscountCard card) {
        this.discountCard = card;
        card.customer = this;
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", " + address + ", " + phoneNumber + 
        (discountCard != null ? "[card=" + discountCard.barcode + "]" : "");
    }
}