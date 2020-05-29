package Difficulty_6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class number51 {public static void main(String[] args) {//функция main. здесь выводится результат
    Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
    int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
    System.out.println(Bell(a));
}

    public static int Bell(int x) {
    int[] bellNumbers = new int[x+1];//массив чисел Белла (для рекурсии)
    bellNumbers[0] = 1;
    int bell = 0;
    if (x == 0) bell = 1;
    else {
        int i = 0;
        while (i < x) {
            for (int j = 0; j <= i; j++) bell += C(i - j, i ) * bellNumbers[j];//рекурсивная мат. формула чисел Белла
                bellNumbers[i + 1] = bell;
                bell = 0;
                i++;
        }
    }
        return bellNumbers[bellNumbers.length - 1];
    }

    public static int Factorial(int x) {//функция, находящая факториал числа
    int fact = 1;
    if (x == 0) return fact;
    else for (int i = 1; i <= x; i++) fact *=i;
    return fact;
    }

    public static int C(int x, int z) {//число сочетаний из y по х комбинаций
     return Factorial(z)/(Factorial(z-x)*Factorial(x));
    }

}
