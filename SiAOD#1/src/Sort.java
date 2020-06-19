import java.util.Arrays;

public class Sort extends Sort_process {
    public Sort () {
    }
    // Шелл
    public void Shell1 (int[][] massiv, int n, boolean yn) {
        int[][] mas = Arrays.copyOf(massiv, massiv.length);
        System.out.println("\nШелл сортировка");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            Shell(mas[i], n, false);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        if (yn) Matrica(mas, n);
        System.out.println("\nвремя выполнения " + timeSpent + "ms");
    }
    // QuickSort
    public void QuickSort1(int[][] massiv, int n, boolean yn) {
        int[][] mas = Arrays.copyOf(massiv, massiv.length);
        System.out.println("\nQuickSort");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            QuickSort(mas[i], n, false);
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        if (yn) Matrica(mas, n);
        System.out.println("\nвремя выполнения " + timeSpent + "ms");
    }
    public void Sort1(int[][] massiv, int n, boolean yn) {
        int[][] mas = Arrays.copyOf(massiv, massiv.length);
        System.out.println("\nCтандартная сортировка java");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            Arrays.sort(mas[i]); // стандартная сортировка java Из библиотеки Arrays (подключили выше)
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        if (yn) Matrica(mas, n);
        System.out.println("\nвремя выполнения " + timeSpent + "ms");
    }
    public void Matrica(int[][] mas, int n) {
        for (int i = 0; i < n; i++) {
            Sort_process sort = new Sort_process();
            sort.vivod(mas[i], n);
            if (i != n - 1) System.out.print(" \n ");
        }
    }
}
