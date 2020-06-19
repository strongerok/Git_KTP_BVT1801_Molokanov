import javax.swing.*;
import java.awt.*;
public class serpinsky extends JPanel {
    public int deepRec = 0;
    public int deepSer = 0;
    public boolean yn = true;
    public long time;
    public serpinsky(Dimension d, int deepSer1) {
        setSize(d);
        setPreferredSize(d);
        this.deepSer = deepSer1;
    }
    @Override
    public void paintComponent(Graphics g) {
        time = System.currentTimeMillis();
        Graphics2D g2 = (Graphics2D) g;
        Dimension d = getSize();
        Point a = mid(new Point(0, 0), new Point(d.width, 0));
        Point b = new Point(d.width, d.height);
        Point c = new Point(0, d.height);
        Triangle(g2, a, b, c, deepSer);
        time = System.currentTimeMillis() - time;
        if (yn) {
            yn = false;
            System.out.println("Глубина фрактала: " + deepSer + "\n" + "Глубина рекурсии: " + deepRec);
            System.out.println("Время рисовки: " + time + " мс");
        }
    }
    public static Point mid(Point a, Point b) {
        return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
    }
    public void Triangle(Graphics2D g, Point a, Point b, Point c, int deep) { //рисуем треугольник
        if (deep == 0)
            return;
        deepRec++;
        g.drawLine(a.x, a.y, b.x, b.y);
        g.drawLine(b.x, b.y, c.x, c.y);
        g.drawLine(c.x, c.y, a.x, a.y);
        Point ab = mid(a, b);
        Point bc = mid(b, c);
        Point ca = mid(c, a);
        Triangle(g, a, ab, ca, deep - 1);
        Triangle(g, ab, b, bc, deep - 1);
        Triangle(g, c, ca, bc, deep - 1);
    }
}