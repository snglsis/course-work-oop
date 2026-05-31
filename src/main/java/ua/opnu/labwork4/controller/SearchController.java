package ua.opnu.labwork4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.entity.Hall;
import ua.opnu.labwork4.entity.Organizer;
import ua.opnu.labwork4.service.EventService;
import ua.opnu.labwork4.service.HallService;
import ua.opnu.labwork4.service.OrganizerService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/search")
@Tag(name = "Пошук", description = "Пошук у системі")

public class SearchController {

    private final EventService eventService;
    private final OrganizerService organizerService;
    private final HallService hallService;

    public SearchController(EventService eventService,
                            OrganizerService organizerService,
                            HallService hallService) {
        this.eventService = eventService;
        this.organizerService = organizerService;
        this.hallService = hallService;
    }

    // GET /search/events?query=...
    @GetMapping("/events")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam String query) {
        return ResponseEntity.ok(eventService.searchByTitle(query));
    }

    // GET /search/organizers?query=...
    @GetMapping("/organizers")
    public ResponseEntity<List<Organizer>> searchOrganizers(@RequestParam String query) {
        return ResponseEntity.ok(organizerService.search(query));
    }

    // GET /search/halls?query=...
    @GetMapping("/halls")
    public ResponseEntity<List<Hall>> searchHalls(@RequestParam String query) {
        return ResponseEntity.ok(hallService.searchByName(query));
    }
}