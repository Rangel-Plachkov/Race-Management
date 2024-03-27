package bg.fmi.javaweb.racemanagement3.models;

import java.util.ArrayList;

@SuppressWarnings("UnusedDeclaration")
public class Team {
    private static final String DEFAULT_NAME = "Unknown models.Team";
    private String name;
    private final ArrayList<Racer> racers;

    public Team() {
        setName(DEFAULT_NAME);
        racers = new ArrayList<>();
    }
    public Team(String name) {
        setName(name);
        racers = new ArrayList<>();
    }


    public void setName(String name) {
        this.name = (name != null && !name.isEmpty() ? name : DEFAULT_NAME);
    }
    public String getName() {
        return name;
    }
    public void addRacer(Racer racer) {
        racers.add(racer);
    }
    public void removeRacer(Racer racer) {
        racers.remove(racer);
    }
    public ArrayList<Racer> getRacers() {
        return racers;
    }
    @Override
    public String toString() {
        return String.format("models.Team: %s, %d racers", name, racers.size());
    }


}
