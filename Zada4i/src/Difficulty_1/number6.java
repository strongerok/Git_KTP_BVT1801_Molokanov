package Difficulty_1;
import java.util.Scanner;


public class number6 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменные, в которых записывается считавшееся значение
        char b = a.charAt(0);//перевод из строкового типа в символьный(не учитывается, что может быть введено больше 1 символа)
        System.out.println(cToa(b));
    }

    public static int cToa(char x) {//функция, выводящая номер символа в таблице ascii
        String str = Character.toString(x);
        return str.charAt(0);
    }
}
