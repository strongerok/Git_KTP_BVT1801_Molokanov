package Difficulty_5;
import java.util.Scanner;
import static Difficulty_1.number6.cToa;

public class number42 {
    public static void main(String[] args) {//функция main. здесь выводится результат
        Scanner scanner = new Scanner(System.in);//сканер, считывающий введенные с клавиатуры данные
        System.out.println("введите фигуру");
        String a = scanner.nextLine();//переменная, в которую записывается считавшееся значение
        System.out.println("введите клетки");
        String b = scanner.nextLine();
        String c = scanner.nextLine();
        if (!checkFigure(a)) System.out.println("это не шахматная фигура");
        else if (!checkSquare(b) || !checkSquare(c)) System.out.println("это не клетка шахматной доски");
        else System.out.println(canMove(a, b, c));
    }

    public static boolean canMove(String x, String y, String z) {
        x = x.toLowerCase();//делаю все буквы строчными, чтобы не было несовпадений
        y = y.toLowerCase();
        z = z.toLowerCase();
        switch (x) {//оператор свитч для фигур (для каждой фигуры описана общая закономерность передвижения)
            case "pawn":
                return (y.charAt(0) == z.charAt(0) & cToa(y.charAt(1)) == cToa(z.charAt(1)) - 1);/*тут
        я не учитываю шахматное правило, гласящее, что пешка с начального положения может пойти на 2 клетки вперед, т.к.
        в задаче не сказано учитывать цвет и определить какого цвета пешка стоит на нужной клетке невозможно*/
            case "knight":
                return (((cToa(y.charAt(0)) == 1 + cToa(z.charAt(0)) || cToa(y.charAt(0)) == cToa(z.charAt(0)) - 1)
                        & (cToa(y.charAt(1)) == cToa(z.charAt(1)) + 2 || cToa(y.charAt(1)) == cToa(z.charAt(1)) - 2)) ||
                        ((cToa(y.charAt(0)) == 2 + cToa(z.charAt(0)) || cToa(y.charAt(0)) == cToa(z.charAt(0)) - 2)
                                & (cToa(y.charAt(1)) == cToa(z.charAt(1)) + 1 || cToa(y.charAt(1)) == cToa(z.charAt(1)) - 1)));
            case "bishop":
                return (Math.abs(cToa(y.charAt(0)) - cToa(z.charAt(0))) ==
                        Math.abs(cToa(y.charAt(1)) - cToa(z.charAt(1))));
            case "rook":
                return (y.charAt(0) == z.charAt(0) || y.charAt(1) == z.charAt(1));
            case "queen":
                return (Math.abs(cToa(y.charAt(0)) - cToa(z.charAt(0))) == 1
                        & Math.abs(cToa(y.charAt(1)) - cToa(z.charAt(1))) == 1
                        || y.charAt(0) == z.charAt(0) || y.charAt(1) == z.charAt(1));
            //король
            default:
                return (y.charAt(0) == z.charAt(0) & Math.abs(cToa(y.charAt(1)) - cToa(z.charAt(1))) == 1
                        || (Math.abs(cToa(y.charAt(0)) - cToa(z.charAt(0))) == 1 & Math.abs(cToa(y.charAt(1)) - cToa(z.charAt(1))) <= 1));
        }
    }

    public static boolean checkFigure(String x) {//проверка на соответствие слова имени фигуры
        x = x.toLowerCase();
        return (x.equals("pawn") || x.equals("knight") || x.equals("bishop") || x.equals("rook") || x.equals("queen") || x.equals("king"));
    }

    public static boolean checkSquare(String x) {//проверка на существование введенной клетки на шах. доске
        x = x.toLowerCase();
        return (x.length() == 2 & x.charAt(0) >= 'a' & x.charAt(0) <= 'h' & x.charAt(1) >= '1' & x.charAt(1) <= '8' );
    }
}
