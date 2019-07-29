package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test3_2 {

    double[][] matrix = {
            {2, 4, 3},
            {5, 1, 4},
            {3, 3, 2}
    };

    @Test
    public void findMatrixMinValue() {
        assertEquals(1, Task3_2.findMatrixMinValue(matrix), 0.01);
    }

    @Test
    public void findMatrixMaxValue() {
        assertEquals(5, Task3_2.findMatrixMaxValue(matrix), 0.01);
    }

    @Test
    public void findMatrixMean() {
        assertEquals(3, Task3_2.findMatrixMean(matrix, Task3_1.mean_type.ARITHMETIC), 0.01);
    }

    @Test
    public void isSymmetricMatrix() {
        assertFalse(Task3_2.isSymmetricMatrix(matrix));
    }

    @Test
    public void findMatrixLocalMinId() {
        assertArrayEquals(new int[] {1, 1}, Task3_2.findMatrixLocalMinId(matrix));
    }

    @Test
    public void findMatrixLocalMaxId() {
        assertArrayEquals(new int[] {-1, -1}, Task3_2.findMatrixLocalMaxId(matrix));
    }

    @Test
    public void transposeMatrix() {
        double[][] matrix2Transpose = {
                {2, 4, 3},
                {5, 1, 4},
                {3, 3, 2}
        };
        Task3_2.transposeMatrix(matrix2Transpose);
        assertArrayEquals(
            new double[][] {
                    {2, 5, 3},
                    {4, 1, 3},
                    {3, 4, 2}
            }, matrix2Transpose
        );
    }
}