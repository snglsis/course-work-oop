package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Будівля")
public class BuildingDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(
            description = "Назва будівлі",
            example = "Головний корпус",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank
    private String name;

    @Schema(example = "Одеса")
    private String city;

    @Schema(example = "вул. Дерибасівська 1")
    private String address;
}