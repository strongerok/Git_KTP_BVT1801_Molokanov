package Difficulty_1;
import java.util.Scanner;

public class number10 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(abcMath(a, b, c));
    }

    public static boolean abcMath(int x, int y, int z) {//функция, показывающая делится ли итоговое х на z
        while (y>0) {//цикл, складывающий х сам с собой у раз (получающий итоговое значение х)
                x = x + x;
                y = y - 1;
        }
        if (x % z == 0) return true;
        else return false;
    }
}