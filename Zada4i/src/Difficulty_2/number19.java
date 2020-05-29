package Difficulty_2;
import java.util.Scanner;

public class number19 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите слово");
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        while (a.equals("")) {
            System.out.println("вы не ввели слово");
            a = scanner.nextLine();
        }//чтобы пользователь не вводил пустую строку
        System.out.println("введите префикс- или -постфикс (минус обязателен для распознавания)");
        String b = scanner.nextLine();
        while (b.equals("")) {
            System.out.println("вы не ввели префикс или постфикс");
            b = scanner.nextLine();
        }
        if (b.charAt(0) == '-') System.out.println(isSuffix(a, b));//проверка положения "-" в префиксе/постфиксе
        else if (b.charAt(b.length() - 1) == '-') System.out.println(isPrefix(a, b));
        else System.out.println("вы не ввели '-' в начале (для постфикса) или конце (для префикса) слова");
    }

    public static boolean isPrefix(String x, String y) {//функция для проверки префикса
        y = y.substring(0, y.length() - 1);
        return x.contains(y) && x.charAt(0) == y.charAt(0);
    }

    public static boolean isSuffix(String x, String y) {//функция для проверки постфикса
        y = y.substring(1);
        return x.contains(y) && x.charAt(x.length() - 1) == y.charAt(y.length() - 1);
    }
}
