package flightZones;

import java.util.ArrayList;

public class ZoneMap {
    private final ArrayList<Zone> zones = new ArrayList<>();

    public void addZone(Zone zone) {
        if(zones.isEmpty()){
            zones.add(zone);
            return;
        }
        else {
            for (int i = 0; i < zones.toArray().length; i++) {
                int compare = zones.get(i).compareTo(zone);
                if (compare > 0) {
                    zones.add(i, zone);
                    return;
                }
            }
        }
        zones.add(zone);
        return;
    }

    public boolean containsZone(Zone zone) {
        return zones.contains(zone);
    }

    public Zone nearestZone(Quadcopter copter) {
        double distance, minDistance = 0;
        Zone minDistanceZone = zones.get(0);
        for (Zone zone : zones) {
            distance = zone.distanceMeter(copter,zone);
            if(distance < minDistance){
                minDistance = distance;
                minDistanceZone = zone;
            }
        }
        return minDistanceZone;
    }

    public String toString() {
        String returning = "Map (" + String.valueOf(zones.size()) + " flight zones):\n";
//
//        if(zones.isEmpty()){
//            return returning;
//        }
//        else {
            for (Zone zone : zones) {
                returning += "- " + zone + "\n";
            }
//        }
        return returning;
    }
}
