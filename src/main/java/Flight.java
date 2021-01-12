import java.util.*;

public abstract class Flight {
    private String id;
    Set<Passenger> passengersSet = new HashSet<>();
    private int distance;

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengersSet() {
        return Collections.unmodifiableSet(passengersSet);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

    public int getDistance() {
        return distance;
    }
}

