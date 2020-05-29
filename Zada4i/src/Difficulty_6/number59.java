package Difficulty_6;

import java.util.Scanner;

public class number59 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(isCorrectExpression(a));
    }

    public static boolean isCorrectExpression1(String x) {
        boolean checker = true;
        String[] parts = x.split("=");
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[i].length(); j++) {

                switch (parts[i].charAt(j)) {
                    case ('*'):
                        parts[i] = Integer.toString(Integer.parseInt(parts[i].substring(0, j)) * Integer.parseInt(parts[i].substring(j + 1)));
                        break;
                    case ('/'):
                    case (':'):
                        parts[i] = Integer.toString(Integer.parseInt(parts[i].substring(0, j)) / Integer.parseInt(parts[i].substring(j + 1)));
                        break;
                    case ('+'):
                        parts[i] = Integer.toString(Integer.parseInt(parts[i].substring(0, j)) + Integer.parseInt(parts[i].substring(j + 1)));
                        break;
                    case ('-'):
                        parts[i] = Integer.toString(Integer.parseInt(parts[i].substring(0, j)) - Integer.parseInt(parts[i].substring(j + 1)));
                        break;
                    default:
                        break;
                }//мат. операции
            }
        }
        for (int i = 0; i < parts.length - 1; i++) {
            if (!parts[i].equals(parts[i + 1])) checker = false;
        }
        return checker;
    }//эта функция работает для строки, в которой нет пробелов

    public static boolean isCorrectExpression(String x) {//для строки с пробелами(как показано в задании)
        boolean checker = true;
        String[] parts = x.split(" ");//записываю в массив части уравнения, разделенные пробелом
        for (int i = 0; i < parts.length; i++) {
            switch (parts[i]) {
                case ("*"):
                    parts[i] = Integer.toString(Integer.parseInt(parts[i-1]) * Integer.parseInt(parts[i+1]));
                    parts[i-1] = parts[i];
                    parts[i+1] = parts[i];
                    break;
                case ("/"):
                case (":"):
                    parts[i] = Integer.toString(Integer.parseInt(parts[i-1]) / Integer.parseInt(parts[i+1]));
                    parts[i-1] = parts[i];
                    parts[i+1] = parts[i];
                    break;
                case ("+"):
                    parts[i] = Integer.toString(Integer.parseInt(parts[i-1]) + Integer.parseInt(parts[i+1]));
                    parts[i-1] = parts[i];
                    parts[i+1] = parts[i];
                    break;
                case ("-"):
                    parts[i] = Integer.toString(Integer.parseInt(parts[i-1]) - Integer.parseInt(parts[i+1]));
                    parts[i-1] = parts[i];
                    parts[i+1] = parts[i];
                    break;
                default:
                    break;
            }//мат. операции
        }
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("=") && !(parts[i-1].equals(parts[i+1]))) checker = false;//проверка на равенство частей уравнения
        }
        return checker;
    }
}
