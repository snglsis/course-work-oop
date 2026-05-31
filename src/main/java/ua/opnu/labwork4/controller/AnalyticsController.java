package ua.opnu.labwork4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.labwork4.enums.EventStatus;
import ua.opnu.labwork4.repository.EventRepository;
import ua.opnu.labwork4.repository.HallRepository;
import ua.opnu.labwork4.repository.OrganizerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Аналітика", description = "Статистика")

@ApiResponse(responseCode = "200")
@RequestMapping("/analytics")
public class AnalyticsController {

    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;
    private final HallRepository hallRepository;

    public AnalyticsController(EventRepository eventRepository,
                               OrganizerRepository organizerRepository,
                               HallRepository hallRepository) {
        this.eventRepository = eventRepository;
        this.organizerRepository = organizerRepository;
        this.hallRepository = hallRepository;
    }
    @Operation(summary = "Кількість подій")
    // GET /analytics/events/count
    @GetMapping("/events/count")
    public ResponseEntity<Map<String, Long>> eventsCount() {
        return ResponseEntity.ok(Map.of("count", eventRepository.count()));
    }

    // GET /analytics/organizers/count
    @GetMapping("/organizers/count")
    public ResponseEntity<Map<String, Long>> organizersCount() {
        return ResponseEntity.ok(Map.of("count", organizerRepository.count()));
    }

    // GET /analytics/events/active
    @GetMapping("/events/active")
    public ResponseEntity<?> activeEvents() {
        return ResponseEntity.ok(eventRepository.findByStatus(EventStatus.ACTIVE));
    }

    // GET /analytics/halls/by-capacity
    @GetMapping("/halls/by-capacity")
    public ResponseEntity<?> hallsByCapacity() {
        return ResponseEntity.ok(hallRepository.findAllByOrderByCapacityDesc());
    }

    // GET /analytics/buildings/workload
    @GetMapping("/buildings/workload")
    public ResponseEntity<?> buildingsWorkload() {
        List<Object[]> raw = eventRepository.countByBuilding();
        List<Map<String, Object>> result = raw.stream().map(row -> {
            Map<String, Object> map = new HashMap<>();
            map.put("building", row[0]);
            map.put("eventCount", row[1]);
            return map;
        }).toList();
        return ResponseEntity.ok(result);
    }
}