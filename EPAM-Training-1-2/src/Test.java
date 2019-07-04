import static org.junit.jupiter.api.Assertions.*;

class Test {

    void triangleVertex() {
        //assertEquals(0, Main.TriangleVertex());
    }

    static void rightTriangleVertex() {
        assertTrue(Main.RightTriangleVertex(1, 1, -2, -5, 3, 0));
        assertFalse(Main.RightTriangleVertex(2, 2, 3, -1, -3, -2));
    }

    static void dragonHeadsCount() {
        assertEquals(0, Main.DragonHeadsCount(-1));
        assertEquals(3, Main.DragonHeadsCount(0));
        assertEquals(6, Main.DragonHeadsCount(1));
        assertEquals(1466, Main.DragonHeadsCount(963));
    }

    static void dragonEyesCount() {
        assertEquals(0, Main.DragonEyesCount(-1));
        assertEquals(6, Main.DragonEyesCount(0));
        assertEquals(12, Main.DragonEyesCount(1));
        assertEquals(2932, Main.DragonEyesCount(963));
    }

    static void vowel() {
        assertTrue(Main.VowelByArrayLoop('о'));
        assertFalse(Main.VowelByArrayLoop('Г'));

        assertTrue(Main.VowelBySwitch('о'));
        assertFalse(Main.VowelBySwitch('Г'));

        assertTrue(Main.VowelByComparing('о'));
        assertFalse(Main.VowelByComparing('Г'));

        assertTrue(Main.VowelBySet('о'));
        assertFalse(Main.VowelBySet('Г'));
    }

    static void nextDayDate() {
        assertArrayEquals(new int[] {1, 1, 2019}, Main.NextDayDate(31,12,2018));
        assertArrayEquals(new int[] {29, 2, 2016}, Main.NextDayDate(28,2,2016));
        assertArrayEquals(new int[] {1, 3, 2016}, Main.NextDayDate(29,2,2016));
        assertArrayEquals(new int[] {1, 7, 2019}, Main.NextDayDate(30,6,2019));
        assertArrayEquals(null, Main.NextDayDate(29,2,1900));
    }
}