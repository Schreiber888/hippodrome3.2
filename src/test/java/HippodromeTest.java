import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @BeforeEach
    void setUp() {
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
        List<Horse> list = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(list));
    }

    @Test
    public void constructorWithNullListHippodromeMessageTest(){
        List<Horse> list = new ArrayList<>();
        try {
            new Hippodrome(list);
        } catch (Exception e) {
            Assertions.assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }

    @Test
    void getHorses() {
        List<Horse> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Horse("Horse № "+ i, ThreadLocalRandom.current().nextDouble())); //проверить число
        }
        Assertions.assertEquals(30, list.size());
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}