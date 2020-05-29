package Difficulty_5;

import java.util.Scanner;

public class number43 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        String b = scanner.nextLine();
        System.out.println(canComplete(a, b));
    }

    public static boolean canComplete(String x, String y) {
        String str = "";//строка, в которую записываются совпадающие символы
        String x1 = x;//переменная, в которой хранится значение х (т.к. я буду изменять х)
        for (int i = 0; i < y.length(); i++) {//цикл, который берет каждую букву дополняемого слова
            for ( int j = 0; j < x.length (); j++) {// -//- дополняющего слова
                if (x.charAt(j) == y.charAt(i)) {
                    str+=x.charAt(j);/*если символы совпали, добавляю этот символ к итоговой строке(порядок сохраняется
                    т.к. я внешний цикл для дополняемого слова => перебор идет по порядку)*/
                    x= x.substring(j+1);/*удаляю встретившийся символ, чтобы его не посчитало 2 раза, если в дополняемом
                    слове есть одинаковые буквы*/
                    break;
                }
            }
        }
        return str.equals(x1);
    }
}
