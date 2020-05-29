package Difficulty_3;
import java.util.Scanner;

public class number22 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(find2Zip(a));
    }

    public static int find2Zip(String x) {
        int count = 0;
        int place = -1;//т.к. нужно вывести -1, если меньше 2 раз встречается, то такое начальное значение переменной и задаю
        for (int i = 0; i < x.length(); i++) {//проход по всей строке
            if (i< x.length() - 2) {/*т.к далее я смотрю значения символов на 2 шага вперед, то тут надо вычесть 2, чтобы
                избежать ошибки*/
                if (x.charAt(i) == 'z' && x.charAt(i+1) == 'i' && x.charAt(i+2) == 'p') {/*проверка на слово zip (нахожусь
                    на символе z*/
                    count += 1;//считчик количества слов zip, встретившихся в строке
                    if (count == 2) {/*т.к. нам нужно найти, когда слово zip появляется второй раз, то на 2 итерации я
                        заменяю переменную place на позицию z и заканчиваю цикл*/
                        place = i;
                        break;
                    }
                }
            }
        }
        return place;
    }
}
