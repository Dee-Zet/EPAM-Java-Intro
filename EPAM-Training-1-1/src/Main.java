public class Main {

    /* 1) Разработайте программу, которая проверяет, что числа a, b и c различны (одинаковы). */

    public static boolean abcEqual (int a, int b, int c)
    {
        if ((a == b) && (a == c)) return true;
        return false;
    }


    /* 2) Масса динозавра задаётся в килограммах. Разработайте программу, которая
    вычисляет, сколько это миллиграмм, грамм и тонн. */

    public static long KilosToMiligrams (int kilos)
    {
        return (long)kilos * 1000000;
    }

    public static int KilosToGrams (int kilos)
    {
        return kilos * 1000;
    }

    public static float KilosToTones (int kilos)
    {
        return (float)kilos / 1000;
    }


    /* 3) На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2).
    Разработайте программу нахождения площади кольца, внешний радиус которого равен
    R1, а внутренний радиус равен R2. */

    public static double RingSquare (int R1, int R2)
    {
        double S1 = Math.PI * R1 * R1;
        double S2 = Math.PI * R2 * R2;
        return S1 - S2;
    }


    /* 4) Разработайте программу, которая проверяет, что цифры четырёхзначного
    числа N образуют возрастающую (убывающую) последовательность (к примеру,
    число 1357 удовлетворяет условию, т.к. его цифры соответствуют следующему
    неравенству: 1 > 3 > 5 > 7, т.е. идут в порядке возрастания). */

    public static boolean DigitsSorted (int n)
    {
        int mod = n % 10;
        n /= 10;
        if (mod == n % 10) return false;

        boolean asc = true;
        if (n % 10 > mod) asc = false;
        while (n > 10) {
            mod = n % 10;
            n /= 10;
            if (asc) {
                if (n % 10 >= mod) return false;
            } else {
                if (n % 10 <= mod) return false;
            }
        }
        return true;
    }


    /* 5) Написать программу, которая находит арифметическое и геометрическое среднее цифр шестизначного числа N. */

    public static float DigitsArithmeticMean (int n)
    {
        int sum = n % 10;
        int i = 1;
        while (n > 10) {
            n /= 10;
            sum += n % 10;
            i++;
        }
        return (float)sum / i;
    }

    public static double DigitsGeometricMean (int n)
    {
        int product = n % 10;
        int i = 1;
        while (n > 10) {
            n /= 10;
            product *= n % 10;
            i++;
        }
        return Math.pow(product, 1.0/i);
    }


    /* 6) Написать программу, которая переворачивает (реверсирует) семизначное
    число N (к примеру, число 1234567 реверсируется в число 7654321). */

    public static int ReverseNumber (int n)
    {
        int result = n % 10;
        while (n > 10) {
            n /= 10;
            result *= 10;
            result += n % 10;
        }
        return result;
    }


    /* 7) Разработайте небольшую цельную программу, которая меняет местами
    содержимое двух целочисленных переменных a и b, не используя для этого
    дополнительных переменных. */

    public static void SwitchAB ()
    {
        a += b;
        b = a - b;
        a -= b;
    }


    static int a = 0;  // Globals to swap
    static int b = 0;  // in the task #7.

    public static void main(String[] args)
    {
        System.out.println("Task #1");
        System.out.println("Expected true; Got " + abcEqual(5145, 5145, 5145));
        System.out.println("Expected true; Got " + abcEqual(0, 0, 0));
        System.out.println("Expected false; Got " + abcEqual(2341, 3251, 1242));
        System.out.println("Expected false; Got " + abcEqual(1, 1, 2));

        System.out.println("\nTask #2");
        System.out.println("Expected 5700000000; Got " + KilosToMiligrams(5700));
        System.out.println("Expected 5700000; Got " + KilosToGrams(5700));
        System.out.println("Expected 5.7; Got " + KilosToTones(5700));

        System.out.println("\nTask #3");
        System.out.println("Expected 21.99; Got " + RingSquare(4, 3));

        System.out.println("\nTask #4");
        System.out.println("Expected true; Got " + DigitsSorted(1357));
        System.out.println("Expected true; Got " + DigitsSorted(7531));
        System.out.println("Expected false; Got " + DigitsSorted(1355));
        System.out.println("Expected false; Got " + DigitsSorted(5743));

        System.out.println("\nTask #5");
        System.out.println("Expected 3.5; Got " + DigitsArithmeticMean(123456));
        System.out.println("Expected 2.99; Got " + DigitsGeometricMean(123456));

        System.out.println("\nTask #6");
        System.out.println("Expected 4323475; Got " + ReverseNumber(5743234));

        System.out.println("\nTask #7");
        a = 32524;
        b = 9;
        SwitchAB();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
