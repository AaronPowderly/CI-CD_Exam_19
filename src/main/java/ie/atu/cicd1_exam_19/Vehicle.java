package ie.atu.cicd1_exam_19;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    private String regNumber;

    @Email
    private String Email;

    @Size(min = 1, max = 8)
    private int passengers;

}
