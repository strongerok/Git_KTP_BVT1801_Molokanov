import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int size;
    private JFrame frame;
    private JImageDisplay img;
    private JButton button;
    public FractalExplorer(int s) {
        size = s;
        generator.getInitialRange(range);
    }
    FractalGenerator generator = new Mandelbrot();
    Rectangle2D.Double range = new Rectangle2D.Double();
    public void createAndShowGUI() {
        frame = new JFrame();
        img = new JImageDisplay(size, size);
        button = new JButton("Reset");

        frame.getContentPane().add(img, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        button.addActionListener(new C6poc());  //Сброс
        img.addMouseListener(new KJIUK());      //Клик

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
    }
    private void drawFrac() {
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                double xCoord = FractalGenerator.getCoord
                        (range.x, range.x + range.width, size, x);
                double yCoord = FractalGenerator.getCoord
                        (range.y, range.y + range.height, size, y);
                int IterNum = generator.numIterations(xCoord, yCoord);
                if (IterNum == -1) img.drawPixel(x, y, 0);
                else {
                    float hue = 0.7f + (float) IterNum / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    img.drawPixel(x, y, rgbColor);
                }
            }
        }
        img.repaint();
    }
    private class C6poc implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            generator.getInitialRange(range);
            drawFrac();
        }
    }

    private class KJIUK extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            double xCoord = generator.getCoord(range.x,range.x+range.width, size, x);
            double yCoord = generator.getCoord(range.y,range.y+range.height, size, y);
            generator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFrac();
        }
    }

    public static void main(String[] args) {
        FractalExplorer fractalItself = new FractalExplorer(800);
        fractalItself.createAndShowGUI();
        fractalItself.drawFrac();
    }
}
