package Difficulty_3;
import java.util.Scanner;

public class number23 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(checkPerfect(a));
    }

    public static boolean checkPerfect(int x) {
        int[] decimals = new int[100];//не понял, возможно ли задать массив без длины. задал большую длину, с запасом
        int n = 0;
        int Sum = 0;
        for (int i = 1; i < x; i++) {//цикл для нахождения делителей числа и записи их в массив
            if (x % i == 0) {
                decimals[n] = i;
                n += 1;
            }
        }
        for (int j = 0; j <= n; j++) Sum += decimals[j];//суммирование всех делителей числа
        return Sum == x;
    }
}
