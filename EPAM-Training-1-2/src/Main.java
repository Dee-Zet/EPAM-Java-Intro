import java.util.HashSet;

public class Main {

    /* 1) На прямоугольной декартовой системе координат на плоскости заданы три
    точки с соответствующими координатами в виде пары значений (x,y).
    Определить, являются ли данные точки вершинами треугольника. И если да, то
    дополнительно определить, является ли данный треугольник прямоугольным. */

    public static boolean TriangleVertex (int x1, int y1, int x2, int y2, int x3, int y3) { return true; }

    public static boolean RightTriangleVertex (int x1, int y1, int x2, int y2, int x3, int y3) {
        return true;
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
        if (age < 0) return 0;
        if (age > 300) return HEADS_BY_300YS + (age - 300);
        if (age > 200) return HEADS_BY_200YS + (age - 200);
        return age * 3 + HEADS_BY_BIRTH;
    }

    public static int DragonEyesCount (int age) {
        return DragonHeadsCount(age) * 2;
    }


    /* 3) Напишите программу, которая бы определяла, является ли введённая буква
    (символ) гласной (постарайтесь сделать минимум четырьмя способами,
    разрешается и больше). */

    private static final char [] VOWELS = {'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};

    public static boolean VowelByArrayLoop (char c) {
        c = Character.toUpperCase(c);
        for (char vowel: VOWELS) {
            if (c == vowel) return true;
        }
        return false;
    }

    public static boolean VowelByIf (char c) {
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
        HashSet<Character> vowelSet = new HashSet<>();
        for (char vowel: VOWELS) vowelSet.add(vowel);
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
        if (year % 4 != 0) return false;
        if (year % 100 != 0) return true;
        if (year % 400 != 0) return false;
        return true;
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
        if (day < 1 || month < 1 || month > 12) return null;
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


    public static void main(String[] args) {
        System.out.println("Task #2");
        Test.dragonHeadsCount();
        Test.dragonEyesCount();
        System.out.println("Test Passed!");

        System.out.println("\nTask #3");
        Test.vowel();
        System.out.println("Test Passed!");

        System.out.println("\nTask #4");
        Test.nextDayDate();
        System.out.println("Test Passed!");
    }
}
