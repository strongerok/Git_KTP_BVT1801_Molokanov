package Difficulty_1;
import java.util.Scanner;

public class number9 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите длину массива");
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int[] ArrayOfCubes = new int[a];//объявление массива
        System.out.println("заполните массив");
        for (int i = 0; i<a; i++) ArrayOfCubes[i] = scanner.nextInt();//цикл для заполнения массива числами
        System.out.println(SumOfCubes(ArrayOfCubes));
    }

    public static double SumOfCubes(int[] x) {//функция, выводящая значение суммы кубов чисел из массива
        double Sum = 0;
        for (int value : x) Sum += Math.pow(value, 3);
        return Sum;
    }
}