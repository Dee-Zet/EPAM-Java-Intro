package task3;
import static task3.Task3_1.*;

class Task3_2 {
    // Задана матрица размера N x M. Необходимо выполнить следующие действия:

    // найти экстремальные значения (минимальный и максимальный элементы) данной матрицы;
    static double findMatrixMinValue (double [][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        boolean repeat = false;
        double minValue = matrix[0][0];                 // had to initialize minValue in function body
        for (int i = 1; i < matrix[0].length; i++) {    // and pass the first string of a matrix
            if (matrix[0][i] < minValue) {
                minValue = matrix[0][i];
                repeat = false;
            } else if (matrix[0][i] == minValue) {
                repeat = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {       // pass the rest of a matrix
            for (double value : matrix[i]) {
                if (value < minValue) {
                    minValue = value;
                    repeat = false;
                } else if (value == minValue) {
                    repeat = true;
                }
            }
        }

        return repeat? -1 : minValue;
    }

    static double findMatrixMaxValue (double [][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        boolean repeat = false;
        double maxValue = matrix[0][0];                 // had to initialize maxValue in function body
        for (int i = 1; i < matrix[0].length; i++) {    // and pass the first string of a matrix
            if (matrix[0][i] > maxValue) {
                maxValue = matrix[0][i];
                repeat = false;
            } else if (matrix[0][i] == maxValue) {
                repeat = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {       // pass the rest of a matrix
            for (double value : matrix[i]) {
                if (value > maxValue) {
                    maxValue = value;
                    repeat = false;
                } else if (value == maxValue) {
                    repeat = true;
                }
            }
        }

        return repeat? -1 : maxValue;
    }

    // найти среднеарифметическое и среднегеометрическое значения всех элементов матрицы;
    static double findMatrixMean (double [][] matrix, mean_type type) {
        if (matrix.length > 0 && matrix[0].length > 0) {
            switch (type) {
                case ARITHMETIC:
                    double sum = 0;
                    for (double[] vector : matrix) {
                        sum += Task3_1.findVectorMean(vector, mean_type.ARITHMETIC);
                    }
                    return sum / matrix.length;
                case GEOMETRIC:
                    double prod = 1;
                    for (double[] vector : matrix) {
                        double vectorMean = Task3_1.findVectorMean(vector, mean_type.GEOMETRIC);
                        if (vectorMean == 0) {  // if   geom. mean of vector = 0,
                            return 0;           // then geom. mean of matrix = 0
                        }
                        prod *= vectorMean;
                    }
                    return Math.pow(prod, 1f / matrix.length);
            }
        }
        return -1;
    }


    // проверить, является ли матрица симметричной относительно главной (или побочной) диагонали.
    static boolean isSymmetricMatrix (double [][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }


    /* найти позицию первого встретившегося локального минимума (максимума), а
    если таких элементов нет, то возвратить (-1;-1) (локальный минимум это
    элемент, который меньше любого из своих соседей; локальный максимум – это
    элемент, который больше любого из своих соседей); */
    static int[] findMatrixLocalMinId (double[][] matrix) {
        if (matrix.length < 3 && matrix[0].length < 3) {
            return new int[] {-1, -1};  // no elements with all known neighbors
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[j].length - 1; j++) {
                if (matrix[i][j] < matrix[i-1][j-1] &&
                    matrix[i][j] < matrix[i-1][j]   &&
                    matrix[i][j] < matrix[i-1][j+1] &&
                    matrix[i][j] < matrix[i][j-1]   &&
                    matrix[i][j] < matrix[i][j+1]   &&
                    matrix[i][j] < matrix[i+1][j-1] &&
                    matrix[i][j] < matrix[i+1][j]   &&
                    matrix[i][j] < matrix[i+1][j+1]) {
                    return new int[] {j, i};
                }
            }
        }
        return new int[] {-1, -1};      // 2-d array has completely passed, so there are no local min
    }

    static int[] findMatrixLocalMaxId (double[][] matrix) {
        if (matrix.length < 3 && matrix[0].length < 3) {
            return new int[] {-1, -1};  // no elements with all known neighbors
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[j].length - 1; j++) {
                if (matrix[i][j] > matrix[i-1][j-1] &&
                    matrix[i][j] > matrix[i-1][j]   &&
                    matrix[i][j] > matrix[i-1][j+1] &&
                    matrix[i][j] > matrix[i][j-1]   &&
                    matrix[i][j] > matrix[i][j+1]   &&
                    matrix[i][j] > matrix[i+1][j-1] &&
                    matrix[i][j] > matrix[i+1][j]   &&
                    matrix[i][j] > matrix[i+1][j+1]) {
                    return new int[] {j, i};
                }
            }
        }
        return new int[] {-1, -1};      // 2-d array has completely passed, so there are no local max
    }


    // транспонировать квадратную матрицу
    static void transposeMatrix (double[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                double buf = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = buf;
            }
        }
    }

}
