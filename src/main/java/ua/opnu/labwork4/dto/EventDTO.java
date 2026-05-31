package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Подія")
public class EventDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(
            example = "Tech Conference",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank
    private String title;

    @Schema(example = "ACTIVE")
    private String status;
}