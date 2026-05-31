package ua.opnu.labwork4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Головна", description = "API інформація")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
                Welcome to Labwork 3 API

                Available endpoints:
                /buildings
                /events
                /halls
                /equipment
                /organizers
                /analytics
                /search
                """;
    }
}