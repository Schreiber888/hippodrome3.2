import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @Timeout(22)
    void main() throws InterruptedException {
        Thread.sleep(2);
    }
}