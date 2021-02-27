import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        int actual = Calculator.add(20, 30);
        assertEquals(50, actual);
    }

    @Test
    void testCase1() {
        assertTrue(Calculator.operator.equals("add"));

    }

    @Test
    void testCase2() {
        assertArrayEquals(new int[]{1,2,3}, new int[]{1, 2, 3});
    }

    @Test
    void testCase3() {
        String nullString = null;
        String notNullString = "not null";
        assertNotNull(notNullString);
        assertNull(nullString);
    }

    @Test
    void testCase5() {
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertNotSame(c1, c3);
        assertSame(c1, c2);

    }
}