import java.util.LinkedList;

public class URLPool {

    private LinkedList<URLDepthPair> Done = new LinkedList<URLDepthPair>();
    private LinkedList<URLDepthPair> NotDone = new LinkedList<URLDepthPair>();
    private int Depth;
    private int Waiting;
    private int Threads;

    public URLPool(String url, int depth, int threads) {
        NotDone.add(new URLDepthPair(url, depth));
        Depth = depth;
        Threads = threads;
    }

    public synchronized URLDepthPair get() throws InterruptedException {
        if (isEmpty()) {
            Waiting++;
            if (Waiting == Threads) {
                getSites();
                System.exit(0);
            }
            wait();
        }
        return NotDone.removeFirst();
    }
    public synchronized void addNotProcessed(URLDepthPair pair) {
        NotDone.add(pair);
        if (Waiting > 0) {
            Waiting--;
            notify();
        }
    }

    private boolean isEmpty() {
        return NotDone.size() == 0;
    }

    public void getSites() {
        System.out.println("Depth: " + Depth);
        for (URLDepthPair urlDepthPair : Done) {
            System.out.println(Depth - urlDepthPair.getDepth() + " " + urlDepthPair.getURL());
        }
        System.out.println("Links visited: " + Done.size());
    }


    public void addProcessed(URLDepthPair pair) {
        Done.add(pair);
    }

    public LinkedList<URLDepthPair> getProcessed()
    {
        return Done;
    }

    public LinkedList<URLDepthPair> getNotProcessed()
    {
        return NotDone;
    }

}