package Difficulty_3;
import java.util.Scanner;

public class number21 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        var a = scanner.nextDouble();//переменная, в которую записывается считавшееся значение
        var b = scanner.nextDouble();
        var c = scanner.nextDouble();
        System.out.println(RootsOfTheEquation(a, b, c));
    }

    public static String RootsOfTheEquation(double a, double b, double c) {//функция для нахождения корней кв. уравнения
        var D = Math.pow(b,2) - 4*a*c; //заранее записал формулу Дискриминанта
        if (a == 0) return "уравнение не квадратное";/*т.к. просят найти корни КВАДРАТНОГО уравнения, то без х^2 решать
        смысла нет*/
        else if (D < 0) return "уравнение не имеет действительных корней";/*для D<0 есть только комплексные корни, но, видимо,
        задание для действительных чисел, т.к. в примере написано "корней нет" для такого случая*/
        else {
            var x1 = (-b + Math.pow(D, 0.5))/2*a;//во всех остальных случаях как минимум 1 корень есть
            if (D == 0) {
                return "уравнение имеет 1 корень x=" + x1;//если D=0 то этот 1 корень и пишу в ответ
            }
            else {
                var x2 = (-b - Math.pow(D, 0.5))/2*a;//2 корень для случая D>0
                return "уравнение имеет 2 корня x1=" + x1 + " и х2=" + x2;
            }
        }
    }
}
