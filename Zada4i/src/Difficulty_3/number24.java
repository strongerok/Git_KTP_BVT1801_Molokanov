package Difficulty_3;
import java.util.Scanner;

public class number24 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(FlipEndChars(a));
    }

    public static String FlipEndChars(String x) {
        if (x.length() < 2) return "несовместимо.";
        else if (x.charAt(0) == x.charAt(x.length() - 1)) return "два - это пара.";
        else {
            String b = "";
            String[] symbols = x.split("");
            String a = symbols[0];
            symbols[0] = symbols[x.length() - 1];
            symbols[x.length() - 1] = a;
            for (String symbol : symbols) b +=symbol;
            return b;
        }
    }
}
