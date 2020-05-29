package Difficulty_4;
import java.util.Scanner;

public class number34 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        double[] Job = new double[4];//объявление массива
        System.out.println("введите время начала и конца работы, почасовую ставку и множитель сверхурочных");
        for (int i = 0; i<4; i++) Job[i] = scanner.nextDouble();//цикл для заполнения массива числами
        System.out.println(Salary(Job));
    }

    public static String Salary(double[] x) {
        if (x[1] < x[0]) return "часы начала работы позже часов конца работы";
        else if (x[2] <= 0) return "некорректная почасовая ставка";
        else if (x[3] <= 1) return "некорректный множитель сверхурочных";
        else if (x[0] >= 17) return "$" + Double.toString((x[1] - x[0])*x[2]*x[3]);//если начал работать позже 17:00
        else if (x[1] > 17 & x[0] < 17) return "$" + Double.toString((17 - x[0])*x[2] + (x[1] - 17)*x[2]*x[3]);/*если
        начал раньше 17:00, а закончил позже*/
        else return "$" + Double.toString((x[1] - x[0])*x[2]);//начал и закончил раньше 17:00
    }
}
