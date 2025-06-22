import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    private static Horse horse;

    @BeforeEach
    void setUp()
    {
         horse = new Horse("Any", 2, 5.1);;
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
        Assertions.assertEquals(horse.getName(), "Any");
    }

    @Test
    void getSpeedTest() {
        Assertions.assertEquals(horse.getSpeed(), 2);
    }

    @Test
    void getDistanceTest() {
        Assertions.assertEquals(horse.getDistance(), 5.1);
    }

    @Test
    void getWithoutDistanceInConstructorTest(){
        Horse horse = new Horse("Any", 2);
        Assertions.assertEquals(horse.getDistance(), 0);
    }


    @Test
    void moveCallMethodTest() {
        Horse horse = new Horse("Any", 2, 123);
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            horse.move();
            mockedHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.3, 0.4, 0.5})
    void moveCallMethodWithParameterTest(double parameter) {
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            mockedHorse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(parameter);
            double actualDistance = horse.getDistance() + horse.getSpeed()*parameter;
            horse.move();
            Assertions.assertEquals(horse.getDistance(), actualDistance);
        }
    }

   @Test
    void getRandomDoubleTest() {
    }
}