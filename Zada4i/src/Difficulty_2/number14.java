package Difficulty_2;
import java.util.Arrays;
import java.util.Scanner;

public class number14 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите длину массива");
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int[] ArrayInt = new int[a];//объявление массива
        System.out.println("заполните массив");
        for (int i = 0; i<a; i++) ArrayInt[i] = scanner.nextInt();//цикл для заполнения массива числами
        System.out.println(Arrays.toString(SuperSum(ArrayInt)));
    }

    public static int[] SuperSum(int[] x){//функция, выводящая в качестве результата массив с просуммированными эл-тами
        int Sum = 0;
        for (int i = 0; i< x.length; i++) {//цикл для получения новых элементов
            Sum += x[i];
            x[i] = Sum;
        }
        return x;
    }
}
