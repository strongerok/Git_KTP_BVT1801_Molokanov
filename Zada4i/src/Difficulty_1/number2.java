package Difficulty_1;
import java.util.Scanner;

public class number2 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int b = scanner.nextInt();
        System.out.println(triArea(a, b));
    }

    public static int triArea(int x, int y) {//функция для нахождения площади треугольника через высоту и основание
        return x*y/2;
    }
}
