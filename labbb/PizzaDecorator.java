abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza) { this.decoratedPizza = pizza; }
    public String getDescription() { return decoratedPizza.getDescription(); }
    public double getCost() { return decoratedPizza.getCost(); }
}

class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) { super(pizza); }
    public String getDescription() { return decoratedPizza.getDescription() + ", Extra Cheese"; }
    public double getCost() { return decoratedPizza.getCost() + 2000; }
}

class Mushroom extends PizzaDecorator {
    public Mushroom(Pizza pizza) { super(pizza); }
    public String getDescription() { return decoratedPizza.getDescription() + ", Mushroom"; }
    public double getCost() { return decoratedPizza.getCost() + 1500; }
}