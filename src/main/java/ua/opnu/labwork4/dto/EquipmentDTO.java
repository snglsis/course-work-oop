package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Обладнання")
public class EquipmentDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(
            example = "Projector Epson",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank
    private String name;

    @Schema(example = "Full HD projector")
    private String description;
}