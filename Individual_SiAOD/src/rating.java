import java.util.Scanner;

public class rating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] massiv = new int[a];
        for (int i = 0; i < a; i++) {
            massiv[i] = sc.nextInt();
        }
        long startTime = System.currentTimeMillis();
        for (int j =0; j < a; j++) {
            System.out.println(unfairness(massiv[j]));
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println("время выполнения = " + time + "ms");
    }

    public static String toBinary(int x) {
        return Integer.toString(x,2);
    }

    public static int unfairness(int x) {
        int count = 0;
        String[] massiv = new String[x+1];
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = toBinary(i);
        }
        for (int j = 0; j < massiv.length - 1; j++) {
            if (massiv[j].length() < massiv[j+1].length()) massiv[j] = "0" + massiv[j];
            for (int k = 0; k < massiv[j].length(); k++) {
                if (massiv[j].charAt(k) != massiv[j+1].charAt(k)) count++;
            }
        }
        return count;
    }
}
