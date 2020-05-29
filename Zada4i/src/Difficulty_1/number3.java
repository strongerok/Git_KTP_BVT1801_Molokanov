package Difficulty_1;
import java.util.Scanner;

public class number3 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменные, в которых записывается считавшееся значение
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(animals(a, b, c));
    }

    public static int animals(int x, int y, int z) {/*функция, выводящая количество ног всех животных (не смог вывести
        в качестве ошибки строку, поэтому вывожу 0*/
        if (x<0 || y<0 || z<0) return 0;
        else return 2*x+4*y+4*z;
    }
}
