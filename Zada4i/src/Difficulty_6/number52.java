package Difficulty_6;

import java.util.Scanner;

public class number52 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(PigLatin(a));
    }

    public static String PigLatin(String x) {
        if (IsVowel(x.charAt(0))) x += "yay";//если 1 символ - гласный
        else for (int i = 0; i < x.length(); i++) {//если нет
            if (IsVowel(x.charAt(i))) {//когда символ гласный
                x = x.substring(i) + x.substring(0, i);
                x += "ay";
                break;
             }
        }
        return x;
    }

    public static boolean IsVowel(char x) {//функция, проверяющая текущий символ на то, гласный он или нет
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o'
                    || x == 'u' || x == 'y') return true;
        else return false;
    }
}
