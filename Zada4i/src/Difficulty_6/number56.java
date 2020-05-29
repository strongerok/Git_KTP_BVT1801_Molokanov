package Difficulty_6;

import java.util.Arrays;
import java.util.Scanner;
//программа крайне неэффективна по времени и памяти (на моем компьютере программа для х = 206 выполняется 26сек), но лучше решения я не нашел
public class number56 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(ulam(a));
    }

    public static long ulam(int x) {
        if (x <= 0) return 0;//тривиальные случаи
        if (x == 1) return 1;
        if (x == 2) return 2;
        long[] Numbers = new long[x];//массив чисел Улама
        Numbers[0] = 1;//первые числа
        Numbers[1] = 2;
        int i = 2;//счетчик цикла while
        while (i < x) {
            Numbers[i] = nextUlam(Numbers, i-1);//добавляем к последовательности следующее число Улама
            i++;
        }
        return Numbers[i-1];
    }

    public static long nextUlam(long[] x, int k) {
        long[] Sum = new long[(int) ((Math.pow(x.length,2)-x.length)/2)];//массив сумм всех чисел введенного массива длиной в количество этих сумм
        long min = 10000;//начальное значение минимальной суммы
        int t = 0;//счетчик для заполнения массива сумм
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {//заполнение массива сумм, с помощью циклов for
                Sum[t] = x[i] + x[j];
                t+=1;
            }
        }
        boolean checker = false;//проверка совпадающих сумм в последовательности
        for (int i = 0; i < Sum.length; i++) {
            for (int j = i+1; j < Sum.length; j++) {
                if (Sum[i] == Sum[j]) {
                    checker = true;
                    Sum[j] = 0;//обнуление суммы совпавшей с проверяемой
                }
            }
            if (checker) Sum[i] = 0;//обнуление проверяемой суммы, если было совпадение (такая сумма нам не подходит ибо повторяется)
            checker = false;//возвращаю проверятор :) в начальное положение (0)
        }
        for (long value : Sum) {//для оставшихся сумм (не повторяющихся)
            if (value < min & value > x[k]) min = value;//если сумма меньше минимума и больше предыдущего числа Улама, то минимум = этой сумме
        }
        return min;//возвращаю минимальную сумму
    }
}
