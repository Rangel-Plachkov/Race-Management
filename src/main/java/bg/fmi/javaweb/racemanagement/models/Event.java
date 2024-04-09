package bg.fmi.javaweb.racemanagement.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
    private static final String DEFAULT_NAME = "Unknown Event";
    private static final LocalDate DEFAULT_DATE = LocalDate.EPOCH;
    private static Integer nextID = 0;
    private Integer ID;
    private String name;
    private Track track;
    private final ArrayList<Team> teams;
    private LocalDate date;

    public Event() {
        setName(DEFAULT_NAME);
        teams = new ArrayList<>();
        date = LocalDate.now();
    }
    public Event(String name, Track track , ArrayList<Team> teams, LocalDate date) {
        setName(name);
        setTrack(track);
        this.teams = teams;
        setDate(date);
    }
    public Event(String name, Track track, LocalDate date) {
        setName(name);
        setTrack(track);
        teams = new ArrayList<>();
        setDate(date);
    }

    public void setID() {
        ID = nextID;
        nextID++;
    }
    public Integer getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = (name != null && !name.isEmpty() ? name : DEFAULT_NAME);
    }
    public String getName() {
        return name;
    }
    public void setTrack(Track track) {
        this.track = track;
    }
    public Track getTrack() {
        return track;
    }
    public void addTeam(Team team) {
        teams.add(team);
    }
    public void removeTeam(Team team) {
        teams.remove(team);
    }
    public ArrayList<Team> getTeams() {
        return teams;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate() {
        return date;
    }
    @Override
    public String toString() {
        return String.format("Event %d: %s, %s, %d teams, %s", ID, name, track, teams.size(), date);
    }
}
