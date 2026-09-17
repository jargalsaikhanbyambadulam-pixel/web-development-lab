public class ExtraCheese extends PizzaDecorator {
        public ExtraCheese(Pizza pizza) { super(pizza); }
        @Override
        public String getDescription() { return decoratedPizza.getDescription() + ", Extra Cheese"; }
        @Override
        public double getCost() { return decoratedPizza.getCost() + 2000; }
    }