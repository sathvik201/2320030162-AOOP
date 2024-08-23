package pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testcase {

    @Test
    public void testBasicPizza() {
        Pizza pizza = new BasicPizza();
        assertEquals("Basic Pizza", pizza.getDescription());
        assertEquals(5.00, pizza.getCost());
    }

    @Test
    public void testCheeseDecorator() {
        Pizza pizza = new BasicPizza();
        pizza = new CheeseDecorator(pizza);
        assertEquals("Basic Pizza, Cheese", pizza.getDescription());
        assertEquals(6.50, pizza.getCost());
    }

    @Test
    public void testPepperoniDecorator() {
        Pizza pizza = new BasicPizza();
        pizza = new PepperoniDecorator(pizza);
        assertEquals("Basic Pizza, Pepperoni", pizza.getDescription());
        assertEquals(7.00, pizza.getCost());
    }

    @Test
    public void testVegetableDecorator() {
        Pizza pizza = new BasicPizza();
        pizza = new VegetableDecorator(pizza);
        assertEquals("Basic Pizza, Vegetables", pizza.getDescription());
        assertEquals(6.25, pizza.getCost());
    }

    @Test
    public void testCombinedDecorators() {
        Pizza pizza = new BasicPizza();
        pizza = new CheeseDecorator(pizza);
        pizza = new PepperoniDecorator(pizza);
        pizza = new VegetableDecorator(pizza);
        
        assertEquals("Basic Pizza, Cheese, Pepperoni, Vegetables", pizza.getDescription());
        assertEquals(9.75, pizza.getCost());
    }
}
