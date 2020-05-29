package Difficulty_5;
import java.util.Scanner;
import static Difficulty_4.number38.WordVowels;

public class number45 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите количество слов, которые вы собираетесь ввести");
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        String[] words = new String[a];
        System.out.println("введите слова");
        for (int i = 0; i < words.length; i++) {
            words[i] = scanner.next();
        }
        System.out.println(SameVowels(words));
    }

    public static String SameVowels(String[] x) {
        String helper = WordVowels(x[0]);//переменная, в которую записываются все гласные 1 слова
        String[] goodWords = new String[x.length];//массив подходящих нам слов
        goodWords[0] = x[0];//1 слово строки всегда подходит
        for (int i = 0; i < helper.length(); i++) {//цикл в котором я убрал одинаковые гласные (ooey ->  oey)
            for (int j = i+1; j < helper.length(); j++) {
                if (helper.charAt(i) == helper.charAt(j)) helper = helper.substring(0,i) + helper.substring(i+1);
            }
        }
        String str = helper;//строка, которая будет изменяться в ходе проверки
        for (int j = 1; j < x.length; j++) {//для каждого введенного слова
            for (int m = 0; m < x[j].length(); m++) {//для каждой буквы слова
                for (int k = 0; k < str.length(); k++)//для каждой буквы из строки гласных 1 слова
                if (x[j].charAt(m) == str.charAt(k)) {//если гласные совпали
                    str = str.substring(0,k) + str.substring(k+1);//убираю гласную из строки гласных 1 слова
                    break;//выхожу, т.к. повторяющиеся гласные не учитываются
                }
                if (str.equals("")) goodWords[j] = x[j];//если строка пустая, то слово нам подходит => записываю его в массив
            }
            str = helper;//возвращаю строке значение гласных 1 слова
        }
        return StringArrayToString(goodWords);
    }

    public static String StringArrayToString (String[] x) {//цикл вывода слов массива через StringBuilder
        StringBuilder sb = new StringBuilder();
        for (String value : x) {
            if (value != null) {//чтобы не выводить пустые элементы массива
                sb.append(value);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
