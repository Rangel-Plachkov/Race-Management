package bg.fmi.javaweb.racemanagement.models;

import lombok.Data;
import lombok.Getter;

@Getter
public class RacerDTO {
    private String firstName;
    private String lastName;
    private Integer age;

    public RacerDTO(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public RacerDTO() {
    }
    @Override
    public String toString() {
        return "RacerDTO{" +
                "name='" + firstName     + '\'' +
                ", team='" + lastName + '\'' +
                ", car='" + age + '\'' +
                '}';
    }
}
