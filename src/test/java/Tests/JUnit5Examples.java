package Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Examples {
    @Test
    void fistTest() {
        System.out.println("###       @Test fistTest() !");
        assertTrue(3 > 2);

    }
}
