package Difficulty_3;
import java.util.Scanner;

public class number29 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите целое число");
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(nextPrime(a));
    }

    public static boolean isPrime(int x) {
        //счетчик числа делителей
        int count = 0;
        int i = 2;
        while (i < x) {//поиск делителей числа от 2 до х-1 (т.к. 1 и х делители любого числа х)
            if (x % i == 0) count++;
            i++;
        }
        return count == 0;
    }//функция, определяющая, введенное число простое или нет

    public static int nextPrime(int x) {
        while (!isPrime(x)) x++;//пока число не простое прибавляем к числу единицу и проверяем заново
        return x;
    }
}
