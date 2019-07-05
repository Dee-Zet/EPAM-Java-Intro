import java.util.HashSet;

public class Main {

    /* 1) На прямоугольной декартовой системе координат на плоскости заданы три
    точки с соответствующими координатами в виде пары значений (x,y).
    Определить, являются ли данные точки вершинами треугольника. И если да, то
    дополнительно определить, является ли данный треугольник прямоугольным. */

    private static final double DELTA = 1e-9;

    public static boolean TriangleVertex (double x1, double y1, double x2, double y2, double x3, double y3) {
        return !(Math.abs((y1 - y2) * (x1 - x3) - (y1 - y3) * (x1 - x2)) <= DELTA); //points not collinear
    }

    public static boolean RightTriangleVertex (double x1, double y1, double x2, double y2, double x3, double y3) {
        if (TriangleVertex(x1, y1, x2, y2, x3, y3)) {
            double sideA = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
            double sideB = (x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2);
            double sideC = (x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1);

            //Now need to compare the largest side with two other sides.
            //Using float delta is needed. E.g. 1e-9 (0.000000001).
            if (sideA >= sideB && sideA >= sideC) {
                return Math.abs(sideA - sideB - sideC) <= DELTA;
            } else
            if (sideB >= sideA && sideB >= sideC) {
                return Math.abs(sideB - sideA - sideC) <= DELTA;
            } else {
                return Math.abs(sideC - sideA - sideB) <= DELTA;
            }
        } else {
            return false;
        }
    }


    /* 2) В молодом возрасте дракон каждый год отращивает по три головы, но после
    того, как ему исполнится 200 лет – только по две, а после 300 лет – лишь по
    одной. Предполагается, что дракон появляется на свет сразу с тремя головами.
    Разработайте программу, которая высчитывала бы, сколько голов и глаз у
    дракона, которому N лет? */

    private static final int HEADS_BY_BIRTH = 3;
    private static final int HEADS_BY_200YS = 600 + HEADS_BY_BIRTH;
    private static final int HEADS_BY_300YS = 800 + HEADS_BY_BIRTH;

    public static int DragonHeadsCount (int age) {
        if (age < 0) {
            return 0;
        } else
        if (age > 300) {
            return HEADS_BY_300YS + (age - 300);
        } else
        if (age > 200) {
            return HEADS_BY_200YS + (age - 200);
        } else {
            return age * 3 + HEADS_BY_BIRTH;
        }
    }

    public static int DragonEyesCount (int age) {
        return DragonHeadsCount(age) * 2;
    }


    /* 3) Напишите программу, которая бы определяла, является ли введённая буква
    (символ) гласной (постарайтесь сделать минимум четырьмя способами,
    разрешается и больше). */

    private static final char [] VOWELS = {'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};
    private static final HashSet<Character> vowelSet = new HashSet<>();

    public static boolean VowelByArrayLoop (char c) {
        c = Character.toUpperCase(c);
        for (char vowel: VOWELS) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    public static boolean VowelByComparing(char c) {
        c = Character.toUpperCase(c);
        return (c == 'А') || (c == 'О') || (c == 'И') || (c == 'Е') || (c == 'Ё') ||
               (c == 'Э') || (c == 'Ы') || (c == 'У') || (c == 'Ю') || (c == 'Я');
    }

    public static boolean VowelBySwitch (char c) {
        switch (Character.toUpperCase(c)) {
            case 'А':
            case 'О':
            case 'И':
            case 'Е':
            case 'Ё':
            case 'Э':
            case 'Ы':
            case 'У':
            case 'Ю':
            case 'Я':
                return true;
            default:
                return false;
        }
    }

    public static boolean VowelBySet (char c) {
        return vowelSet.contains(Character.toUpperCase(c));
    }


    /* 4) Заданы три целых числа, которые задают некоторую дату по Грегорианскому
    календарю (https://ru.wikipedia.org/wiki/Григорианский_календарь). Определить
    дату следующего дня. Запрещается использовать типы стандартной библиотеки
    языка для работы с датой и временем. Также необходимо учесть то, что по
    григорианскому календарю (используется в настоящий момент) високосный год
    определяется следующим образом:
             годы, кратные 4 – високосные (например, 2008, 2012, 2016);
             годы, кратные 4 и 100 – невисокосные (например, 1700, 1800, 1900);
             годы, кратные 4, 100 и 400 – високосные (например, 1600, 2000, 2400). */

    public static boolean LeapYear (int year) {
        if (year % 4 != 0) {
            return false;
        } else
        if (year % 100 != 0) {
            return true;
        } else {
            return year % 400 == 0;
        }
    }

    public static int MonthMaxDay (int month, boolean leapYear) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (leapYear) ? 29 : 28;
            default: return 31;
        }
    }

    public static int [] NextDayDate(int day, int month, int year) {
        if (day < 1 || month < 1 || month > 12) {
            return null;
        }
        int maxDay = MonthMaxDay(month, LeapYear(year));
        if (day > maxDay) return null;
        if (++day > maxDay) {
            day = 1;
            if (++month > 12) {
                month = 1;
                year++;
            }
        }
        return new int[] {day, month, year};
    }


    private static void RunTest() {
        System.out.println("Task #1");
        Test.triangleVertex();
        Test.rightTriangleVertex();
        System.out.println("Test Passed!");

        System.out.println("\nTask #2");
        Test.dragonHeadsCount();
        Test.dragonEyesCount();
        System.out.println("Test Passed!");

        System.out.println("\nTask #3");
        for (char vowel: VOWELS) {
            vowelSet.add(vowel);
        }
        Test.vowel();
        System.out.println("Test Passed!");

        System.out.println("\nTask #4");
        Test.nextDayDate();
        System.out.println("Test Passed!");
    }

    public static void main(String[] args) {
        RunTest();
    }
}
