package Difficulty_5;
import java.util.Scanner;

public class number46 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        if (a.length() < 14 || a.length() > 19) System.out.println("количество цифр не соответствует номеру карты");
        else if (!a.matches("[-+]?\\d+")) System.out.println("вы ввели не цифру");
        else System.out.println(isCardNumber(a));
    }

    public static boolean isCardNumber(String x) {
        int LastNumber = Integer.parseInt(Character.toString(x.charAt(x.length() - 1)));//последняя цифра
        x = x.substring(0,x.length() - 1);//номер карты без последней цифры
        String ReversedNumber = "";
        for (int i = x.length() - 1; i >= 0; i--) {//цикл для переворачивания номера карты
            ReversedNumber += x.charAt(i);
        }
        int[] numbers = new int[ReversedNumber.length()];//массив цифр перемернутого номера карты
        for (int i = 0; i < ReversedNumber.length(); i++)
            numbers[i] = Integer.parseInt(Character.toString(ReversedNumber.charAt(i)));

        for (int i = 1; i < ReversedNumber.length(); i+=2) {//цикл умножения на 2 нечетных элементов массива
            int k = numbers[i]*2;
            int Sum = 0;
            if (k < 10) numbers[i] = numbers[i]*2;
            else {//если после умножения получилось 2значное число
                while(k != 0){
                    Sum += (k % 10);
                    k/=10;
                }
                numbers[i] = Sum;//присваиваем элементу новое значение
            }
        }

        int Sum = 0;//сумма элементов массива
        for (int i = 0; i < ReversedNumber.length(); i++) {//цикл для подсчета суммы элементов массива
            Sum+= numbers[i];
        }
        return (10 - (Sum % 10)) == LastNumber;//проверка на соответствие и вывод результата проверки
    }
}
