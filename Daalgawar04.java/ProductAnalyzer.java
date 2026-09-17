import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private int price;

    public Product(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    // toString
    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}

public class ProductAnalyzer {

    public static Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
                // 1000₮-с дээш шүүх
                .filter(p -> p.getPrice() > 1000)
                // категориор нэгтгэх
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        // категорийн дотор үнийн буурахаар эрэмбэлэх
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            list.sort((p1, p2) -> p2.getPrice() - p1.getPrice());
                            return list;
                        })
                ));
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Gutal", "Huwtsas", 1500),
                new Product("Tsamts", "Huwtsas", 1200),
                new Product("Umd", "Huwtsas", 900),
                new Product("Talh", "Hvns", 800),
                new Product("Mah", "Hvns", 2000)
        );

        Map<String, List<Product>> result = analyze(products);

        result.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });
    }
}