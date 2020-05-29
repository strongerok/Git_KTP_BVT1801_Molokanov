package Difficulty_6;

import java.util.Scanner;

public class number55 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(hashTags(a));
    }

    public static String hashTags(String x) {
        int length = 0;//длина самого длинного слова на текущей итерации
        int numberOfMaxWord = 0;//номер самого длинного элемента в массиве (для удаления)
        String maxWord = "";//слово максимальной длины
        StringBuilder str = new StringBuilder();//итоговая строка хештегов
        String[] words = x.split(" ");//массив слов введенной строки
        int k = 0;//счетчик числа слов, которые уже в хештегах

        if (x.equals("")) return "вы не ввели заголовок";
        else {
            while (k < 3) {
                for (int i = 0; i < words.length; i++) {//цикл для нахождения самого длинного слова в массиве
                    if (words[i].length() > length) {
                        length = words[i].length();
                        maxWord = words[i];
                        numberOfMaxWord = i;
                    }
                }
                if (maxWord.equals("\0")) k = 3;//если слов в массиве не осталось выходим из цикла while
                else {//иначе
                    str.append("#").append(maxWord).append(", ");//прибавляем к строке хештегов сам хештег, слово и запятую с пробелом
                    length = 0;//обнуляем длину самого длинного слова для следующей итерации
                    maxWord = "";//"обнуляем" самое длинное слово
                    words[numberOfMaxWord] = "\0";//обнуляем самый длинный элемент массива
                    k += 1;//счетчик слов, которые уже в хештегах
                }
            }
            return str.toString().substring(0, str.length() - 2);
        }
    }
}
