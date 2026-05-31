package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Організатор")
public class OrganizerDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Ivan", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String firstName;

    @Schema(example = "Petrov", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String lastName;

    @Schema(example = "ivan@mail.com")
    @Email
    private String email;

    @Schema(example = "+380991112233")
    private String phone;
}