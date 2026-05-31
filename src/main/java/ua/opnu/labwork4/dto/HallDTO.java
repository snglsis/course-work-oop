package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Зал")
public class HallDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "A101", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String name;

    @Schema(example = "120")
    @Min(1)
    private Integer capacity;

    @Schema(example = "2")
    private Integer floor;
}