package Difficulty_4;
import java.util.Scanner;

public class number39 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        String b = scanner.nextLine();
        System.out.println(Trouble(a, b));
    }

    public static boolean Trouble(String a, String b) {
        boolean good;
        good = false;
        for (int i = 0; i < a.length() - 2; i++) {/* до предпредпоследнего, т.к. нам надо рассматривать последовательность
            из 3 чисел/элементов массива, а не каждый по отдельности*/
            if (a.charAt(i) == a.charAt(i + 1) & (a.charAt(i) == a.charAt(i + 2))) {//если 3 числа совпадают...
                for (int j = 0; j < b.length() - 1; j++) {//аналогично, т.к. -//- из 2 -//-
                    if (b.charAt(j) == a.charAt(i) & (b.charAt(j+1) == a.charAt(i))) {/*если 2 числа совпадают и равны
                        числу из 1 последовательности (и те 3 числа совпадают)*/
                        good = true;
                        break;
                    }
                }
                if (good) break;
            }
        }
        return good;
    }
}
