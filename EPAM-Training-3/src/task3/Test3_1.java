package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test3_1 {

    @Test
    public void findVectorMinValueId() {
        assertEquals(2, Task3_1.findVectorMinValueId(new double[] {2,1,-1}));
    }

    @Test
    public void findVectorMaxValueId() {
        assertEquals(0, Task3_1.findVectorMaxValueId(new double[] {2,1,-1}));
    }

    @Test
    public void findVectorMean() {
        assertEquals(0.666, Task3_1.findVectorMean(new double[] {2, 1, -1}, Task3_1.mean_type.ARITHMETIC), 0.01);

        assertEquals(-1.26, Task3_1.findVectorMean(new double[] {2, 1, -1}, Task3_1.mean_type.GEOMETRIC), 0.01);
        assertEquals(1.26, Task3_1.findVectorMean( new double[] {2, 1, 1, 1.26}, Task3_1.mean_type.GEOMETRIC), 0.01);
        assertEquals(Float.NaN, Task3_1.findVectorMean(new double[] {2, 1, -1, 1.26}, Task3_1.mean_type.GEOMETRIC), 0);
    }

    @Test
    public void isVectorSorted() {
        assertFalse(Task3_1.isVectorSorted(new double[] {1, 2, 1}));
    }

    @Test
    public void findVectorLocalMinId() {
        assertEquals(-1, Task3_1.findVectorLocalMinId(new double[] {1,1,1,2,1}));
        assertEquals(1, Task3_1.findVectorLocalMinId( new double[] {1,-1,1,2,1}));
    }

    @Test
    public void findVectorLocalMaxId() {
        assertEquals(3, Task3_1.findVectorLocalMaxId(new double[] {1, 1, 1, 2, 1}));
    }

    @Test
    public void linearVectorSearch() {
        assertEquals(1, Task3_1.linearVectorSearch( new double[] {1, 3, 3}, 3));
        assertEquals(-1, Task3_1.linearVectorSearch(new double[] {1, 3, 3}, 2));
    }

    @Test
    public void binaryVectorSearch() {
        assertEquals(1, Task3_1.binaryVectorSearch(new double[] {1, 3, 3}, 3));
    }

    @Test
    public void reverseVector() {
        double[] array2Reverse = {1, 2, 3};
        Task3_1.reverseVector(array2Reverse);
        assertArrayEquals(new double[] {3, 2, 1}, array2Reverse, 0.01);
    }

    @Test
    public void bubbleSort(){
        double[] array2RSort = {53, 68, 23, 35, 25, 75, 1, 2};
        Task3_1.bubbleSort(array2RSort);
        assertArrayEquals(new double[] {1, 2, 23, 25, 35, 53, 68, 75}, array2RSort, 0.01);
    }

    @Test
    public void insertionSort() {
        double[] array2RSort = {53, 68, 23, 35, 25, 75, 1, 2};
        Task3_1.insertionSort(array2RSort);
        assertArrayEquals(new double[] {1, 2, 23, 25, 35, 53, 68, 75}, array2RSort, 0.01);
    }

    @Test
    public void selectionSort() {
        double[] array2RSort = {53, 68, 23, 35, 25, 75, 1, 2};
        Task3_1.selectionSort(array2RSort);
        assertArrayEquals(new double[] {1, 2, 23, 25, 35, 53, 68, 75}, array2RSort, 0.01);
    }

    @Test
    public void mergeSort() {
        double[] array2RSort = {53, 68, 23, 35, 25, 75, 1, 2};
        Task3_1.mergeSort(array2RSort);
        assertArrayEquals(new double[] {1, 2, 23, 25, 35, 53, 68, 75}, array2RSort, 0.01);
    }

    @Test
    public void quickSort() {
        double[] array2RSort = {53, 68, 23, 25, 25, 75, 1, 2};
        Task3_1.quickSort(array2RSort);
        assertArrayEquals(new double[] {1, 2, 23, 25, 25, 53, 68, 75}, array2RSort, 0.01);
    }
}
