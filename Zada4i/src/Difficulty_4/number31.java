package Difficulty_4;
import java.util.Scanner;

public class number31 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите число слов");
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println("введите число символов в строке");
        int b = scanner.nextInt();
        System.out.println("напишите ваше эссе");
        var c = scanner.nextLine();//После nextInt остается конец строки, считываю его, чтобы затем
        var d = scanner.nextLine();//здесь ввести эссе
        System.out.println(correctedEssay(a, b, d));
    }

    public static String correctedEssay(int x, int y, String z) {
        String[] words;//массив слов
        String delimiter = " ";//разделитель
        String essay = "";//будущее корректированное эссе
        String CurrentLine = "";//переменная, которая хранит текущую строку без пробелов, для проверки
        words = z.split(delimiter);//заполнение массива с помощью разделения введенного текста по пробелу
        if (x != words.length) return "вы меня обманули, попробуйте еще раз";/*ошибка, когда введенное кол-в слов не
        соответствует количеству слов в строке*/
        else {
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > y) return "длина" + i + "слова больше заданной длины строки";/*ошибка, когда
                встречается слово, длина которого больше заданной длины строки*/
                else {
                    essay += words[i];
                    CurrentLine += words[i];
                    if (i != words.length - 1) {//если слово не последнее в массиве
                        if (y >= CurrentLine.length() + words[i + 1].length()) essay += " ";/*если сумма длин слов текущей
             строки (без пробелов) и следующего слова меньше или равна заданной длины строки, то добавляем пробел к эссе*/
                        else {//иначе переходим на другую строку в эссе и обнуляем строку слов без пробелов
                            CurrentLine = "";
                            essay += "\n";
                        }
                    }
                    else break;//если слово последнее - выходим из цикла
                }
            }
        }
        return essay;
    }
}
