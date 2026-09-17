import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private ArrayList<Product> products;
    
    public Warehouse() {
        products = new ArrayList<>();
}

public void addProduct(Product p) {
    products.add(p);
}


public List<Product> getProducts() {
    return products;
}
}