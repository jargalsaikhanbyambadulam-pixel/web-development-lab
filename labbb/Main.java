public class Main {
    public static void main(String[] args) {
        OrderLogger logger = OrderLogger.getInstance();
        logger.log("System started.");

        // 1. Factory-оор пицца сонгох
        Pizza myPizza = PizzaFactory.createPizza("pepperoni");
        logger.log("Selected: " + myPizza.getDescription());

        // 2. Decorator-оор нэмэлт нэмэх
        myPizza = new ExtraCheese(myPizza);
        myPizza = new Mushroom(myPizza);
        logger.log("Final Order: " + myPizza.getDescription());

        // 3. Үнийг тооцоолох
        double finalPrice = myPizza.getCost();
        System.out.println("Total Amount: " + finalPrice + "₮");

        // 4. Strategy-аар төлбөр төлөх
        PaymentStrategy payment = new QPayPayment();
        payment.pay(finalPrice);

        logger.log("Order completed successfully.");
    }
}