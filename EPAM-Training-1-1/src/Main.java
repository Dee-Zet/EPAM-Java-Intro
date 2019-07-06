public class Main {

    /* 1) Разработайте программу, которая проверяет, что числа a, b и c различны (одинаковы). */

    public static boolean abcEqual (int a, int b, int c) {
        return (a == b) && (a == c);
    }


    /* 2) Масса динозавра задаётся в килограммах. Разработайте программу, которая
    вычисляет, сколько это миллиграмм, грамм и тонн. */

    public static long KilosToMiligrams (int kilos) {
        return (long)kilos * 1000000;
    }

    public static int KilosToGrams (int kilos) {
        return kilos * 1000;
    }

    public static float KilosToTones (int kilos) {
        return (float)kilos / 1000;
    }


    /* 3) На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2).
    Разработайте программу нахождения площади кольца, внешний радиус которого равен
    R1, а внутренний радиус равен R2. */

    public static double RingSquare (double R1, double R2) {
        if (R1 < 0 || R2 < 0 || R1 <= R2 ) {
            return 0;
        } else {
            double S1 = Math.PI * R1 * R1;
            double S2 = Math.PI * R2 * R2;
            return S1 - S2;
        }
    }


    /* 4) Разработайте программу, которая проверяет, что цифры четырёхзначного
    числа N образуют возрастающую (убывающую) последовательность (к примеру,
    число 1357 удовлетворяет условию, т.к. его цифры соответствуют следующему
    неравенству: 1 > 3 > 5 > 7, т.е. идут в порядке возрастания). */

    public static boolean DigitsSorted (int n) {
        n = Math.abs(n);
        int mod = n % 10;
        n /= 10;
        if (n % 10 > mod) {                     // determining if sequence of digits is raising or falling
            while (n % 10 > mod) {
                mod = n % 10;
                n /= 10;
            }
        } else {
            while (n % 10 < mod) {
                mod = n % 10;
                n /= 10;
            }
        }
        return n == 0;                          // true if all digits were handled
    }


    /* 5) Написать программу, которая находит арифметическое и геометрическое среднее цифр шестизначного числа N. */

    public static float DigitsArithmeticMean (int n) {
        n = Math.abs(n);

        if (n < 10) {
            return n;                           // sequence of 1 digit is average of itself
        }

        int sum = n % 10;
        int i = 1;
        while (n > 10) {
            n /= 10;
            sum += n % 10;
            i++;
        }
        return (float)sum / i;
    }

    public static double DigitsGeometricMean (int n) {
        n = Math.abs(n);

        if (n < 10) {
            return n;
        }

        int product = n % 10;
        int i = 1;
        while (n > 10) {
            n /= 10;
            product *= n % 10;
            i++;
        }
        return Math.pow(product, 1f/i);
    }


    /* 6) Написать программу, которая переворачивает (реверсирует) семизначное
    число N (к примеру, число 1234567 реверсируется в число 7654321). */

    public static int ReverseNumber (int n) {
        if (Math.abs(n) < 10) {                 // no need to reverse if it's 1 digit number
            return n;
        }

        boolean negative = false;               // to keep original sign
        if (n < 0) {
            n = Math.abs(n);
            negative = true;
        }

        int reversedN = n % 10;
        while (n > 10) {
            n /= 10;
            reversedN *= 10;
            reversedN += n % 10;
        }
        return negative? -reversedN : reversedN;
    }


    /* 7) Разработайте небольшую цельную программу, которая меняет местами
    содержимое двух целочисленных переменных a и b, не используя для этого
    дополнительных переменных. */

    private static void PrintTwoInts (int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static void SwitchAB () {
        int a = 32524;
        int b = 9;
        System.out.println("Vars before swap:");
        PrintTwoInts(a, b);

        a += b;
        b = a - b;
        a -= b;

        System.out.println("Vars after swap:");
        PrintTwoInts(a, b);
    }


    private static void RunTest() {
        System.out.println("Task #1");
        Test.abcEqual();
        System.out.println("Test Passed!");

        System.out.println("\nTask #2");
        Test.kilosToMiligrams();
        Test.kilosToGrams();
        Test.kilosToTones();
        System.out.println("Test Passed!");

        System.out.println("\nTask #3");
        Test.ringSquare();
        System.out.println("Test Passed!");

        System.out.println("\nTask #4");
        Test.digitsSorted();
        System.out.println("Test Passed!");

        System.out.println("\nTask #5");
        Test.digitsArithmeticMean();
        Test.digitsGeometricMean();
        System.out.println("Test Passed!");

        System.out.println("\nTask #6");
        Test.reverseNumber();
        System.out.println("Test Passed!");

        System.out.println("\nTask #7");
        SwitchAB();
        System.out.println("\nJob Done!");
    }

    public static void main(String[] args) {
        RunTest();
    }
}
