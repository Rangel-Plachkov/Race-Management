package bg.fmi.javaweb.racemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Racer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull(message = "Racer: firstName can't be null")
    @NotBlank(message = "Racer: firstName need to have minimum 1 non-white space character")
    private String firstName;

    @NotNull(message = "Racer: lastName can't be null")
    @NotBlank(message = "Racer: lastName need to have minimum 1 non-white space character")
    private String lastName;

    @NotNull(message = "Racer: age can't be null")
    @Min(value = 0, message = "Racer: age can't be negative")
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    Team team;

    public Racer() {
    }
    public Racer(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("Racer %d: %s %s, %d years old\n", ID, firstName, lastName, age);
    }

}
