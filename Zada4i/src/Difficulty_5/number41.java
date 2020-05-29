package Difficulty_5;
import java.util.Arrays;
import java.util.Scanner;
import static Difficulty_1.number6.cToa;

public class number41 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("выберите 1, если будете вводить слово и 2, если будете вводить массив кодов символов");
        int a = scanner.nextInt();//переменная, в которую записывается считавшееся значение
        if (a == 1) {
            String b = scanner.next();
            System.out.println(encrypt(b));
        }
        else if (a == 2) {
            System.out.println("введите количество кодов символов");
            int c = scanner.nextInt();
            int[] d = new int[c];
            for (int i = 0; i < c; i++) {
                d[i] = scanner.nextInt();
            }
            System.out.println(decrypt(d));
        }
        else System.out.println("вы не ввели ни 1, ни 2");
    }

    public static String encrypt(String x) {
        if (x.equals("")) return "вы ввели пустую строку";
        else {
            var code = new int[x.length()];//итоговый массив
            code[0] = cToa(x.charAt(0));//записываю в 1 элемент массива код 1 символа (т.к. он равен сам себе)
            for (int i = 1; i < x.length(); i++) code[i] = cToa(x.charAt(i)) - cToa(x.charAt(i-1));/*заполнение массива
            путем разности соседних (текущего и предыдущего по итерации) символов*/
            return Arrays.toString(code);
        }
    }

    public static String decrypt(int[] x) {
        String str = "";//итоговая строка с предложением
        int step = x[0];/*переменная в которой хранится сумма всех кодов на данной итерации (т.к. код символа есть сумма
        всех предыдущих и его самого*/
        str+= (char) x[0];
        for (int i = 1; i < x.length; i++) {
            step+= x[i];//добавляю текущий элемент(код)
            str += (char) step;//добавляю к итоговой строке соотвутствующий коду символ
        }
        return str;
    }
}
