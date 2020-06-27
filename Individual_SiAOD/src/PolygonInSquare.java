import java.util.Scanner;
import java.math.*;

public class PolygonInSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] massiv = new int[a];
        for (int i = 0; i < a; i++) {
            massiv[i] = sc.nextInt();
        }
        long startTime = System.currentTimeMillis();
        for (int j =0; j < a; j++) {
            System.out.println(polygonIntoSquare(massiv[j]));
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println("время выполнения = " + time + "ms");
    }

    public static double polygonIntoSquare(int x) {
        x = 2*x;
        double radius = 1 / (2 * Math.tan(Math.PI/x));
        return 2*radius;
    }
}
