package Difficulty_4;
import java.util.Scanner;

public class number36 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(bugger(a));
    }

    public static int bugger(int x) {
        int y = 0;//счетчик количества раз, которое мы умножали, пока не достигли 1 цифры
        int z = 1;//переменная, в которую записывается произведение цифр х на текущей итерации
        while (x > 9) {//пока х не однозначное число
            z = 1;//возвращаем z значение 1 после каждой итерации
            y+=1;//добавляем к счетчику 1 на каждой итерации
            while (x > 0) {//пока не использовали все цифры числа х
                z *= x % 10;//умножаем х на крайнюю правую цифру числа х
                x = (int) (x / 10);//убираем из числе х крайнюю правую цифру
            }
            x = z;//меняем значение х на произведение его цифр
        }
        return y;
    }
}