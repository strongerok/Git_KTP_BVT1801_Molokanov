package Difficulty_3;
import java.util.Scanner;

public class number28 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите двоичную строку");
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(LongestZero(a));
    }

    public static String LongestZero(String x) {
        String str = "";
        int count = 0;
        int max = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != '0' & x.charAt(i) != '1') {
                str = "это не двоичная строка";
                break;
            }
            else {
                if (x.charAt(i) == '0') {
                    count += 1;
                    if (count > max) max = count;
                }
                else count = 0;
            }
        }
        if (max == 0) str = "";
        else {
            for (int j = max; j > 0; j--) str += '0';
        }
        return str;
    }
}
