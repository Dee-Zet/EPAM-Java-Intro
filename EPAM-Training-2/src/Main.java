import java.util.Random;
import java.util.ArrayList;

public class Main {

    private static final Random random = new Random();

    static int ReverseNumber (int n) {   //from the first task
        int reversedN = n % 10;
        while (n > 10) {
            n /= 10;
            reversedN *= 10;
            reversedN += n % 10;
        }
        return reversedN;
    }

    static int Sum (ArrayList<Integer> adds) {
        int sum = 0;
        for (int i : adds) {
            sum = sum + i;
        }
        return sum;
    }

    static ArrayList<Integer> ProperDividers (int n) {
        ArrayList<Integer> dividers = new ArrayList<>();
        if (n > 1) {
            dividers.add(1);
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0 && i != n && n / i != n) {
                    // If divisors are equal, add only one
                    if (n / i == i) {
                        dividers.add(i);
                    } else { // Otherwise add both
                        dividers.add(i);
                        dividers.add(n / i);
                    }
                }
            }
        }
        return dividers;
    }

    /* 1) Необходимо написать программу «Heads or Tails?» («Орёл или решка?»),
    которая бы «подбрасывала» условно монету, к примеру, 1000 раз и сообщала,
    сколько раз выпал орёл, а сколько – решка. */

    static int HeadsOrTales (int count, boolean needHeads) {
        int heads = 0;
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                heads++;
            }
        }
        if (needHeads) {
            return heads;
        }
        else {
            return count - heads;
        }
    }

    /* 2) Разработать наиболее эффективные алгоритмы и написать код для решения
    следующих задач:
             найти наибольшую цифру натурального числа; \/
             проверить, является ли заданное натуральное число палиндромом; \/
             определить является ли заданное натуральное число простым; \/
             найти все простые делители заданного натурального числа; \/
             найти НОД и НОК двух натуральных чисел a и b.
             найти количество различных цифр у заданного натурального числа. \/ */

    static int LargestDigit (int n) {
        int largestDigit = 0;
        while (n > 0) {
            if (n % 10 > largestDigit) {
                largestDigit = n % 10;
            }
            n /= 10;
        }
        return largestDigit;
    }

    static boolean Palindrome (int n) {
        return n == ReverseNumber(n);
    }

    static boolean PrimeNumber (int n) {
        if (n > 1) {
            return ProperDividers(n).size() == 1;
        } else {
            return false;
        }
    }

    static ArrayList<Integer> PrimeDividers (int n) {
        ArrayList<Integer> primeDividers = new ArrayList<>();
        if (n > 1) {
            for (int divider : ProperDividers(n)) {
                if (PrimeNumber(divider)) {
                    primeDividers.add(divider);
                }
            }
            if (PrimeNumber(n)) {
                primeDividers.add(n);
            }
        }
        return primeDividers;
    }

    static int GCD (int a, int b) { //HOD
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    static int LCM (int a, int b) { //HOK
        return  a * b / GCD(a, b);
    }

    static int UniqueDigits (int n) {
        int uniqueDigitsCount = 0;
        long digitsCounts = 0;
        while (n > 0) {
            digitsCounts += Math.pow(10, n % 10);
            n /= 10;
        }
        while (digitsCounts > 0) {
            if (digitsCounts % 10 > 0) {
                uniqueDigitsCount++;
            }
            digitsCounts /= 10;
        }
        return uniqueDigitsCount;
    }

    /* 3) Натуральное число называют совершенным, если оно равно сумме всех своих
    делителей, не считая только его самого (например, 28=1+2+3+7+14 –
    совершенное число). Напишите программу, которая проверяет, является ли
    введённое натуральное число совершенным. Для проверки работоспособности
    программы приводится список некоторых совершенных чисел: 6, 28, 496, 8128. */

    static boolean PerfectNumber (int n) {
        return n == Sum(ProperDividers(n));
    }

    /* 4) Дру́жественные чи́сла — два различных натуральных числа , для которых
    сумма всех собственных делителей первого числа равна второму числу и
    наоборот, сумма всех собственных делителей второго числа равна первому
    числу. Дружественные числа были открыты последователями Пифагора ,
    которые, однако, знали только одну пару дружественных чисел – 220 и 284.
    Найдите все дружественные числа в заданном диапазоне. */

    static boolean NumbersAmicable (int n1, int n2) {
        return n1 == Sum(ProperDividers(n2)) && n2 == Sum(ProperDividers(n1));
    }


    public static void main(String[] args) {

        // 1
        int iterations = 1000;
        int heads = HeadsOrTales(iterations, true);
        int tales = iterations - heads;
        System.out.println( "Heads: " + heads );
        System.out.println( "Tales: " + tales );

        // 2
        System.out.println( LargestDigit(12742) );
        System.out.println( Palindrome(12721) );
        System.out.println( Palindrome(12742) );
        System.out.println( PrimeNumber(12742) );
        System.out.println( PrimeDividers(12742) );
        System.out.println( GCD(1071, 462) );
        System.out.println( LCM(16, 20) );
        System.out.println( UniqueDigits(12742) );
        System.out.println( UniqueDigits(1111111111) );
        /*for (int i = 0; i < 200; i++) {
            if (PrimeNumber(i))
                System.out.println( i );
        }*/

        // 3
        System.out.println("\nTask #3");
        System.out.println( PerfectNumber(1) );
        System.out.println( PerfectNumber(6) );
        System.out.println( PerfectNumber(28) );
        System.out.println( PerfectNumber(496) );
        System.out.println( PerfectNumber(8128) );

        // 4
        System.out.println("\nTask #4");
        System.out.println( NumbersAmicable(220, 284) );
    }
}
