import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
public class AStarApp {
    private int width;
    private int height;
    private Location startLoc;
    private Location finishLoc;
    private boolean aStar = true;

    private JMapCell[][] mapCells;

    private static class MapCellHandler implements MouseListener {
        private boolean modifying;
        private boolean makePassable;
        public void mousePressed(MouseEvent e) {
            modifying = true;
            JMapCell cell = (JMapCell) e.getSource();
            makePassable = !cell.isPassable();
            cell.setPassable(makePassable);
        }
        public void mouseReleased(MouseEvent e)
        {
            modifying = false;
        }

        public void mouseEntered(MouseEvent e) {
            if (modifying) {
                JMapCell cell = (JMapCell) e.getSource();
                cell.setPassable(makePassable);
            }
        }
        public void mouseExited(MouseEvent e) {
        }
        public void mouseClicked(MouseEvent e) {
        }
    }

    public AStarApp(int w, int h) {
        if (w <= 0)
            throw new IllegalArgumentException("w must be > 0; got " + w);

        if (h <= 0)
            throw new IllegalArgumentException("h must be > 0; got " + h);
        width = w;
        height = h;
        startLoc = new Location(2, h / 2);
        finishLoc = new Location(w - 3, h / 5);
    }

    private void initGUI() {
        JFrame frame = new JFrame("Поиск пути");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        contentPane.setLayout(new BorderLayout());
        GridBagLayout gbLayout = new GridBagLayout();
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.weightx = 1;
        gbConstraints.weighty = 1;
        gbConstraints.insets.set(0, 0, 1, 1);
        JPanel mapPanel = new JPanel(gbLayout);
        mapPanel.setBackground(Color.GRAY);
        mapCells = new JMapCell[width][height];
        MapCellHandler cellHandler = new MapCellHandler();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapCells[x][y] = new JMapCell();
                gbConstraints.gridx = x;
                gbConstraints.gridy = y;
                gbLayout.setConstraints(mapCells[x][y], gbConstraints);
                mapPanel.add(mapCells[x][y]);
                mapCells[x][y].addMouseListener(cellHandler);
            }
        }
        contentPane.add(mapPanel, BorderLayout.CENTER);
        JButton findPathButton = new JButton("Найти путь");
        JComboBox switchButton = new JComboBox();
        switchButton.addItem("A* алгоритм");
        switchButton.addItem("Двухлучевой алгоритм");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aStar = Objects.equals(switchButton.getSelectedItem(), "A*");
            }
        });
        findPathButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { findAndShowPath(); }
        });
        contentPane.add(findPathButton, BorderLayout.SOUTH);
        contentPane.add(switchButton, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
        mapCells[startLoc.xCoord][startLoc.yCoord].setEndpoint(true);
        mapCells[finishLoc.xCoord][finishLoc.yCoord].setEndpoint(true);
    }

    private void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { initGUI(); }
        });
    }

    private void findAndShowPath() {
        Map2D map = new Map2D(width, height);
        map.setStart(startLoc);
        map.setFinish(finishLoc);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapCells[x][y].setPath(false);

                if (mapCells[x][y].isPassable())
                    map.setCellValue(x, y, 0);
                else
                    map.setCellValue(x, y, Integer.MAX_VALUE);
            }
        }
        if (aStar) {
            long aStarStart = System.nanoTime();
            Waypoint wp = AStarPathfinder.Map(map);
            long aStarEnd = System.nanoTime();
            long aStarDuration = aStarEnd - aStarStart;
            System.out.println("A* алгоритм справился за: " + (aStarDuration / 1000000L) + " мс");
            while (wp != null) {
                Location loc = wp.getLocation();
                mapCells[loc.xCoord][loc.yCoord].setPath(true);
                wp = wp.getPrevious();
            }
            return;
        }
        DualBeamAlgorithm pathfinder = new DualBeamAlgorithm(map.getStart(), map.getFinish());
        long twoBeamStart = System.nanoTime();
        List<Location> locations = DualBeamAlgorithm.schetPuti(map);
        long twoBeamEnd = System.nanoTime();
        long twoBeamDuration = twoBeamEnd - twoBeamStart;
        System.out.println("Двухлучевой алгоритм справился: " + (twoBeamDuration / 1000000L) + " ms");
        for (Location loc : locations)
        {
            mapCells[loc.xCoord][loc.yCoord].setBackground(Color.BLUE);
        }
        List<Location> intersected = pathfinder.vsePeresechenie();
        for (Location loc : intersected)
        {
            mapCells[loc.xCoord][loc.yCoord].setBackground(Color.GREEN);
        }
        mapCells[map.getStart().xCoord][map.getStart().yCoord].setBackground(Color.CYAN);
        mapCells[map.getFinish().xCoord][map.getFinish().yCoord].setBackground(Color.CYAN);
    }

    public static void main(String[] args) {
        AStarApp app = new AStarApp(40, 30);
        app.start();
    }
}

