package Difficulty_3;
import java.util.Arrays;
import java.util.Scanner;

public class number26 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите длину 1 массива");
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int[] ArrayInt1 = new int[a];//объявление массива
        System.out.println("заполните 1 массив");
        for (int i = 0; i<a; i++) ArrayInt1[i] = scanner.nextInt();//цикл для заполнения массива числами

        System.out.println("введите длину 2 массива");
        int b = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int[] ArrayInt2 = new int[a];//объявление массива
        System.out.println("заполните 2 массив");
        for (int i = 0; i<b; i++) ArrayInt2[i] = scanner.nextInt();//цикл для заполнения массива числами

        System.out.println(SameUniqueNumbers(ArrayInt1, ArrayInt2));
    }
    public static int HowMuchUniqueNumbers(int[] x) {
        int count = 0;
        for  (int j = 0; j <= 218; j++){
            for (int i = 0; i < x.length; i++) {
                if (x[i] == j) {
                    count += 1;
                    break;
                }
                else continue;
            }
        }
        return count;
    }//функция, подсчитывающая количество уникальных чисел в массиве
    public static boolean SameUniqueNumbers(int[] x, int[] y) {
        return HowMuchUniqueNumbers(x) == HowMuchUniqueNumbers(y);//функция, сравнивающая количество уникальных чисел 2 массивов
    }
}
