interface PaymentStrategy {
    void pay(double amount);
}

class CashPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.println("Paid " + amount + "₮ via Cash."); }
}

class QPayPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.println("Paid " + amount + "₮ via QPay."); }
}