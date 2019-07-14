package task3;
import java.util.Arrays;

import static task3.Task3_1.*;
import static task3.Task3_1.mean_type.*;
import static task3.Task3_2.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(findVectorMinValueId(new double[]{2,1,-1}));
        System.out.println(findVectorMean(new double[]{2,1,-1}, GEOMETRIC));
        System.out.println(isVectorSorted(new double[]{1,2,1}));
        System.out.println(findVectorLocalMaxId(new double[]{1,1,1,2,1}));
        double[] a = {1,2,3};
        reverseVector(a);
        System.out.println(Arrays.toString(a));
        System.out.println(linearVectorSearch(new double[]{1,3,3}, 3));
        System.out.println(binaryVectorSearch(new double[]{1,3,3}, 3));
        double[] b = {53,68,23,35,25,75,1,2};
        //sortVector(b, sort_type.BUBBLE);
        //quicksort(b);
        //selectionSort(b);
        //insertionSort(b);
        mergeSort(b);
        System.out.println(Arrays.toString(b));

        double[][] matrix = {
                {2, 4, 3},
                {5, 1, 4},
                {3, 3, 2}
        };

        System.out.println(findMatrixMean(matrix, ARITHMETIC));
        System.out.println(findMatrixMean(matrix, GEOMETRIC));
        System.out.println(Arrays.toString(findMatrixLocalMinId(matrix)));
        System.out.println(Arrays.toString(findMatrixLocalMaxId(matrix)));

        transposeMatrix(matrix);
        for (double[] str : matrix)
            System.out.println(Arrays.toString(str));
    }
}
