package Difficulty_2;
import java.util.Scanner;

public class number20 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(SnakeStep(a));
    }

    public static int SnakeStep(int x) {//функция нахождения числа клеток на шаге х. назвал так из-за схожести со змейкой
        int y = 0;
        if (x == 0) return y;
        else if ((x % 2) == 1) return y = x + 2;//заметил закономерность, что для нечетных чисел всегда квадратов = шаг + 2
        else if ((x % 2) == 0) return y = x;//для четных: квадратов = шаг
        else return y;//не знаю как вывести строковую ошибку, поэтому для отрицательных значений шагов также вывожу 0
    }
}