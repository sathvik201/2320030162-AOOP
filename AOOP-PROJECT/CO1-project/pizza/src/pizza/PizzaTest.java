package pizza;

public class PizzaTest {
    public static void main(String[] args) {
        Pizza myPizza = new BasicPizza();
        System.out.println(myPizza.getDescription() + " $" + myPizza.getCost());

        myPizza = new CheeseDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " $" + myPizza.getCost());

        myPizza = new PepperoniDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " $" + myPizza.getCost());

        myPizza = new VegetableDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " $" + myPizza.getCost());
    }
}
