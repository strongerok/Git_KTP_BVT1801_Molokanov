package Difficulty_2;
import java.util.Scanner;

public class number15 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        double a = scanner.nextDouble();//переменная, в которую записывается считавшееся значение
        System.out.println(DecimalsAfterDot(a));
    }

    public static int DecimalsAfterDot(double x) {//никак не хочет считывать 0
        int c = 0;//итоговое число знаков после запятой
        int n = 0;
        int d = 0;
        double a = x - (int) x;//дробная часть числа
        String b = Double.toString(x);//строковое представление введенного числа
        if (a == 0.0) c = 0;//если дробная часть в double =0.0 значит число целое и ответ 0
        else {
            for (int i = 0; i < b.length(); i++) {
                if ((b.charAt(i) == '.') || (b.charAt(i) == ',')) {//когда встретилась запятая или точка
                    n = b.length() - i - 1;//число знаков после запятой
                    d = (int) Math.round(a * Math.pow(10, n));//делаю числа после запятой целым числом (2,33 -> 33)
                    c = Integer.toString(d).length();//длина строкового представления d и есть число знаков после запятой
                }
            }
        }
        return c;
    }
}