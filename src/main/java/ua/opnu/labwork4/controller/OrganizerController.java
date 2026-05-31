package ua.opnu.labwork4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.entity.Organizer;
import ua.opnu.labwork4.service.OrganizerService;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@RestController
@Tag(name = "Організатори", description = "CRUD організаторів")
@RequestMapping("/organizers")
public class OrganizerController {

    private final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @PostMapping
    public ResponseEntity<Organizer> create(@RequestBody Organizer organizer) {
        return ResponseEntity.ok(organizerService.create(organizer));
    }

    @GetMapping
    public ResponseEntity<List<Organizer>> getAll() {
        return ResponseEntity.ok(organizerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizerService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizer> update(@PathVariable Long id,
                                            @RequestBody Organizer organizer) {
        return ResponseEntity.ok(organizerService.update(id, organizer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Зв'язок: події організатора
    @GetMapping("/{id}/events")
    public ResponseEntity<List<Event>> getEvents(@PathVariable Long id) {
        return ResponseEntity.ok(organizerService.getEvents(id));
    }
}