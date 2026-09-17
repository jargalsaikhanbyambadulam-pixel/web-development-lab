import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {


        Product p1 = new Product("Bread", "B001", 2000);
        Product p2 = new Product("Milk", "B002", 3500);

        Employee emp = new Employee("Bat");
        Customer cus = new Customer("Sara", "Ulaanbaatar", "95888888");
        DiscountCard card = new DiscountCard("CARD01", null, 5.0);

        cus.assignCard(card);
        PrintStream out = System.out;
        out.println("Ezemshigch: " + cus);
        out.println("Card: " + card);

        card.activate();
        out.println("card idewhtei baina: " + card);

        SalesOrder order = new SalesOrder(emp);
        order.addLine(p1, 2);
        order.addLine(p2, 1);

        order.setDiscountCard(card);

        order.calculateAndPrint();
    }
}