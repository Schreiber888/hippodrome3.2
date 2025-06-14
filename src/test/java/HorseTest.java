import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @BeforeEach
    void setUp() {
        Horse horse;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void constructorNullNameHorseTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2));
    }

    @Test
    public void constructorNullNameHorseExceptionMessageTest() {
        try {
            new Horse(null, 2);
        } catch (Exception e) {
            Assertions.assertEquals("Name cannot be null.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   ", "     "})
    public void constructorIllegalNameHorseTest(String strings) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(strings, 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   ", "     "})
    public void constructorIllegalNameHorseExceptionMessageTest(String strings) {
        try {
            new Horse(strings, 2);
        } catch (Exception e) {
            Assertions.assertEquals("Name cannot be blank.", e.getMessage());
        }
    }

    @Test
    public void constructorNegativeSpeedHorseTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Any", -1));
    }

    @Test
    public void constructorNegativeSpeedHorseExceptionMessageTest() {
        try {
            new Horse("Any", -1);
        } catch (Exception e) {
            Assertions.assertEquals("Speed cannot be negative.", e.getMessage());
        }
    }

    @Test
    public void constructorNegativeDistanceHorseTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Any", 2, -1));
    }

    @Test
    public void constructorNegativeDistanceHorseExceptionMessageTest() {
        try {
            new Horse("Any", 2, -1);
        } catch (Exception e) {
            Assertions.assertEquals("Distance cannot be negative.", e.getMessage());
        }
    }

    @Test
    void getNameTest() {
        Horse horse = new Horse("Any", 2, 5.1);
        Assertions.assertEquals(horse.getName(), "Any");
    }

    @Test
    void getSpeedTest() {
        Horse horse = new Horse("Any", 2, 5.1);
        Assertions.assertEquals(horse.getSpeed(), 2);
    }

    @Test
    void getDistanceTest() {
        Horse horse = new Horse("Any", 2, 5.1);
        Assertions.assertEquals(horse.getDistance(), 5.1);
    }

    @Test
    void getWithoutDistanceInConstructorTest(){
        Horse horse = new Horse("Any", 2);
        Assertions.assertEquals(horse.getDistance(), 0);
    }

    @Test
    void moveTest() {
    }

    @Test
    void getRandomDoubleTest() {
    }
}