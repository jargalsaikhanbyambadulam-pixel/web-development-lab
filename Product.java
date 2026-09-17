public class Product {

    private String name;
    private String barcode;
    private double price;

    public Product(String name, String barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "(" + barcode + ") @ " + price;
    }
}