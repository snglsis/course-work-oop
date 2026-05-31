package ua.opnu.labwork4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork4.entity.Building;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.entity.Hall;
import ua.opnu.labwork4.service.BuildingService;
import ua.opnu.labwork4.service.EventService;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@Tag(name = "Будівлі", description = "CRUD будівель")

@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Створено"),
        @ApiResponse(responseCode = "400", description = "Помилка")
})
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingService buildingService;
    private final EventService eventService;

    public BuildingController(BuildingService buildingService, EventService eventService) {
        this.buildingService = buildingService;
        this.eventService = eventService;
    }
    @Operation(summary = "Створити будівлю")
    @PostMapping
    public ResponseEntity<Building> create(@RequestBody Building building) {
        return ResponseEntity.ok(buildingService.create(building));
    }

    @GetMapping
    public ResponseEntity<List<Building>> getAll() {
        return ResponseEntity.ok(buildingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getById(@PathVariable Long id) {
        return ResponseEntity.ok(buildingService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Building> update(@PathVariable Long id,
                                           @RequestBody Building building) {
        return ResponseEntity.ok(buildingService.update(id, building));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        buildingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Зв'язок: отримати зали будівлі
    @GetMapping("/{id}/halls")
    public ResponseEntity<List<Hall>> getHalls(@PathVariable Long id) {
        return ResponseEntity.ok(buildingService.getHalls(id));
    }

    // Зв'язок: отримати події будівлі
    @GetMapping("/{id}/events")
    public ResponseEntity<List<Event>> getEvents(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getByBuilding(id));
    }
}