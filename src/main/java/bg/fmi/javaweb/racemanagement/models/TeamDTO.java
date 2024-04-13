package bg.fmi.javaweb.racemanagement.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;

@Data
public class TeamDTO {
    @NotBlank(message = "Team name is mandatory")
    @Size(max = 50, message = "Team name must be less than 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Team name must contain only letters or digits")
    private String name;

    private ArrayList<RacerDTO> racers;

    public TeamDTO() {
        this.name = "Unknown Team";
        this.racers = new ArrayList<>();
    }
    public TeamDTO(String name) {
        this.name = name;
        this.racers = new ArrayList<>();
    }
    public TeamDTO(String name, ArrayList<RacerDTO> racers) {
        this.name = name;
        this.racers = racers;
    }

    @Override
    public String toString() {
        return String.format("Team: %s, %d racers", name, racers.size());
    }
}
