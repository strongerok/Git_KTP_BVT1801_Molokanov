package Difficulty_5;
import java.util.Scanner;

public class number47 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        if (a.length() > 3) System.out.println("количество цифр больше, чем 3");
        else if (!a.matches("[-+]?\\d+")) System.out.println("вы ввели не цифру");
        else {
            System.out.println(numToEng(a));
            System.out.println(numToRus(a));
        }
    }

    public static String numToEng(String x) {
        String Number = "";
        String[] firstNumber = new String[10];
        firstNumber[0] = "zero"; firstNumber[1] = "one"; firstNumber[2] = "two"; firstNumber[3] = "three"; firstNumber[4] = "four"; firstNumber[5] = "five"; firstNumber[6] = "six"; firstNumber[7] = "seven"; firstNumber[8] = "eight"; firstNumber[9] = "nine";
        String[] firstAndSecondNumber = new String[10];
        firstAndSecondNumber[0] = "ten"; firstAndSecondNumber[1] = "eleven"; firstAndSecondNumber[2] = "twelve"; firstAndSecondNumber[3] = "thirteen"; firstAndSecondNumber[4] = "fourteen"; firstAndSecondNumber[5] = "fifteen"; firstAndSecondNumber[6] = "sixteen"; firstAndSecondNumber[7] = "seventeen"; firstAndSecondNumber[8] = "eighteen"; firstAndSecondNumber[9] = "nineteen";
        String[] SecondNumber = new String[8];
        SecondNumber[0] = "twenty"; SecondNumber[1] = "thirty"; SecondNumber[2] = "forty"; SecondNumber[3] = "fifty"; SecondNumber[4] = "sixty"; SecondNumber[5] = "seventy"; SecondNumber[6] = "eighty"; SecondNumber[7] = "ninety";
        if (x.length() == 3 & Integer.parseInt(x) % 100 == 0) Number = (firstNumber[Integer.parseInt(x)/100] + " hundred");
        else if (x.length() == 3 & Integer.parseInt(x) % 100 != 0) {
            if (Integer.parseInt(x) % 100 > 19 & Integer.parseInt(x) % 10 == 0)
            Number = (firstNumber[Integer.parseInt(x)/100] + " hundred " + SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2]);
            else if (Integer.parseInt(x) % 100 > 19 & Integer.parseInt(x) % 10 != 0)
            Number = (firstNumber[Integer.parseInt(x)/100] + " hundred " + SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2] + " " + firstNumber[Integer.parseInt(x) % 10]);
            else if (Integer.parseInt(x) % 100 <= 19 & Integer.parseInt(x) % 100 > 9)
            Number = (firstNumber[Integer.parseInt(x)/100] + " hundred " + firstAndSecondNumber[Integer.parseInt(x) % 10]);
            else Number = (firstNumber[Integer.parseInt(x)/100] + " hundred " + firstNumber[Integer.parseInt(x) % 10]);
        }
        else if (x.length() == 2 & Integer.parseInt(x) % 10 == 0) Number = (SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2]);
        else if (x.length() == 2 & Integer.parseInt(x) % 10 != 0) {
            if (Integer.parseInt(x) % 100 > 19)
            Number = (SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2] + " " + firstNumber[Integer.parseInt(x) % 10]);
            else Number = (firstAndSecondNumber[Integer.parseInt(x) % 10]);
        }
        else Number = (firstNumber[Integer.parseInt(x) % 10]);
        return Number;
    }

    public static String numToRus(String x) {
        String Number = "";
        String[] firstNumber = new String[10];
        firstNumber[0] = "ноль"; firstNumber[1] = "один"; firstNumber[2] = "два"; firstNumber[3] = "три"; firstNumber[4] = "четыре"; firstNumber[5] = "пять"; firstNumber[6] = "шесть"; firstNumber[7] = "семь"; firstNumber[8] = "восемь"; firstNumber[9] = "девять";
        String[] firstAndSecondNumber = new String[10];
        firstAndSecondNumber[0] = "десять"; firstAndSecondNumber[1] = "одиннадцать"; firstAndSecondNumber[2] = "двенадцать"; firstAndSecondNumber[3] = "тринадцать"; firstAndSecondNumber[4] = "четырнадцать"; firstAndSecondNumber[5] = "пятнадцать"; firstAndSecondNumber[6] = "шестнадцать"; firstAndSecondNumber[7] = "семнадцать"; firstAndSecondNumber[8] = "восемнадцать"; firstAndSecondNumber[9] = "девятнадцать";
        String[] SecondNumber = new String[8];
        SecondNumber[0] = "двадцать"; SecondNumber[1] = "тридцать"; SecondNumber[2] = "сорок"; SecondNumber[3] = "пятьдесят"; SecondNumber[4] = "шестьдесят"; SecondNumber[5] = "семьдесят"; SecondNumber[6] = "восемьдесят"; SecondNumber[7] = "девяносто";
        String[] ThirdNumber = new String[9];
        ThirdNumber[0] = "сто"; ThirdNumber[1] = "двести"; ThirdNumber[2] = "тристо"; ThirdNumber[3] = "четыресто"; ThirdNumber[4] = "пятьсот"; ThirdNumber[5] = "шестьсот"; ThirdNumber[6] = "семьсот"; ThirdNumber[7] = "восемьсот"; ThirdNumber[8] = "девятьсот";
        if (x.length() == 3 & Integer.parseInt(x) % 100 == 0) Number = (firstNumber[Integer.parseInt(x)/100] + " hundred");
        else if (x.length() == 3 & Integer.parseInt(x) % 100 != 0) {
            if (Integer.parseInt(x) % 100 > 19 & Integer.parseInt(x) % 10 == 0)
            Number = (ThirdNumber[Integer.parseInt(x)/100 - 1] + " "  + SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2]);
            else if (Integer.parseInt(x) % 100 > 19 & Integer.parseInt(x) % 10 != 0)
            Number = (ThirdNumber[Integer.parseInt(x)/100 - 1] + " "  + SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2] + " " + firstNumber[Integer.parseInt(x) % 10]);
            else if (Integer.parseInt(x) % 100 <= 19 & Integer.parseInt(x) % 100 > 9)
            Number = (ThirdNumber[Integer.parseInt(x)/100 - 1] + " " + firstAndSecondNumber[Integer.parseInt(x) % 10]);
            else Number = (ThirdNumber[Integer.parseInt(x)/100 - 1] + " " + firstNumber[Integer.parseInt(x) % 10]);
        }
        else if (x.length() == 2 & Integer.parseInt(x) % 10 == 0)
        Number = (SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2]);
        else if (x.length() == 2 & Integer.parseInt(x) % 10 != 0) {
            if (Integer.parseInt(x) % 100 > 19)
            Number = (SecondNumber[(Integer.parseInt(x) % 100 - Integer.parseInt(x) % 10)/10 - 2] + " " + firstNumber[Integer.parseInt(x) % 10]);
            else Number = (firstAndSecondNumber[Integer.parseInt(x) % 10]);
        }
        else Number = (firstNumber[Integer.parseInt(x) % 10]);
        return Number;
    }
}
