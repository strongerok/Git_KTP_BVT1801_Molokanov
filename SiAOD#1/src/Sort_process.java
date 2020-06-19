import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
    public class Sort_process {
        public void Shell(int[] mas, int n, boolean yn) {
            int[] massiv = Arrays.copyOf(mas, mas.length);
            for (int d = n / 2; d >= 1; d /= 2) { // меняем шаг
                for (int i = 0; i < n; i++) {
                    vstv(mas, i, n, d); // сортируем с помощью метода vstv (вставки)
                }
            }
            if (yn) vivod(mas, n);
        }

        public static void vstv(int[] mas, int a, int n, int b) {
            for (int i = a + b; i < n; i += b) { // правая неотсортированная часть
                for (int k = a; k < i; k += b) { // левая неосортированная часть
                    if (mas[i] < mas[k]) {
                        int tmp = mas[k];
                        mas[k] = mas[i];
                        for (int j = k += b; k <= i; k += b) { // сдвиг всех наших элементов в правую сторону
                            int c = mas[j];
                            mas[j] = tmp;
                            tmp = c;
                        }
                        break;
                    }
                }
            }
        }

        public void QuickSort(int[] mas, int n, boolean yn) {
            quickSort(mas, 0, n - 1);
            if (yn) vivod(mas, n);
        }
        public static void quickSort(int[] mas, int max, int min) {
            if (min >= max) return;
            int sr = (min + (max - min) / 2);
            int base = mas[sr];
            int min1 = min;
            int max1 = max;
            while (min1 <= max1) {
                while (mas[min1] < base) {
                    min1++;
                }
                while (mas[max1] > base) {
                    max1--;
                }
                if (min1 <= max1) {
                    int zamena = mas[min1];
                    mas[min1] = mas[max1];
                    mas[max1] = zamena;
                    min1++;
                    max1--;
                }
            }
            if (min < max1) quickSort(mas, min, max1);
        }
        //выводим
        public void vivod(int[] mas, int n) {
            for (int i = 0; i < n; i++) {
                System.out.print(mas[i] + "\t");
            }
        }
    }
