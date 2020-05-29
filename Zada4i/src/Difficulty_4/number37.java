package Difficulty_4;
import java.util.Scanner;

public class number37 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(StarLine(a));
    }

    public static String StarLine(String x) {
        char helper = '\0';
        int count = 1;
        String str = "";
        for (int i = 0; i < x.length(); i++) {
            if (i == x.length() - 1) {//если символ последний в строке
                if (count != 1) str = str + helper + "*" + Integer.toString(count);/*если до этого
                шла последовательность одного и того же символа добавим этот символ умноженный на количество*/
                else str+= Character.toString(x.charAt(i));//если идут разные символы добавим с строке этот символ
            }
            else if (x.charAt(i) == x.charAt(i+1)) {/*если текущий символ такой же как следующий (учитывая, что i символ
                не последний)*/
                helper = x.charAt(i);//даем вспомогательному символу значение текущего символа строки
                if (x.charAt(i) == helper) count += 1;//прибавляем к счетчику если символы совпадают
            }
            else {//в других случаях
                if (count != 1) str += helper + "*" + Integer.toString(count);/*если до этого
                шла последовательность одного и того же символа добавим этот символ умноженный на количество*/
                count = 1;//возвращаем счетчику количества значение 1
                helper = '\0';//обнуляем значение вспомогательного символа
                if (i == 0 || x.charAt(i-1) != x.charAt(i)) str+= Character.toString(x.charAt(i));/* если символ первый
                или предыдущий не совпадает с предыдущим добавим текущий символ*/
            }
        }
        return str;
    }
}
