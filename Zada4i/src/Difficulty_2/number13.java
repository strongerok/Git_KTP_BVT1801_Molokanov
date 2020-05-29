package Difficulty_2;
import java.util.Scanner;

public class number13 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите длину массива");
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int[] ArrayInt = new int[a];//объявление массива
        System.out.println("заполните массив");
        for (int i = 0; i<a; i++) ArrayInt[i] = scanner.nextInt();//цикл для заполнения массива числами
        System.out.println(isAvgWhole(ArrayInt));
    }

    public static boolean isAvgWhole(int[] x) {//функция, возвращающая true или false в зависимости от того, целое число или нет
        double S = 0;
        for (int i = 0; i < x.length; i++) {//цикл для подсчета суммы элементов массива
            S += x[i];
        }
        S = S/ x.length;//среднее значение
        if (S % 1 == 0) return true;
        else return false;
    }
}
