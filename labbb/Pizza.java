public interface Pizza {
    String getDescription();
    double getCost();
}

class Margherita implements Pizza {
    public String getDescription() { return "Margherita Pizza"; }
    public double getCost() { return 15000; }
}

class Pepperoni implements Pizza {
    public String getDescription() { return "Pepperoni Pizza"; }
    public double getCost() { return 18000; }
}

class PizzaFactory {
    public static Pizza createPizza(String type) {
        return switch (type.toLowerCase()) {
            case "margherita" -> new Margherita();
            case "pepperoni" -> new Pepperoni();
            default -> throw new IllegalArgumentException("Unknown pizza type");
        };
    }
}