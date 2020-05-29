package Difficulty_4;
import java.util.Scanner;

public class number32 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите кластер скобок");
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println(Cluster(a));
    }

    public static String Cluster(String x) {
        int CountLeft = 0;//счетчик кол-ва левых скобок
        int CountRight = 0;//счетчик кол-ва правых скобок
        String ClusterOnStep = "";/*строка, в которую записываются текущие символы исходной строки на каждом шаге до
        совпадения CountLeft и CountRight*/
        String Cluster = "";//итоговая строка
        for (int i = 0; i < x.length(); i++) {
            if (!(x.charAt(i) == '(' || x.charAt(i) == ')')) return "это не кластер скобок";/*проверка каждого символа
            на то, скобка это или нет*/
            else {
                ClusterOnStep += x.charAt(i);//запоминаем текущий символ
                if (x.charAt(i) == '(') CountLeft += 1;/*увеличиваем счетчик левой или правой скобки в зависимости от
                текущего символа*/
                else CountRight += 1;
                if (CountLeft == CountRight) {//при совпадении числа скобок на каком-либо шаге
                    if (i == x.length() - 1) Cluster += "\"" + ClusterOnStep + "\"";/*так меняем итоговую строку если
                    шаг последний*/
                        else Cluster += "\"" + ClusterOnStep + "\"" + "," + " ";//так, если не последний
                        ClusterOnStep = "";//обнуляем строку с текущими символами (т.к. совпало количество)
                }
            }
        }
        if (CountLeft != CountRight) return "количество открывающих и закрывающих скоробок не совпадает";/*проверка
        сопадения итогового количества левых и правых скобок*/
        else return Cluster;
    }
}
