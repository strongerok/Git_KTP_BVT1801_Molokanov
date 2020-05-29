package Difficulty_5;

import java.util.Scanner;

public class number44 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите количество чисел, которые вы собираетесь ввести");
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        int[] numbers = new int[a];
        System.out.println("введите числа");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(NumbersSumMultiplied(numbers));
    }

    public static int NumbersSumMultiplied(int[] x) {
        int sum = 0;
        int multiplier = 1;
        int check = 1;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        if (sum == 0) multiplier = 0;
        else {
        while(sum > 0){
            multiplier *= (sum % 10);
            sum/=10;
        }
        while (multiplier > 9) {
            check *= (multiplier % 10);
            multiplier/=10;
            if (multiplier < 9) {
                multiplier =check;
                check = 1;
            }
        }
        }
        return multiplier;
    }
}
