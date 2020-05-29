package Difficulty_2;
import java.util.Scanner;

public class number17 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(isValid(a));
    }

    public static boolean isValid(String x) {
        boolean y = true;
        if (x.length() == 5) {
            for (int i = 0; i < x.length(); i++) {
                if (Character.isDigit(x.charAt(i))) continue;
                else {
                    y = false;
                    break;
                }
            }

        }
        else y = false;
        return y;
    }
}
