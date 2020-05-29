package Difficulty_1;
import java.util.Scanner;

public class number4 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        double a = scanner.nextDouble();//переменные, в которых записывается считавшееся значение
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        if (ProfitableGamble(a, b, c)) {//вывод ответа в зависимости от значения функции ProfitableGamble
            System.out.println("подходит");
        }
        else System.out.println("не подходит");
    }

    public static boolean ProfitableGamble(double prob, double prize, double pay) {/*функция, выводящая значение в зависимости
        от верности выражения*/
        return prob * prize > pay;
    }

}
