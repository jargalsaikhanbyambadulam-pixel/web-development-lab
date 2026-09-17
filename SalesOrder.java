import java.io.PrintStream;
import java.util.ArrayList;

public class SalesOrder {

    private Employee employee;
    private java.util.Date date; 
    private ArrayList<OrderLine> lines;
    private DiscountCard discountCard;

    public SalesOrder(Employee employee) {
        this.employee = employee;
        this.date = new java.util.Date();// odoogiin ognoog awna
        this.lines = new ArrayList<>();
    }
    public void addLine(Product p, int qty) {
        lines.add(new OrderLine(p, qty));
    }

    public void setDiscountCard(DiscountCard card){
        this.discountCard = card;
    }

    public void calculateAndPrint() {
        double subtotal = 0;
        PrintStream out = System.out;
        out.println("\n======Borluulaltiin tailan======");
        out.println("Cash: " + employee.name);
        out.println("Ognoo: " + date);

        for (OrderLine line : lines) {
            subtotal +=line.getLineTotal();
            out.println(line);
        }
    double vat = subtotal * 0.10; //10% VAT
    double totalWithVat = subtotal + vat;
    double discount = 0;

    if (discountCard != null) {
        if (discountCard.active) {

            out.println("Idewhtei Hereglegch : " + discountCard.discountPercent + "% cardtai");
            discount = totalWithVat * (discountCard.discountPercent /100);

            out.println("Niit dvngeer: " + totalWithVat + "tugrug");
            out.println("Hungulult: " + discountCard.discountPercent + "% baina");
            out.println("Vilchlvvlegch: " + discountCard.customer.name);
            out.println("Hungulultiin dvn: " + discount + "tugrug");
        } else {
            out.println("Tanii hungulultiin card idewhgvi baina!");
        }
    }

    double finalTotal = totalWithVat - discount;

    out.println("Niit dvn (VATgvi): " + subtotal + "tugrug");
    out.println("VAT (10%): " + vat + "tugrug");
    out.println("TOTAL TULUH DVN: " + finalTotal + "tugrug");
    out.println("-----------------");
} 
}