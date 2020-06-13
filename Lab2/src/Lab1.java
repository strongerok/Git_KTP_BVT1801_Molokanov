import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите координаты 1 точки");
        Point3d dot1 = new Point3d(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        System.out.println("введите координаты 2 точки");
        Point3d dot2 = new Point3d(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        System.out.println("введите координаты 3 точки");
        Point3d dot3 = new Point3d(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        if (Point3d.Equals(dot1, dot2) || Point3d.Equals(dot1, dot3) || Point3d.Equals(dot2, dot3))
            System.out.println("2 или больше точек совпадают, это не треугольник");
        else System.out.println(computeArea(dot1, dot2, dot3));
}

    public static double computeArea(Point3d a, Point3d b, Point3d c) {
        double x = Point3d.distanceTo(a, b);
        double y = Point3d.distanceTo(a, c);
        double z = Point3d.distanceTo(b, c);
        double p = (x+y+z)/2;
        return Math.sqrt(p*(p - x)*(p-y)*(p-z));
    }
}
