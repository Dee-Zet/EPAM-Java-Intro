package task3;

import org.apache.log4j.Logger;

import java.util.Arrays;

class Task3_1 {

    private static final Logger log = Logger.getLogger(Task3_1.class);

    // Задан вектор размера N. Необходимо выполнить следующие действия:

    /* найти индекс экстремального значения (минимальный и максимальный
    элементы) данного вектора, если таких элементов нет, то возвратить -1; */

    static int findVectorMinValueId (double[] vector) {
        if (vector.length == 0) {
            log.debug("Input array length = 0");
            return -1;
        }

        log.debug("Input array: " + Arrays.toString(vector));

        double minValue = vector[0];
        int valueId = -1;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < minValue) {
                minValue = vector[i];
                valueId = i;
            } else if (vector[i] == minValue) {
                valueId = -1;
            }
        }
        log.debug("Array min value = " + valueId);
        return valueId;
    }

    static int findVectorMaxValueId (double[] vector) {
        if (vector.length == 0) {
            log.debug("Input array length = 0");
            return -1;
        }

        log.debug("Input array: " + Arrays.toString(vector));

        double maxValue = vector[0];
        int valueId = -1;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > maxValue) {
                maxValue = vector[i];
                valueId = i;
            } else if (vector[i] == maxValue) {
                valueId = -1;
            }
        }
        log.debug("Array min value = " + valueId);
        return valueId;
    }

    /* найти среднеарифметическое и среднегеометрическое значения всех
    элементов вектора; */

    enum mean_type {ARITHMETIC, GEOMETRIC}

    static double findVectorMean (double[] vector, mean_type type) {
        if (vector.length > 0) {
            log.debug("Input array: " + Arrays.toString(vector));
            switch (type) {
                case ARITHMETIC:
                    double sum = 0;
                    for (double value : vector) {
                        sum += value;
                    }
                    return sum / vector.length;
                case GEOMETRIC:
                    double prod = 1;
                    for (double value : vector) {
                        if (value == 0) {   // when any element = 0,
                            return 0;       // then product and geometric mean = 0
                        }
                        prod *= value;
                    }

                    if (prod < 0) {
                        if (vector.length % 2 == 1) {
                            return -Math.pow(-prod, 1f / vector.length);
                        } else {                        // if product is negative and numbers count is even
                            return Double.NaN;          // it's impossible to replace all numbers with one average
                        }
                    }
                    return Math.pow(prod, 1f / vector.length);
            }
        }
        log.debug("Input array length = 0");
        return Double.NaN;
    }

    /* проверить, находятся ли все элементы вектора в упорядоченном виде (т.е.
    отсортированы ли элементы по возрастанию или убыванию); */

    static boolean isVectorSorted (double[] vector) {
        if (vector.length == 0) {
            log.debug("Input array length = 0");
            return false;
        }
        log.debug("Input array: " + Arrays.toString(vector));

        if (vector.length < 3) {
            return true;
        }

        int i = 1;
        while (i < vector.length && vector[i - 1] == vector[i]) {
            i++;
        }
        if (i == vector.length) { // true if array was completely handled and consists of same elements
            return true;
        }
        if (vector[i - 1] > vector[i]) { // compares first different elements
            i++;
            while (i < vector.length && vector[i - 1] >= vector[i]) { // sequence is keeping to descend
                i++;
            }
        }
        else {
            i++;
            while (i < vector.length && vector[i - 1] <= vector[i]) { // sequence is keeping to ascend
                i++;
            }
        }
        return i == vector.length; // true means that array was handled to the end, and all elements are sorted
    }

    /* найти позицию первого встретившегося локального минимума (максимума), а
    если таких элементов нет, то возвратить -1 (локальный минимум это элемент,
    который меньше любого из своих соседей; локальный максимум – это элемент,
    который больше любого из своих соседей); */

    static int findVectorLocalMinId (double[] vector) {
        if (vector.length < 3) {
            return -1;
        }
        log.debug("Input array: " + Arrays.toString(vector));

        int stopId = vector.length - 1;
        for (int i = 1; i < stopId; i++) {
            if (vector[i] < vector[i-1] && vector[i] < vector[i+1]) {
                return i;
            }
        }
        return -1;
    }

    static int findVectorLocalMaxId (double[] vector) {
        if (vector.length < 3) {
            return -1;
        }
        log.debug("Input array: " + Arrays.toString(vector));

        int stopId = vector.length - 1;
        for (int i = 1; i < stopId; i++) {
            if (vector[i] > vector[i-1] && vector[i] > vector[i+1]) {
                return i;
            }
        }
        log.debug("Vector passed. No appropriate result");
        return -1;
    }

    /* реализовать для элементов вектора два алгоритма поиска: линейный или
    последовательный (linear or sequential search) и двоичный или бинарный (binary
    search); */

    static int linearVectorSearch (double[] vector, double queryValue) {
        log.debug("Input array: " + Arrays.toString(vector) + " Search query: " + queryValue);
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == queryValue) {
                return i;
            }
        }
        log.debug("Vector passed. No appropriate result");
        return -1;
    }

    static int binaryVectorSearch (double[] vector, double queryValue) { // finds leftmost
        log.debug("Input array: " + Arrays.toString(vector) + " Search query: " + queryValue);
        int LeftBnd = 0;
        int RightBnd = vector.length;
        while (LeftBnd < RightBnd) {
            int middleId = (LeftBnd + RightBnd) / 2;
            if (vector[middleId] < queryValue) {
                LeftBnd = middleId + 1;
            } else {
                RightBnd = middleId;
            }
        }
        return (LeftBnd < vector.length && vector[LeftBnd] == queryValue) ? LeftBnd : -1;
    }

    /* реверсировать все элементы вектора (при решении данного задания не
    рекомендуется задействовать дополнительную память); */

    static void reverseVector (double[] vector) {
        log.debug("Input array: " + Arrays.toString(vector));
        int stopId = vector.length / 2;
        int lastId = vector.length - 1;
        for (int i = 0; i < stopId; i++) {
            double t = vector[i];
            vector[i] = vector[lastId - i];
            vector[lastId - i] = t;
        }
        log.debug("Output array: " + Arrays.toString(vector));
    }

    /* реализовать несколько алгоритмов сортировок элементов вектора по
    возрастанию и убыванию (рекомендуется для реализации как минимум
    следующие: сортировка обменом или пузырьковая сортировка (bubble sort), а
    также её улучшенные версии; сортировка вставками (insertion sort); сортировка
    выбором (selection sort); сортировка слиянием (merge sort) и быстрая сортировка (quick sort). */

    static void bubbleSort (double[] vector) {
        int N = vector.length;
        do {
            int newN = 0;
            for (int i = 1; i < N; i++) {
                if (vector[i - 1] > vector[i]) {
                    double buf = vector[i];
                    vector[i] = vector[i-1];
                    vector[i-1] = buf;
                    newN = i;
                }
            }
            N = newN;
        } while (N > 0);
    }

    static void insertionSort (double[] vector) {
        int i = 1;
        while (i < vector.length) {
            int j = i;
            while (j > 0 && vector[j-1] > vector[j]) {
                double buf = vector[j];
                vector[j] = vector[j-1];
                vector[j-1] = buf;
                j--;
            }
            i++;
        }
    }

    static void selectionSort (double[] vector) {
        for (int i = 0; i < vector.length - 1; i++)
        {
            int min = i;
            for (int j = i + 1; j < vector.length; j++)
            {
                if (vector[j] < vector[min])
                {
                    min = j;
                }
            }

            if (min != i)
            {
                double buf = vector[i];
                vector[i] = vector[min];
                vector[min] = buf;
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    static void mergeSort (double[] vector) { // method for calling without specifying array bounds
        if (vector.length > 1) {
            mergeSort(vector, 0, vector.length - 1);
        }
    }

    private static void mergeSort (double[] vector, int bgn, int end) { // private method for recursion
        if (bgn < end)
        {
            // Find the middle point
            int mid = (bgn + end) / 2;

            // Sort first and second halves
            mergeSort(vector, bgn, mid);
            mergeSort(vector , mid + 1, end);

            // Merge the sorted halves
            merge(vector, bgn, mid, end);
        }
    }

    private static void merge(double[] vector, int bgn, int mid, int end)
    {
        double [] L = Arrays.copyOfRange(vector, bgn, mid + 1);
        double [] R = Arrays.copyOfRange(vector, mid + 1, end + 1);

        int i = 0;                  // Initial indexes of first
        int j = 0;                  // and second subarrays

        int k = bgn;                // Initial index of merged subarray array
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                vector[k] = L[i];
                i++;
            } else {
                vector[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < L.length) {      // Copy remaining elements of L[] if there are any
            vector[k] = L[i];
            i++;
            k++;
        }

        while (j < R.length) {      // Copy remaining elements of R[] if there are any
            vector[k] = R[j];
            j++;
            k++;
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    static void quickSort (double[] vector) { // method for calling without specifying array bounds
        if (vector.length > 1) {
            int p = qsPartition(vector, 0, vector.length - 1);
            quickSort(vector, 0, p - 1);
            quickSort(vector, p + 1, vector.length - 1);
        }
    }

    private static void quickSort (double[] vector, int lo, int hi) { // private method for recursion
        if (lo < hi) {
            int p = qsPartition(vector, lo, hi);
            quickSort(vector, lo, p - 1);
            quickSort(vector, p + 1, hi);
        }
    }

    private static double qsPivot (double[] vector, int lo, int hi) { // finds median-of-3 pivot
        double buf = 0;
        int mid = (lo + hi) / 2;
        if (vector[mid] < vector[lo]) {
            buf = vector[lo];
            vector[lo] = vector[mid];
            vector[mid] = buf;
        }
        if (vector[hi] < vector[lo]) {
            buf = vector[lo];
            vector[lo] = vector[hi];
            vector[hi] = buf;
        }
        if (vector[mid] < vector[hi]) {
            buf = vector[hi];
            vector[hi] = vector[mid];
            vector[mid] = buf;
        }
        return vector[hi];
    }

    private static int qsPartition (double[] vector, int lo, int hi) {
        double pivot = qsPivot(vector, lo, hi); // choosing median-of-3 pivot
        for (; ; lo++, hi--) {
            while (vector[lo] < pivot) {
                lo++;
            }
            while (vector[hi] > pivot) {
                hi--;
            }

            if (lo >= hi) {
                return hi;
            }

            double buf = vector[lo];
            vector[lo] = vector[hi];
            vector[hi] = buf;
        }
    }

    enum sort_type {BUBBLE, INSERTION, SELECTION, MERGE, QUICK}

    static void sortVector (double[] vector, sort_type type) {
        switch (type) {
            case BUBBLE: bubbleSort(vector); break;
            case INSERTION: insertionSort(vector); break;
            case SELECTION: selectionSort(vector); break;
            case MERGE: mergeSort(vector); break;
            case QUICK: quickSort(vector); break;
        }
    }
}
