import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class WebScanner {
    private LinkedList<URL_Depth> Scanned=new LinkedList<URL_Depth>();
    private LinkedList<URL_Depth> NotScanned=new LinkedList<URL_Depth>();
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        URL_Reader scan = new URL_Reader();
        URL_Depth site = new URL_Depth(scanner.nextLine(),scanner.nextInt());
        WebScanner ai = new WebScanner();
        ai.addNotScanned(site);
        while (!ai.getNotScanned().isEmpty())
        {
            scan.Reading(ai.getNotScanned().getFirst(),ai);
        }
        try{
            File file = new File("Links.txt");
            FileWriter write = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(write);
            String line;
            for (URL_Depth lines:ai.getScanned()) {
                line = lines.getURL() + " " + String.valueOf(lines.getURL()) + "\n";
                write.write(line);
                System.out.println(lines.getURL());
            }
            write.close();

        }
        catch (IOException ex2){
            ex2.printStackTrace();
        }
    }
    public LinkedList<URL_Depth> getNotScanned() {return NotScanned;}
    public LinkedList<URL_Depth> getScanned() {return Scanned;}
    public void addScanned(URL_Depth site) {Scanned.add(site);}
    public void addNotScanned(URL_Depth site) {NotScanned.add(site);}
    public void remove() {this.NotScanned.removeFirst();}
}