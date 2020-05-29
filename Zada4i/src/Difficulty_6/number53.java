package Difficulty_6;

import java.util.Scanner;

public class number53 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите 1 для RGB, 2 - для RGBA (RGB + прозрачность)");
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println("введите введите по очередеи контраст красного, зеленого и синего");
        String b = scanner.next();
        String c = scanner.next();
        String d = scanner.next();
        if (a == 2) {
            System.out.println("введите прозрачность");
            String e = scanner.next();
            System.out.println(RGBA(b, c, d, e));
        }
        else if (a == 1) System.out.println(RGB(b, c, d));
        else System.out.println("вы не ввели ни 1, ни 2");
    }

    public static boolean RGB(String x, String y, String z) {
         if (x.equals("") || y.equals("") || z.equals("")) return false;
         else {
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            int z1 = Integer.parseInt(z);
            return !(x1 < 0 || x1 > 255 || y1 < 0 || y1 > 255 || z1 < 0 || z1 > 255);
         }

    }

    public static boolean RGBA(String x, String y, String z, String t) {
        if (x.equals("") || y.equals("") || z.equals("") || t.equals("")) return false;
        else {
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            int z1 = Integer.parseInt(z);
            int t1 = Integer.parseInt(t);
            return !(x1 < 0 || x1 > 255 || y1 < 0 || y1 > 255 || z1 < 0 || z1 > 255 || t1 < 0 || t1 > 1);
        }
    }
}
