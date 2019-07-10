import java.util.Random;

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

    static int ProperDivisorsSum(int n) {   // Сумма собственных делителей
        int sum = 0;
        if (n > 1) {
            sum++;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0 && i != n && n / i != n) {
                    if (n / i != i) {   // if divisors are different
                        sum += n / i;   // add both
                    }
                    sum += i;           // if equal, add only one
                }
            }
        }
        return sum;
    }

    static int ProperDivisorsCount(int n) { // Количество собственных делителей
        int count = 0;
        if (n > 1) {
            count++;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0 && i != n && n / i != n) {
                    if (n / i != i) {   // if divisors are different
                        count++;        // add both
                    }
                    count++;            // if equal, add only one
                }
            }
        }
        return count;
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

    static boolean isPalindrome(int n) {
        return n == ReverseNumber(n);
    }

    static boolean isPrimeNumber(int n) {
        return ProperDivisorsCount(n) == 1;
    }

    static void PrimeDivisors(int n) {  // Все простые множители
        if (n > 1) {
            if (!isPrimeNumber(n)) { // if input number is not prime
                for (int i = 1; i <= Math.sqrt(n); i++) {
                    if (n % i == 0 && i != n && n / i != n) {
                        if (n / i != i && isPrimeNumber(n / i)) { // if divisors are different
                            System.out.print(n / i + " ");
                        } else {
                            if (isPrimeNumber(i)) {
                                System.out.print(i + " ");
                            }
                        }
                    }
                }
            } else { // if input number is prime by itself
                System.out.print(n);
            }
        }
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

    static int UniqueDigits (int n) { // Works fine for any int, cause the only int with 10 same digits (1111111111)
        int uniqueDigitsCount = 0;    // due specific of the function is determines as 2, which is also consists of
        long digitsCounts = 0;        // 1 exclusive digit.
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

    // 2nd variant
    static int UniqueDigitsByShift (long n) { // Works fine for anything integer
        int uniqueDigitsCount = 0;
        int digitsCounts = 0;
        while (n > 0) {
            digitsCounts |= 0b1 << n % 10;
            n /= 10;
        }
        while (digitsCounts > 0) {
            if ((digitsCounts & 0b1) == 1) {
                uniqueDigitsCount++;
            }
            digitsCounts >>= 1;
        }
        return uniqueDigitsCount;
    }

    /* 3) Натуральное число называют совершенным, если оно равно сумме всех своих
    делителей, не считая только его самого (например, 28=1+2+3+7+14 –
    совершенное число). Напишите программу, которая проверяет, является ли
    введённое натуральное число совершенным. Для проверки работоспособности
    программы приводится список некоторых совершенных чисел: 6, 28, 496, 8128. */

    static boolean isPerfectNumber(int n) {
        return n == ProperDivisorsSum(n);
    }

    /* 4) Дружественные числа — два различных натуральных числа , для которых
    сумма всех собственных делителей первого числа равна второму числу и
    наоборот, сумма всех собственных делителей второго числа равна первому
    числу. Дружественные числа были открыты последователями Пифагора ,
    которые, однако, знали только одну пару дружественных чисел – 220 и 284.
    Найдите все дружественные числа в заданном диапазоне. */

    static void AmicableNumbersInRange (int start, int end) {
        for (int i = start; i <= end; i++) {
            int divisorsSum = ProperDivisorsSum(i);
            for (int j = i + 1; j <= end && i != j; j++) {
                if (divisorsSum == j && ProperDivisorsSum(j) == i ) {
                    System.out.println("Numbers " + i + " and " + j + " are amicable.");
                }
            }
        }
    }


    public static void main (String[] args) {

        // 1
        System.out.println("\nTask #1 (Heads & Tales)");
        int iterations = 1000;
        int heads = HeadsOrTales(iterations, true);
        int tales = iterations - heads;
        System.out.println( heads + " Heads");
        System.out.println( tales + " Tales" );
        System.out.println( "out of " + iterations + " iteration(s)" );

        // 2
        int inputNumber = 12721;
        System.out.println( "\nTask #2" );
        System.out.println( "INPUT:           " + inputNumber );
        System.out.println( "Largest digit:   " + LargestDigit(inputNumber) );
        System.out.println( "Palindrome:      " + isPalindrome(inputNumber) );
        System.out.println( "Prime (простое): " + isPrimeNumber(inputNumber) );
        System.out.print( "Prime divisors:  " );
        PrimeDivisors(inputNumber);
        System.out.println();
        System.out.println( UniqueDigits(inputNumber) + " exclusive digits" );
        System.out.println();
        int GCDInputNumber1 = 1071;
        int GCDInputNumber2 = 462;
        System.out.println( "INPUT:           " + GCDInputNumber1 + " " + GCDInputNumber2 );
        System.out.println( "GCD (НОД):       " + GCD(GCDInputNumber1, GCDInputNumber2) );
        System.out.println( "GCD (НОК):       " + LCM(GCDInputNumber1, GCDInputNumber2) );

        // 3
        System.out.println("\nTask #3 (Совершенное число)");
        System.out.println( "1:    " + isPerfectNumber(1) );
        System.out.println( "6:    " + isPerfectNumber(6) );
        System.out.println( "28:   " + isPerfectNumber(28) );
        System.out.println( "496:  " + isPerfectNumber(496) );
        System.out.println( "8128: " + isPerfectNumber(8128) );

        // 4
        int rangeBeg = 0;
        int rangeEnd = 140000;
        System.out.println("\nTask #4 (Дружественные числа [в диапазоне " + rangeBeg + " - " + rangeEnd + "])");
        AmicableNumbersInRange(rangeBeg, rangeEnd);
    }
}