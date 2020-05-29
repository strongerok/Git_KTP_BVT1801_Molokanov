package Difficulty_1;
import java.util.Scanner;

public class number8 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int b = scanner.nextInt();
        System.out.println(maxThirdEdge(a, b));
    }

    public static int maxThirdEdge(int x, int y) {//функция, выдающая максиальное значение 3 стороны треугольника, по остальным двум
        int z = x+y-1;//максимальное значение 3 стороны по 1 теореме треугольника
        while (!(z + x > y && z + y > x)) {//проверка соблюдения 1 теоремы треугольника
                z = z - 1;
        }
        return z;
    }
}