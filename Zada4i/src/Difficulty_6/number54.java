package Difficulty_6;

import java.util.Arrays;
import java.util.Scanner;

public class number54 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        String b = scanner.nextLine();
        if (b.equals("")) System.out.println(paramsToStrip(a));
        else {
            char b1 = b.charAt(0);
            System.out.println(paramsToStrip(a, b1));
        }
    }

    public static String paramsToStrip(String x) {//функция, просто убирающая повторяющиеся параметры
        StringBuilder str = new StringBuilder();//итоговая строка
        for (int i = 2; i < x.length(); i++) {
            if (x.charAt(i-2) == 'c' & x.charAt(i-1) == 'o' & x.charAt(i) == 'm') {
                str.append(x, 0, i + 2);//запоминаю часть строки, кончающуюся на "com" в итоговой строке
                x = x.substring(i+2);//удаляю часть строки, кончающуюся на "com"
            }
        }
        String[] Params = x.split("&");//разделяю параметры по &
        for (int i = 0; i < Params.length; i++) {
            for (int j = i+1; j < Params.length; j++) {
                if (Params[i].charAt(0) == Params[j].charAt(0)) {//если параметры совпали
                    Params[i] = "";//удаляю первый встретившийся дублирующийся параметр
                    break;
                }
            }
        }
        for (String param : Params) {
            if (!param.equals("")) str.append(param).append("&");//прибавляю к строке параметры, кроме пустых элементов (удаленных парамтеров)
        }
        str = new StringBuilder(str.substring(0, str.length() - 1));//удаляю последний &
        return str.toString();
    }

    public static String paramsToStrip(String x, char y) {//аналогичная функция, только с заданным параметром для удаления
        StringBuilder str = new StringBuilder();
        for (int i = 2; i < x.length(); i++) {
            if (x.charAt(i-2) == 'c' & x.charAt(i-1) == 'o' & x.charAt(i) == 'm') {
                str.append(x, 0, i + 2);
                x = x.substring(i+2);
            }
        }
        String[] Params = x.split("&");
        for (int i = 0; i < Params.length; i++) {
            for (int j = i+1; j < Params.length; j++) {
                if (Params[i].charAt(0) == Params[j].charAt(0)) Params[i] = "";
                else if (Params[i].charAt(0) == y) Params[i] = "";//единственное отличие - убираю параметр если совпал с введенным пользователем
            }
        }
        for (String param : Params) {
            if (!param.equals("")) str.append(param).append("&");
        }
        str = new StringBuilder(str.substring(0, str.length() - 1));
        return str.toString();
    }
}
