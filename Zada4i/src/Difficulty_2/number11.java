package Difficulty_2;
import java.util.Scanner;

public class number11 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменные, в которых записывается считавшееся слово/число
        int b = scanner.nextInt();
        System.out.println(repeat(a, b));
    }

    public static String repeat(String x, int n) {//функция, выводящая слово, в котором каждая буква повторяется n раз
        String str = "";
        int k = x.length();
        for (int i = 0; i < k; i++) {//цикл, позволяющий работать с каждой буквой отдельно
            for (int j = 0; j < n; j++) {//цикл, позволяющий повторить букву n раз
                str += x.charAt(i);
            }
        }
        return str;
    }
}