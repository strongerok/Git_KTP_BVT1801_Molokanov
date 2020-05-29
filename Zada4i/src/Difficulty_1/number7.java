package Difficulty_1;
import java.util.Scanner;

public class number7 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        System.out.println(addUpTo(a));
    }

    public static int addUpTo(int x) {//функция, выводящая сумму всех целых чисел от 1 до х
        return (1+x) / 2 * x;//математическая формула (первое плюс последнее пополам на их количество)
    }
}
