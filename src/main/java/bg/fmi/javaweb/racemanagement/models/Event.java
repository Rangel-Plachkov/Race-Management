package bg.fmi.javaweb.racemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull(message = "Event: name can't be null")
    @NotBlank(message = "Event: name need to have minimum 1 non-white space character")
    private String name;

    @NotNull(message = "Event: track can't be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id")
    private Track track;

    @NotNull(message = "Event: teams can't be null")
    @ManyToMany
    @JoinTable(
            name = "Event_Team",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id")}
    )
    private ArrayList<Team> teams;


    @NotNull(message = "Event: date can't be null")
    private LocalDate date;

    public Event() {
    }
    public Event(String name, Track track, ArrayList<Team> teams, LocalDate date) {
        this.name = name;
        this.track = track;
        this.teams = teams;
        this.date = date;
    }
    public Event(String name, Track track, LocalDate date) {
        this.name = name;
        this.track = track;
        this.date = date;
    }
    @Override
    public String toString() {
        return String.format("Event %d: %s, %s, %d teams, %s", ID, name, track, teams.size(), date);
    }
}
