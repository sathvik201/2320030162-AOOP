package pizza;

public class VegetableDecorator extends PizzaDecorator {
    public VegetableDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Vegetables";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.25; // Extra cost for vegetables
    }
}
