package Difficulty_1;
public class number1 {

    public static void main(String[] args) { //функция main. здесь выводится результат
        System.out.println (remainder(1, 3));
        System.out.println (remainder(3, 4));
        System.out.println (remainder(-9, 45));
        System.out.println (remainder(5, 5));
    }

    public static int remainder(int x, int y) { //функция, возвращающая остаток от деления х на у
        return x % y;
    }
}
