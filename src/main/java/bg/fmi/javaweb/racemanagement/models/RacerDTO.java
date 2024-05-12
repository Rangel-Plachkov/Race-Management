package bg.fmi.javaweb.racemanagement.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;


import lombok.Data;
import lombok.NonNull;


@Data
public class RacerDTO {

    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "First name must be less than 50 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First name must contain only letters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50, message = "Last name must be less than 50 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Last name must contain only letters")
    private String lastName;

    @NonNull
    @Min(value = 0, message = "Age must be non-negative")
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
