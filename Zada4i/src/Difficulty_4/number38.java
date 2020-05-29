package Difficulty_4;
import java.util.Arrays;
import java.util.Scanner;

public class number38 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        String b = scanner.nextLine();
        System.out.println(isRhyme(a, b));
    }

    public static boolean isRhyme(String x, String y) {//функция, возвращающая true если рифмуются, false - если нет
        return WordVowels(LastWordInLine(x)).equals(WordVowels(LastWordInLine(y)));
    }

    public static String LastWordInLine(String x) {//функция возвращающая последнее слово в строке
        String[] words;//с помощью массива
        String delimiter = " ";
        words = x.split(delimiter);
        return words[words.length-1].toLowerCase();//последний элемент массива = последнее слово в строке
    }

    public static String WordVowels(String x) {//функция, возвращающая все гласные введенного слова (по порядку)
        String str ="";
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'i' || x.charAt(i) == 'o'
                || x.charAt(i) == 'u' || x.charAt(i) == 'y') {
            str=str + x.charAt(i);
            }
        }
        return str;
    }
}
