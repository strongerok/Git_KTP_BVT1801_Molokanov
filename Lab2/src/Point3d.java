import java.text.DecimalFormat;

public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d (double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d () {
        this(0.0,0.0,0.0);
    }
    public double getX () {
        return xCoord;
    }
    public double getY () {
        return yCoord;
    }
    public double getZ () {
        return zCoord;
    }

    public void setX ( double val) {
        xCoord = val;
    }
    public void setY ( double val) {
        yCoord = val;
    }
    public void setZ ( double val) {
        zCoord = val;
    }
//проверка на равенство двух точек
    public static boolean Equals (Point3d a, Point3d b) {
        return ((a.getX() == b.getX()) && (a.getY() == b.getY()) && (a.getZ() == b.getZ()));
    }
//вывод расстояния между двумя точками с двумя знаками после запятой
    public static double distanceTo (Point3d a, Point3d b) {
    return (double) ((int) (Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)
            + Math.pow(a.getZ() - b.getZ(), 2))*100))/100;
}
}
