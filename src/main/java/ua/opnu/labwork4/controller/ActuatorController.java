package ua.opnu.labwork4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/actuator")
@Tag(name = "Системні ендпоінти", description = "Моніторинг")
public class ActuatorController {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Service is UP");
    }

    @GetMapping("/metrics")
    public ResponseEntity<String> metrics() {
        return ResponseEntity.ok("GET /actuator/metrics OK");
    }

    @GetMapping("/prometheus")
    public ResponseEntity<String> prometheus() {
        return ResponseEntity.ok("GET /actuator/prometheus OK");
    }
}