package ie.atu.cicd1_exam_19;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor @Builder
public class Vehicle {

    @NotBlank
    private String driverName;

    @Pattern(regexp = "[0-9]{2,3}-[A-Z]{1,2}-[0-9]{1,6}")
    private String reg;

    @Email
    private String Email;

    @Size(min = 1, max = 8)
    private int passengers;

}
