import java.util.HashSet;

public class Main {

    /* 1) На прямоугольной декартовой системе координат на плоскости заданы три
    точки с соответствующими координатами в виде пары значений (x,y).
    Определить, являются ли данные точки вершинами треугольника. И если да, то
    дополнительно определить, является ли данный треугольник прямоугольным. */

    public static boolean TriangleVertex (int x1, int y1, int x2, int y2, int x3, int y3) {
        //if ((x1 == x2) & (x1 == x3)) return false;
        //if ((y1 == y2) & (y1 == y3)) return false;
        //if (((x1 == x2) & (y1 == y2)) || ((x1 == x3) & (y1 == y3)) || ((x2 == x3) & (y2 == y3)))
        //    return false;
        return true;
    }

    public static boolean RightTriangleVertex (int x1, int y1, int x2, int y2, int x3, int y3) {
        return true;
    }


    /* 2) В молодом возрасте дракон каждый год отращивает по три головы, но после
    того, как ему исполнится 200 лет – только по две, а после 300 лет – лишь по
    одной. Предполагается, что дракон появляется на свет сразу с тремя головами.
    Разработайте программу, которая высчитывала бы, сколько голов и глаз у
    дракона, которому N лет? */

    public static int DragonHeadsCount (int age) {
        if (age > 300) return 800 + (age - 300) + 3;
        if (age > 200) return 600 + (age - 200) + 3;
        return age * 3 + 3;
    }

    public static int DragonEyesCount (int age) {
        return DragonHeadsCount(age) * 2;
    }


    /* 3) Напишите программу, которая бы определяла, является ли введённая буква
    (символ) гласной (постарайтесь сделать минимум четырьмя способами,
    разрешается и больше). */

    public static boolean VowelByArrayLoop (char c) {
        char [] vowels = new char[] {'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};
        c = Character.toUpperCase(c);

        for (char vowel: vowels) {
            if (c == vowel) return true;
        }
        return false;
    }

    public static boolean VowelByIf (char c) {
        c = Character.toUpperCase(c);
        if ((c == 'А') || (c == 'О') || (c == 'И') || (c == 'Е') || (c == 'Ё') ||
            (c == 'Э') || (c == 'Ы') || (c == 'У') || (c == 'Ю') || (c == 'Я'))
            return true;
        return false;
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
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('А');
        vowels.add('О');
        vowels.add('И');
        vowels.add('Е');
        vowels.add('Ё');
        vowels.add('Э');
        vowels.add('Ы');
        vowels.add('У');
        vowels.add('Ю');
        vowels.add('Я');
        if (vowels.contains(Character.toUpperCase(c))) return true;
        return false;
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

    public static String NextDay(int day, int month, int year) {
        boolean leap = false;
        if (year % 4 == 0) leap = true;

        int maxDay = 0;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;
            case 2:
                maxDay = (leap) ? 29 : 28;
                break;
            default: maxDay = 31;
        }

        if (++day > maxDay) {
            day = 1;
            if (++month > 12) {
                month = 1;
                year++;
            }
        }
        return day + "/" + month + "/" + year;
    }

    public static void Test (Object testFunc, Object input, Object expect) {
        System.out.println("Input: " + input + "\t|\t" +
                           "Expected: " + expect + "\t|\t" +
                           "Actual Result: " + testFunc);
    }

    public static void main(String[] args) {
        System.out.println("Task #2");
        Test(DragonHeadsCount(963), 963, true);
        Test(DragonHeadsCount(0), 0, 3);
        Test(DragonHeadsCount(1), 1, 6);
        Test(DragonEyesCount(963), 963, 2932);
        Test(DragonEyesCount(0), 0, 6);
        Test(DragonEyesCount(1), 1, 12);

        System.out.println("\nTask #3");
        System.out.println("\t\t\t\t\tUsing Array Loop");
        Test(VowelByArrayLoop('о'), 'о', true);
        Test(VowelByArrayLoop('Г'), 'Г', false);
        System.out.println("\t\t\t\t\tUsing If Statement");
        Test(VowelByIf('о'), 'о', true);
        Test(VowelByIf('Г'), 'Г', false);
        System.out.println("\t\t\t\t\tUsing Switch/Case");
        Test(VowelBySwitch('о'), 'о', true);
        Test(VowelBySwitch('Г'), 'Г', false);
        System.out.println("\t\t\t\t\tUsing Set");
        Test(VowelBySet('о'), 'о', true);
        Test(VowelBySet('Г'), 'Г', false);

        System.out.println("\nTask #4");
        System.out.println(NextDay(31,12,2018));
        System.out.println(NextDay(28,2,2016));
        System.out.println(NextDay(29,2,2016));
        System.out.println(NextDay(30,6,2019));
        System.out.println(NextDay(3,7,2019));
    }
}
