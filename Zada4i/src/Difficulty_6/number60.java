package Difficulty_6;

import java.util.Scanner;

public class number60 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(PalindromeDescendant(a));
    }

    public static boolean PalindromeDescendant(int x) {
        boolean checker = false;
        int count = 0;//число в котором суммирую цифры числа х
        String str = Integer.toString(x);
        if (isPalindrome(str)) checker = true;//проверка введенного числа на палиндром
        else while (x > 9) {//если не палиндром, то пока х не однозначное число
            for (int i = 0; i < str.length(); i++) {//для каждой цифры числа
                count += x % (10);//беру правую цифру и складываю
                x /= 10;//уменьшаю х на 1 цифру справа
            }
            if (count > 9) {//если сумма цифр больше 9 (не тривиальны палиндром)
                str = Integer.toString(count);
                if (isPalindrome(str)) {//проверка суммы цифр на палиндром
                    checker = true;
                    break;//если палиндром - дальше не ищем
                }
                x = count;//иначе - сумма цифр - наше новое число
                count = 0;//обнуляем, чтобы считать сумму цифр нового числа
            }
        }
        return checker;//вывод - палиндром ли число или его предки до тривиального (однозначного)
    }

    public static boolean isPalindrome(String x) {//проверка числа на палиндром
        boolean checker = true;//проверка
        if (x.length() % 2 == 0)//если длина числа четная
        for (int i = 0; i < x.length()/2; i++) {//проверка первой половины цифр
            if (!(x.charAt(i) == x.charAt(x.length() - i - 1))) {//на равенство соответствующей цифре с другого конца
                checker = false;//если не равно
                break;
            } }
        else for (int i = 0; i < (x.length() - 1)/2; i++) {//если длина числа нечетная
                if (!(x.charAt(i) == x.charAt(x.length() - i - 1))) {//проверяем до середины числа (не включая, т.к. цифра посередине не влияет)
                    checker = false;//если не равно
                    break;
                } }
        return checker;//вывод палиндром или нет
    }
}
