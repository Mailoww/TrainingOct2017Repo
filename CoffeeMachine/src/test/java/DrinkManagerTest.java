import org.junit.Assert;
import org.junit.Test;

public class DrinkManagerTest {

    public static final char CHARACTER_FOR_COFFEE = 'C';
    public static final char CHARACTER_FOR_TEA = 'T';
    public static final char CHARACTER_FOR_CHOCOLATE = 'H';

    @Test
    public void should_make_coffee(){
        Assert.assertEquals("C::", DrinkManager.create().make(
                new Drink(CHARACTER_FOR_COFFEE)));
    }

    @Test
    public void should_make_tea(){
        Assert.assertEquals("T::", DrinkManager.create().make(
                new Drink(CHARACTER_FOR_TEA)
        ));
    }

    @Test
    public void should_make_chocolate(){
        Assert.assertEquals("H::", DrinkManager.create().make(
                new Drink(CHARACTER_FOR_CHOCOLATE)
        ));
    }

    @Test
    public void should_make_coffee_with_one_sugar(){
        Assert.assertEquals("C:1:0", DrinkManager.create().make(
                Drink.create(CHARACTER_FOR_COFFEE, 1)
        ));
    }

    @Test
    public void should_make_tea_with_one_sugar(){
        Assert.assertEquals("T:1:0", DrinkManager.create().make(
                Drink.create(CHARACTER_FOR_TEA, 1)
        ));
    }

    @Test
    public void should_make_chocolate_with_one_sugar(){
        Assert.assertEquals("H:1:0", DrinkManager.create().make(
                Drink.create(CHARACTER_FOR_CHOCOLATE, 1)
        ));
    }

    @Test
    public void should_make_drink_with_two_sugar(){
        Assert.assertEquals("H:2:0", DrinkManager.create().make(
                Drink.create(CHARACTER_FOR_CHOCOLATE, 2)
        ));
    }

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_exception_when_make_drink_with_three_sugar(){
        DrinkManager.create().make(
                Drink.create(CHARACTER_FOR_CHOCOLATE, 3));
    }

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_exception_when_make_drink_with_negative_number_sugar(){
        DrinkManager.create().make(
                Drink.create(CHARACTER_FOR_CHOCOLATE, -1));
    }

    @Test
    public void should_send_a_message(){
        String message = "Message test";
        Assert.assertEquals("M:" + message, DrinkManager.create().send(message));
    }

    @Test
    public void should_command_a_coffee_with_exact_price() {
        Assert.assertEquals("C:2:0", DrinkManager.create().command(
                Drink.create(CHARACTER_FOR_COFFEE, 2)
                , 0.6
        ));
    }
}
