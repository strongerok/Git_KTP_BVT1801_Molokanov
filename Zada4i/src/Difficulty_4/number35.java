package Difficulty_4;
import java.util.Scanner;

public class number35 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("напишите систему меры вводимого веса: кг или фунты");
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println("введите вес");
        var b = scanner.nextDouble();
        System.out.println("напишите систему меры вводимого роста: м или дюймы");
        String idiotism = scanner.nextLine();//опять сканер пропускает ввод этой строки?????
        String c = scanner.nextLine();
        System.out.println("введите рост");
        var d = scanner.nextDouble();
        System.out.println(AreYouFat(b, d, a, c));
    }

    public static String AreYouFat(double x, double y, String z, String u) {
        if (!z.equals("кг") & !z.equals("фунты")) return "неверно введена система меры веса";
        else if (z.equals("фунты")) x/= 2.2046;

        if (!u.equals("м") & !u.equals("дюймы")) return "неверно введена система меры роста";
        else if (u.equals("дюймы")) y/= 39.37;

        return AreYouFatFormula(x, y);
    }

    public static String AreYouFatFormula(double x, double y) {
        double index = x/Math.pow(y, 2);
        if (index >25) return String.format("%.2f", index) + " избыточный вес";
        else if (index > 18.5 & index < 24.9) return String.format("%.2f", index) + " нормальный вес";
        else if (index < 18.5 & index > 0) return String.format("%.2f", index) + " недостаток веса";
        else return "некорректно введены значения веса и/или роста";
    }
}
