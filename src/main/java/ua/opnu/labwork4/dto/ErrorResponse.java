package ua.opnu.labwork4.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Помилка API")
public class ErrorResponse {

    @Schema(example = "404")
    public int status;

    @Schema(example = "Resource not found")
    public String message;

    @Schema(example = "2026-05-31T12:00:00")
    public String timestamp;
}