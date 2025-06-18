import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        try {
            List<Horse> list = new ArrayList<>();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Horses cannot be empty.", e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}