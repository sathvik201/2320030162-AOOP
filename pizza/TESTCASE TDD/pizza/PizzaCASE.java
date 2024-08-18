package pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaCASE {

    private Pizza basicPizza;

    @BeforeEach
    void setUp() {
        basicPizza = new BasicPizza();
    }

    @Test
    void testBasicPizzaDescription() {
        assertEquals("Basic Pizza", basicPizza.getDescription());
    }

    @Test
    void testBasicPizzaCost() {
        assertEquals(5.00, basicPizza.getCost());
    }

    @Test
    void testCheeseDecorator() {
        Pizza cheesePizza = new CheeseDecorator(basicPizza);
        assertEquals("Basic Pizza, Cheese", cheesePizza.getDescription());
        assertEquals(6.50, cheesePizza.getCost());
    }

    @Test
    void testPepperoniDecorator() {
        Pizza pepperoniPizza = new PepperoniDecorator(basicPizza);
        assertEquals("Basic Pizza, Pepperoni", pepperoniPizza.getDescription());
        assertEquals(7.00, pepperoniPizza.getCost());
    }

    @Test
    void testVegetableDecorator() {
        Pizza vegetablePizza = new VegetableDecorator(basicPizza);
        assertEquals("Basic Pizza, Vegetables", vegetablePizza.getDescription());
        assertEquals(6.25, vegetablePizza.getCost());
    }

    @Test
    void testMultipleDecorators() {
        Pizza pizza = new CheeseDecorator(new PepperoniDecorator(new VegetableDecorator(basicPizza)));
        assertEquals("Basic Pizza, Vegetables, Pepperoni, Cheese", pizza.getDescription());
        assertEquals(8.75, pizza.getCost());
    }
}
