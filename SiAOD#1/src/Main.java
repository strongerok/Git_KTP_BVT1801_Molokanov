import java.util.Random;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("матрица или массив?");
        System.out.print("(матрица - matrica, массив - massiv): ");
        String str = input.nextLine();
        if (str.equals("matrica")) {
            int[] array = array(n); //сгенерировали массив
        }  else return;
        System.out.print("Введите размер матрицы: ");
        int n = input.nextInt();
        int[][] array = array(n); //сгенерировали массив
        Sort sort = new Sort();
        sort.Shell1(array, n, true);
        sort.QuickSort1(array, n, true);
        sort.Sort1(array, n, true);
        }

        public static int[][] array(int n) {//создание массива
            Scanner input = new Scanner(System.in);
            Random rnd = new Random();
            System.out.print("Генерация массива: \n");
            int[][] massiv = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j<n; j++) {
                    massiv[i][j] = rnd.nextInt(100);
                    System.out.print(massiv[i][j] + "\t");
                }
                System.out.print("\n");
            }
            return massiv;
        }
    }