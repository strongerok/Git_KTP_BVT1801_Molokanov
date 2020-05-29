package Difficulty_4;
import java.util.Scanner;

import static java.lang.Character.*;

public class number33 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите строку");
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println("введите 1, если хотите перевести текст в CamelCase и 2, если в SnakeCase");
        int b = scanner.nextInt();
        if (b == 1) System.out.println(toCamelCase(a));
        else if (b == 2) System.out.println(toSnakeCase(a));
        else System.out.println("вы не ввели ни 1, ни 2");
    }

    public static String toCamelCase(String x) {
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '_') {//если встретилось "_"
                x = x.substring(0,i) + toUpperCase(x.charAt(i+1)) + x.substring(i+2);/*х становится равной сумме частей
                строк: с 0 символа до _ не включая + переведенный в заглавный символ после _ + оставшаяся строка*/
            }
        }
        return x;
    }

    public static String toSnakeCase(String x) {
        for (int i = 0; i < x.length(); i++) {
            if (isUpperCase(x.charAt(i))) {//если встретилась заглавная буква
                x = x.substring(0, i) + "_" + toLowerCase(x.charAt(i)) + x.substring(i+1);/*х становится равной сумме
                 частей строк: с 0 символа до заглавного i не включая + _ +переведенный в строчный символ i + оставшаяся строка*/
            }
        }
        return x;
    }
}
