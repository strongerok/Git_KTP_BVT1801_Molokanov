package Difficulty_3;
import com.sun.jdi.IntegerValue;

import java.util.Scanner;

public class number27 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(isKaprekar(a));
    }

    public static boolean isKaprekar(int x) {
        //квадрат введенного числа
        var y = x*x;
        //перевод квадрата числа в строчный формат для определения количества цифр
        String z = Integer.toString(y);
        int c;
        int d;
        boolean is = false;
        //цикл проверки для числа с четным количеством цифр
        if (z.length() % 2 == 0) {
                c = (int) ((int) y/Math.pow(10, z.length()/2));//число, состоящее из первой половины цифр
                d =(int) (((y/Math.pow(10, z.length()/2)) - c)*Math.pow(10, z.length()/2));//из второй половины цифр
                if (d != 0) is = c + d == x;
            }
        /*цикл проверки для числа с нечетным количеством цифр(проверка идет в 2 этапа, т.к. число с нечетным количеством
          цифр можно разделить двумя способами)*/
        else {
            c = (int) ((int) y/Math.pow(10, (z.length()+1)/2));//число, состоящее из первой половины цифр
            d =(int) (((y/Math.pow(10, (z.length()+1)/2)) - c)*Math.pow(10, (z.length()+1)/2));//из второй половины цифр
            if (d != 0 & c+d == x) is = true;
            else {
                c = (int) ((int) y/Math.pow(10, (z.length()-1)/2));//число, состоящее из первой половины цифр
                d =(int) (((y/Math.pow(10, (z.length()-1)/2)) - c)*Math.pow(10, (z.length()-1)/2));//из второй половины цифр
                if (d != 0 & c+d == x) is = true;
            }
        }
        return is;
    }
}
