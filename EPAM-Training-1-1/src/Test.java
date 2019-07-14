import static org.junit.jupiter.api.Assertions.*;

class Test {

    static void abcEqual() {
        assertTrue(Main.abcEqual(5145, 5145, 5145));
        assertTrue(Main.abcEqual(0, 0, 0));
        assertFalse(Main.abcEqual(2341, 3251, 1242));
        assertFalse(Main.abcEqual(1, 1, 2));
    }

    static void kilosToMiligrams() {
        assertEquals(5700000000L, Main.KilosToMiligrams(5700));
    }

    static void kilosToGrams() {
        assertEquals(5700000, Main.KilosToGrams(5700));
    }

    static void kilosToTones() {
        assertEquals(5.7, Main.KilosToTones(5700), 0.01);
        assertEquals(2f, Main.KilosToTones(2000), 0.01);
    }

    static void ringSquare() { // Takes floats. If radius is negative or R1 <= R2 returns 0.
        assertEquals(21.99, Main.RingSquare(4, 3), 0.01);
    }

    static void digitsSorted() { // Takes positive/negative int
        assertTrue(Main.DigitsSorted(1357));
        assertTrue(Main.DigitsSorted(7531));
        assertTrue(Main.DigitsSorted(43210));
        assertTrue(Main.DigitsSorted(10));
        assertTrue(Main.DigitsSorted(1));
        assertFalse(Main.DigitsSorted(1355));
        assertFalse(Main.DigitsSorted(5743));
        assertFalse(Main.DigitsSorted(100));
        assertFalse(Main.DigitsSorted(11));
    }

    static void digitsArithmeticMean() { // Takes positive/negative int
        assertEquals(3.5, Main.DigitsArithmeticMean(123456), 0.01);
        assertEquals(2, Main.DigitsArithmeticMean(-13), 0.01);
    }

    static void digitsGeometricMean() { // Takes positive/negative int
        assertEquals(2.99, Main.DigitsGeometricMean(123456), 0.01);
        assertEquals(4.76, Main.DigitsGeometricMean(349), 0.01);
        assertEquals(4, Main.DigitsArithmeticMean(-44), 0.01);
        assertEquals(4, Main.DigitsArithmeticMean(-4), 0.01);
    }

    static void reverseNumber() { // Takes ints. Works with negative numbers too (keeps sign). E.g. (-123) -> (-321)
        assertEquals(4323475, Main.ReverseNumber(5743234));
        assertEquals(75, Main.ReverseNumber(57));
        assertEquals(-75, Main.ReverseNumber(-57));
    }
}