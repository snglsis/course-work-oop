package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Помилка API")
public class ErrorResponse {

    @Schema(example = "404")
    private int status;

    @Schema(example = "Resource not found")
    private String message;

    @Schema(example = "2026-05-31T12:00:00")
    private String timestamp;
}