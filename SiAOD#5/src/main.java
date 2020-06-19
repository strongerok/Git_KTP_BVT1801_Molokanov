import javax.swing.JFrame;
public class main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Салфетка Серпинского"); //титульник окна
        f.setSize(800, 600); //высота и ширина окна
        f.setResizable(false);
        int deep = 5; //глубина
        f.add(new serpinsky(f.getSize(), deep));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
