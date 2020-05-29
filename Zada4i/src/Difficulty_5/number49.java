package Difficulty_5;
import static Difficulty_5.number45.StringArrayToString;
import java.util.Scanner;

public class number49 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(correctTitle(a));
    }

    public static String correctTitle(String x) {
        x = x.toLowerCase();
        String[] words = x.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!(words[i].equals("of") || words[i].equals("the") || words[i].equals("and") || words[i].equals("in"))) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
        }
        return StringArrayToString(words);
    }
}
