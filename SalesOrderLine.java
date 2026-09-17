public class SalesOrderLine {

    public Product product;
    public int quantity;
    public double soldPrice;

    public SalesOrderLine(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        this.soldPrice = product.price;
    }

    public double getLineTotal() {
        return this.quantity * this.soldPrice;
    }
}