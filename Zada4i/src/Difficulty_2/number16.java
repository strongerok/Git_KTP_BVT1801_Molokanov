package Difficulty_2;
import java.util.Scanner;

public class number16 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        System.out.println(FibonachiNumber(a));
    }

    public static int FibonachiNumber(int x) {/*функция, находящая число Фибоначчи, по его номеру (сделал, как вы хотели
        хотя у вас неправильно указаны номера (вы не считаете первую единицу за число). из-за этого в формуле (x+1) вместо х*/
        double b = (Math.pow(((1+Math.pow(5, 0.5))/2), (x+1)) - Math.pow(((1-Math.pow(5, 0.5))/2), (x+1)))/(Math.pow(5, 0.5));
        //мат. формула чисел Фибоначчи (ф.Муавра)
        int c =(int) b; //выделение целой части, т.к. формула имеет погрешность (точность до 10^(-9)+-)
        return c;
    }
}
