package bg.fmi.javaweb.racemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull(message = "Track: name can't be null")
    @NotBlank(message = "Track: name need to have minimum 1 non-white space character")
    private String name;


    @Min(value = 0, message = "Track: length can't be negative")
    private Integer length; //in meters

    public Track() {
    }

    public Track(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("Track %d: %s, %d meters", ID, name, length);
    }


}
