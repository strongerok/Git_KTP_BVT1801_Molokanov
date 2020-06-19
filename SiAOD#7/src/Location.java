public class Location {
    public int xCoord;
    public int yCoord;

    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public Location()
    {
        this(0, 0);
    }

    public boolean equals(Object ob) {
        if (ob instanceof Location) {
            Location loc= (Location) ob;
            return xCoord == loc.xCoord && yCoord == loc.yCoord;
        }
        return false;
    }
    public int hashcode() {
        return 37*(37*17+xCoord)+yCoord;
    }
}
