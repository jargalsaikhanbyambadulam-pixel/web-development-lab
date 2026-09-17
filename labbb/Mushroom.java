public class Mushroom extends PizzaDecorator {
        public Mushroom(Pizza pizza) { super(pizza); }
        @Override
        public String getDescription() { return decoratedPizza.getDescription() + ", Mushroom"; }
        @Override
        public double getCost() { return decoratedPizza.getCost() + 1500; }
    }