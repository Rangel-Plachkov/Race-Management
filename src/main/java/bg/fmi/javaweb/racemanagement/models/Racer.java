package bg.fmi.javaweb.racemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Racer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String firstName;
    private String lastName;
    private Integer age;

    public Racer() {
    }
    public Racer(String firstName, String lastName, Integer age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }
    @Override
    public String toString() {
        return String.format("Racer %d: %s %s, %d years old\n", ID, firstName, lastName, age);
    }

}
