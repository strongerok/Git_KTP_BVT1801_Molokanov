package Difficulty_3;
import java.util.Scanner;

public class number30 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите стороны треугольника");
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(isRightTriangle(a, b, c));
    }

    public static String isRightTriangle(double x, double y, double z) {
        x = Math.pow(x, 2);
        y = Math.pow(y, 2);
        z = Math.pow(z, 2);
        if ((x + y == z) || (x + z == y) || (y + z == x)) return "треугольник прямоугольный";
        else return "треугольник не прямоугольный";
    }
}
