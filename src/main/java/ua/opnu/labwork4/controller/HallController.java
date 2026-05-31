package ua.opnu.labwork4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork4.entity.Equipment;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.entity.Hall;
import ua.opnu.labwork4.service.EventService;
import ua.opnu.labwork4.service.HallService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@Tag(name = "Зали", description = "CRUD залів")
@RequestMapping("/halls")
public class HallController {

    private final HallService hallService;
    private final EventService eventService;

    public HallController(HallService hallService, EventService eventService) {
        this.hallService = hallService;
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Hall> create(@RequestBody Hall hall) {
        return ResponseEntity.ok(hallService.create(hall));
    }

    @GetMapping
    public ResponseEntity<List<Hall>> getAll() {
        return ResponseEntity.ok(hallService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getById(@PathVariable Long id) {
        return ResponseEntity.ok(hallService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hall> update(@PathVariable Long id, @RequestBody Hall hall) {
        return ResponseEntity.ok(hallService.update(id, hall));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hallService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /halls/building/{buildingId} — зали будівлі
    @GetMapping("/building/{buildingId}")
    public ResponseEntity<List<Hall>> getByBuilding(@PathVariable Long buildingId) {
        return ResponseEntity.ok(hallService.getByBuilding(buildingId));
    }

    // GET /halls/{id}/equipment — обладнання залу
    @GetMapping("/{id}/equipment")
    public ResponseEntity<List<Equipment>> getEquipment(@PathVariable Long id) {
        return ResponseEntity.ok(hallService.getEquipment(id));
    }

    // GET /halls/{id}/events — події в залі
    @GetMapping("/{id}/events")
    public ResponseEntity<List<Event>> getEvents(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getByHall(id));
    }

    // POST /halls/{id}/equipment/{equipmentId} — додати обладнання
    @PostMapping("/{id}/equipment/{equipmentId}")
    public ResponseEntity<Hall> addEquipment(@PathVariable Long id,
                                             @PathVariable Long equipmentId) {
        return ResponseEntity.ok(hallService.addEquipment(id, equipmentId));
    }

    // DELETE /halls/{id}/equipment/{equipmentId} — видалити обладнання
    @DeleteMapping("/{id}/equipment/{equipmentId}")
    public ResponseEntity<Hall> removeEquipment(@PathVariable Long id,
                                                @PathVariable Long equipmentId) {
        return ResponseEntity.ok(hallService.removeEquipment(id, equipmentId));
    }

    // Призначити будівлю залу
    @PutMapping("/{hallId}/building/{buildingId}")
    public ResponseEntity<Hall> assignBuilding(@PathVariable Long hallId,
                                               @PathVariable Long buildingId) {
        return ResponseEntity.ok(hallService.assignBuilding(hallId, buildingId));
    }
}