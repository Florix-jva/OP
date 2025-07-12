package flightZones;

public class Zone extends Location implements Comparable<Zone>{
    private final String name;

    public Zone(String name, double latitude, double longitude) {
        super(latitude, longitude);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int compareTo(Zone other) {
        return this.name.compareTo(other.name); //returns 1 if other is lexicographical greater than this
    }
}
