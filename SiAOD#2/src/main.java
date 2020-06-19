import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class main {
    public static void Main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int k;
        int con;
        System.out.println("Введите размер исходного массива: ");
        n = in.nextInt();
        System.out.println("Введите предел: ");
        con = in.nextInt();
        int[] mas = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++) {
            mas[i] = random.nextInt(con);
        }
        Arrays.sort(mas);
        if (mas.length<=31) {
            for (int i=0;i<n;i++) {
                System.out.print(mas[i] + " ");
            }
        }
        else
            System.out.println("массив за пределами диапазона");
        System.out.println();
        System.out.println("Введите новое значение для массива: ");
        int newVal = in.nextInt();
        int[] mas1 = back(mas, n, newVal);
        Arrays.sort(mas1);
        if (mas1.length < 30) {
            for (int value : mas1) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
        System.out.println("Введите номер элемента: ");
        k = in.nextInt();
        double before = System.nanoTime();
        int position = interp.InterpolationSearch(mas1, k);
        double after = System.nanoTime();
        System.out.println();
        System.out.println("Время интерполяционного поиска: " + (after - before) + "ns");
        before = System.nanoTime();
        after = System.nanoTime();
        System.out.println();
        System.out.println("Время интегрированного поиска: " + (after - before) + "ns");
        if (position == -1) {
            System.out.println("Такого элемента не существует");
        }
        else {
            System.out.println("Элемент на " + position + " позиции");
            System.out.println("Удалить этот элемент?" + "\n" + "1 - да, 0 - нет");
            int d;
            d = in.nextInt();
            System.out.println();
            if (d == 1)
            {
                delete(mas1, position);
                System.out.println();
                System.out.println("Элемент удален в " + position + " позиции");
            }
        }
    }
    public static void delete (int[] mas, int ind) {
        if (mas.length - 1 - ind >= 0) System.arraycopy(mas, ind + 1, mas, ind, mas.length - 1 - ind);
        mas[mas.length-1] = 0;
        if (mas.length<=31) {
            for (int i=0;i<mas.length-1;i++)
                System.out.print(mas[i] + " ");
        }
    }
    public static int[] back(int[] mas, int size, int sence) {
        int[] mas1=new int[size+1];
        if (size >= 0) System.arraycopy(mas, 0, mas1, 0, size);
        mas1[size] =sence;
        return mas1;
    }
}