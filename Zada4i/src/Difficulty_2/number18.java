package Difficulty_2;
import java.util.Scanner;

public class number18 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите 1 строку");
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println("введите 2 строку");
        String b = scanner.nextLine();
        System.out.println(isStrangePair(a, b));
    }

    public static boolean isStrangePair(String x, String y) {
        if (x.equals("") && y.equals("")) return true;//чтобы выводило true на 2 пустых строки
        else {
            char a = x.charAt(0);
            char b = x.charAt(x.length() - 1);//записываю последние и первые символы строк в переменные
            char c = y.charAt(0);
            char d = y.charAt(y.length() - 1);
            return a == d && b == c;//сравниваю их
        }
    }
}
