package Difficulty_6;

import java.util.Scanner;

public class number58 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(toRim(a));
    }

    public static String toRim(int x) {
        if (x < 1 || x > 3999) return "неверное число";//ошибка ввода (0 не было в римских цифрах)
        String str = "";//итоговая строка (ответ в римских цифрах)
        switch ((int) x / 1000) {
            case (3):
                str += "MMM";
                break;
            case (2):
                str += "MM";
                break;
            case (1):
                str += "M";
                break;
            default:
                break;
        }//добавление к строке цифр в зависимости от целой части деления введенного числа на 1000
        x = x % 1000;//сокращаем число на 1 цифру
        switch ((int) x / 100) {
            case (9):
                str += "CM";
                break;
            case (8):
                str += "DCCC";
                break;
            case (7):
                str += "DCC";
                break;
            case (6):
                str += "DC";
                break;
            case (5):
                str += "D";
                break;
            case (4):
                str += "CD";
                break;
            case (3):
                str += "CCC";
                break;
            case (2):
                str += "CC";
                break;
            case (1):
                str += "C";
                break;
            default:
                break;
        }// -//- на 100
        x = x % 100;//сокращаем на 1 цифру
        switch ((int) x / 10) {
            case (9):
                str += "XC";
                break;
            case (8):
                str += "LXXX";
                break;
            case (7):
                str += "LXX";
                break;
            case (6):
                str += "LX";
                break;
            case (5):
                str += "L";
                break;
            case (4):
                str += "XL";
                break;
            case (3):
                str += "XXX";
                break;
            case (2):
                str += "XX";
                break;
            case (1):
                str += "X";
                break;
            default:
                break;
        }// -//- на 10
        x = x % 10;//сокращаем на 1 цифру
        switch (x) {
            case (9):
                str += "IX";
                break;
            case (8):
                str += "VIII";
                break;
            case (7):
                str += "VII";
                break;
            case (6):
                str += "VI";
                break;
            case (5):
                str += "V";
                break;
            case (4):
                str += "IV";
                break;
            case (3):
                str += "III";
                break;
            case (2):
                str += "II";
                break;
            case (1):
                str += "I";
                break;
            default:
                break;
        }// -//- в зависимости от оставшейся последней цифры числа
        return str;
    }
}
