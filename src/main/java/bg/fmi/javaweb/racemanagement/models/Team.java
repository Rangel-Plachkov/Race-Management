package bg.fmi.javaweb.racemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.ArrayList;

@Data
@Entity
public class Team {

    @Id
    @NotNull(message = "Team: name can't be null")
    @NotBlank(message = "Team: name need to have minimum 1 non-white space character")
    @Size(max = 32, message = "Team: Team's name need to be maximum of 32 characters length")
    private String name;

    @NotNull(message = "Team: racers can't be null")
    @OneToMany(mappedBy = "team")
    ArrayList<Racer> racers;


    public Team(String name) {
        setName(name);
        racers = new ArrayList<>();
    }

    public Team() {
    }
    @Override
    public String toString() {
        return String.format("Team: %s, %d racers", name, racers.size());
    }


}
