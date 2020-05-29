package Difficulty_2;
import java.util.Scanner;

public class number12 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите длину массива");
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int[] ArrayInt = new int[a];//объявление массива
        System.out.println("заполните массив");
        for (int i = 0; i<a; i++) ArrayInt[i] = scanner.nextInt();//цикл для заполнения массива числами
        System.out.println(diffMaxMin(ArrayInt));
    }

    public static int diffMaxMin(int[] x) {
        int max = -218;//(границы диапазона int)
        int min = 218;//можно брать диапазон шире (типо long) и брать значения больше
        for (int i = 0; i < x.length; i++) {
            if (x[i] < min) min = x[i];
            if (x[i] > max) max = x[i];
        }
        return max - min;
    }
}