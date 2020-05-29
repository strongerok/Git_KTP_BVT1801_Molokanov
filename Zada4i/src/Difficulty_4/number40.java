package Difficulty_4;
import java.util.Arrays;
import java.util.Scanner;

public class number40 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        String b = scanner.nextLine();
        System.out.println(countUniqueBooks(a, b));
    }

    public static int countUniqueBooks(String x, String y) {
        char z = y.charAt(0);//символ, по которому мы ищем
        int count = 0;//счетчик количества символов по которому мы ищем, встретившегося в строке на данной итерации
        int k = 0;//счетчик для номера элемента массива уникальных символов
        int uniqueSymbols = 0;//счетчик уникальных символов
        char[] symbols = x.toCharArray();//массив всех символов строки, в которой мы ищем уникальные символы
        char[] books = new char[x.length()];//массив длины строки, в котором содержатся уже встретившиеся уникальные символы
        for (int i = 0; i < x.length(); i++){
            if (z == symbols[i]) count += 1;
                if (count % 2 == 1) {//если символ, по которому ищем встретился нечетное кол-во раз
                    if (checkForUniqueness(books, symbols[i+1]) & symbols[i+1] != z) {/*если символ уникален и не равен
                        символу, по которому мы ищем*/
                        books[k] = symbols[i+1];//добавляем массиву уникальных элементов подошедший нам на данной итерации
                        k += 1;
                        uniqueSymbols += 1;
                    }
                }
        }
        return uniqueSymbols;
    }

    public static boolean checkForUniqueness(char[] x, char y) {/* функция, проверяющая уникальный ли символ у для массива х
        (не встречается там)*/
        boolean uniqueness = true;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == y) uniqueness = false;
        }
        return uniqueness;
    }
}
