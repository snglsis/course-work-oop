package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Schema(example = "2026-06-01T10:00:00")
    private LocalDateTime startTime;

    @Schema(example = "2026-06-01T18:00:00")
    private LocalDateTime endTime;

    @Schema(example = "ACTIVE")
    private String status;

    @Schema(example = "1")
    private Long organizerId;

    @Schema(example = "1")
    private Long hallId;

    @Schema(example = "1")
    private Long buildingId;
}