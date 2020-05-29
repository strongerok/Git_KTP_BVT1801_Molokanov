package Difficulty_1;
import java.util.Scanner;

public class number5 {

    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println (HowCanWeGetIt(a, b, c));
    }

    public static String HowCanWeGetIt(int x, int y, int z) {//функция выводящая способ получения z из х и у
        if (x+y == z) return "сложить";
        else if (x-y == z) return "вычесть";
        else if (x*y == z) return "умножить";
        else if (x/y == z) return "разделить";
        else return "никак";
    }
}
