package Difficulty_3;
import java.util.Scanner;

public class number25 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(isValidHexCode(a));
    }

    public static String isValidHexCode(String x) {
        String str = "";
        if (x.length() != 7) str = "количество символов не соответствует 16-ричному коду";
        else if (x.charAt(0) != '#') str = "не хватает # в начале";
        else for (int i = 1; i < x.length(); i++) {/*проверка каждого символа строки (после #) на принадлежность диапазону
            от 0-9, a-f, или A-F*/
                if (x.charAt(i) >= 'a' & x.charAt(i) <= 'f' || x.charAt(i) >= 'A' & x.charAt(i) <= 'F' || x.charAt(i) >= '0' & x.charAt(i) <= '9')
                    str = "корректный 16-ричный код";
                else str = "не все буквы в диапазоне a-f, A-F";
            }
        return str;
    }
}
