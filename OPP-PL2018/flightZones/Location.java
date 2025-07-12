package flightZones;

public class Location implements Locatable {
    private double latitude, longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public static double distanceMeter(Locatable a, Locatable b) {
        double deltaX = 111.3 * Math.cos((((a.getLatitude() + b.getLatitude())/360)*2*Math.PI) / 2) * Math.abs(a.getLongitude() - b.getLongitude());      // attention: cos wants rad not deg!!!
        double deltaY = 111.3 * Math.abs(a.getLatitude() - b.getLatitude());

        return 1000 * Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
    }
}
