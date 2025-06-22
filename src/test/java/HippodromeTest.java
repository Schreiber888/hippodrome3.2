import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {
    private static List<Horse> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void constructorWithNullArgumentHippodromeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    public void constructorWithNullArgumentHippodromeMessageTest() {
        try {
            new Hippodrome(null);
        } catch (Exception e){
            Assertions.assertEquals("Horses cannot be null.", e.getMessage());
        }
    }

    @Test
    public void constructorWithNullListHippodromeTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(list));
    }

    @Test
    public void constructorWithNullListHippodromeMessageTest(){
        try {
            new Hippodrome(list);
        } catch (Exception e) {
            Assertions.assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }

    @Test
    void getHorses() {
        for (int i = 0; i < 30; i++) {
            list.add(new Horse("Horse № "+ i, ThreadLocalRandom.current().nextDouble(0.2,3))); //проверить число
        }
        Assertions.assertEquals(30, list.size());
    }

    /*@Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (Horse hors : horses) {
            Mockito.verify(hors).move();
        }
    }*/

    @Test
    void getWinner() {
        int max = 4;
        for (int i = 0; i <= max; i++) {
            list.add(new Horse("Horse № "+ i, 1, i));
        }
        Assertions.assertEquals(new Hippodrome(list).getWinner(), list.get(max));
    }
}