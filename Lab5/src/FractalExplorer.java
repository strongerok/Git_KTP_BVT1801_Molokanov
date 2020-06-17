import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class FractalExplorer {
    private int size;
    private JFrame frame;
    public JImageDisplay img;
    private JButton resetButton;
    private JButton saveButton;
    private JComboBox combobox;
    public FractalExplorer(int s) {
        size = s;
        generator.getInitialRange(range);
    }
    FractalGenerator generator = new Mandelbrot();
    Rectangle2D.Double range = new Rectangle2D.Double();
    public void createAndShowGUI() {
        JPanel Npanel = new JPanel();
        JPanel Spanel = new JPanel();
        frame = new JFrame();
        img = new JImageDisplay(size, size);
        resetButton = new JButton("Reset Display");
        saveButton = new JButton("Save Image");
        combobox = new JComboBox();
        combobox.addItem(new Mandelbrot());
        combobox.addItem(new Tricorn());
        combobox.addItem(new BurningShip());
        frame.getContentPane().add(Npanel, BorderLayout.NORTH);
        frame.getContentPane().add(Spanel, BorderLayout.SOUTH);
        JLabel label = new JLabel("Fractal type:");
        Npanel.add(label);
        Npanel.add(combobox);
        Spanel.add(resetButton);
        Spanel.add(saveButton);
        frame.getContentPane().add(img, BorderLayout.CENTER);
        //frame.getContentPane().add(resetButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        combobox.addActionListener(new actionListener());
        resetButton.addActionListener(new actionListener());  //Сброс
        saveButton.addActionListener(new actionListener());
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
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource() == combobox) {
                generator = (FractalGenerator) combobox.getSelectedItem();
                generator.getInitialRange(range);
                drawFrac();
            }
            else if (actionEvent.getSource() == resetButton) {
                generator.getInitialRange(range);
                drawFrac();
            }
            else if (actionEvent.getSource() == saveButton) {
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showSaveDialog(img) == JFileChooser.APPROVE_OPTION) {
                    try {
                        ImageIO.write(img.img, "png", chooser.getSelectedFile());
                    } catch (IOException exc) {
                        JOptionPane.showMessageDialog(frame, exc.getMessage(), "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
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
