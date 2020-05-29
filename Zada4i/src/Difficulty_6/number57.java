package Difficulty_6;

import java.util.Arrays;
import java.util.Scanner;

public class number57 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(longestUniqueLine(a));
    }

    public static String longestUniqueLine(String x) {
        String[] str = new String[x.length()];//строковый массив длины введенной строки, для уникальных строк
        Arrays.fill(str, "");//заполнение массива пустыми строками
        boolean unique = true;//проверка на уникальность
        int count = 0;//cчетчик для заполнения массива уникальных строк
        for (int i = 0; i < x.length(); i++) {
        for (int j = 0; j < str[count].length(); j++) {
            if (x.charAt(i) == str[count].charAt(j)) unique = false;/*если текущий символ строки встретился в текущем эл-те массива уникальных строк,
            то проверка на уникальность = false*/
            }
            if (!unique) {//если после проверки всего эл-та массива он не уникален
                count+=1;//переходим к следующему
                unique = true;//возвращаем проверку на true
            }
            str[count]+=x.charAt(i);//иначе добавляем символ к эл-ту (т.к. он не встретился)
        }
        String max = "";//строковая переменная для запоминания максимального эл-та массива уникальных строк (уникальной части введенной строки)
        int Max = 0;//длина максимального эл-та массива уникальных строки на данной итерации
        for (int j = 0; j < str.length; j++) {
            if (str[j].length() > Max) {//если длина эл-та больше максимальной
                Max = str[j].length();//максимальная длина = длина этого эл-та
                max = str[j];//максимальный эл-т запоминается
            }
        }
            return max;//вывод максимального эл-та
    }
}
