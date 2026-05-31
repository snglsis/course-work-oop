package ua.opnu.labwork4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.enums.EventStatus;
import ua.opnu.labwork4.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
@Tag(name = "Події", description = "Управління подіями: створення, редагування, призначення ресурсів")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // ================= CREATE =================
    @Operation(
            summary = "Створити подію",
            description = "Створює нову подію з назвою, статусом та датами"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Подію створено успішно"),
            @ApiResponse(responseCode = "400", description = "Некоректні дані")
    })
    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.create(event));
    }

    // ================= GET ALL =================
    @Operation(summary = "Отримати всі події")
    @ApiResponse(responseCode = "200", description = "Список подій")
    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(eventService.getAll());
    }

    // ================= GET BY ID =================
    @Operation(summary = "Отримати подію за ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Подію знайдено"),
            @ApiResponse(responseCode = "404", description = "Подію не знайдено")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getById(id));
    }

    // ================= UPDATE =================
    @Operation(summary = "Оновити подію")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Подію оновлено"),
            @ApiResponse(responseCode = "400", description = "Помилка валідації")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable Long id,
                                        @RequestBody Event event) {
        return ResponseEntity.ok(eventService.update(id, event));
    }

    // ================= DELETE =================
    @Operation(summary = "Видалити подію")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Подію видалено"),
            @ApiResponse(responseCode = "404", description = "Подію не знайдено")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ================= ACTIVE EVENTS =================
    @Operation(summary = "Отримати активні події")
    @ApiResponse(responseCode = "200", description = "Список активних подій")
    @GetMapping("/active")
    public ResponseEntity<List<Event>> getActive() {
        return ResponseEntity.ok(eventService.getByStatus(EventStatus.ACTIVE));
    }

    // ================= ASSIGN HALL =================
    @Operation(summary = "Призначити зал події")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Зал призначено"),
            @ApiResponse(responseCode = "404", description = "Подію або зал не знайдено")
    })
    @PutMapping("/{eventId}/hall/{hallId}")
    public ResponseEntity<Event> assignHall(@PathVariable Long eventId,
                                            @PathVariable Long hallId) {
        return ResponseEntity.ok(eventService.assignHall(eventId, hallId));
    }

    // ================= ASSIGN BUILDING =================
    @Operation(summary = "Призначити будівлю події")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Будівлю призначено"),
            @ApiResponse(responseCode = "404", description = "Подію або будівлю не знайдено")
    })
    @PutMapping("/{eventId}/building/{buildingId}")
    public ResponseEntity<Event> assignBuilding(@PathVariable Long eventId,
                                                @PathVariable Long buildingId) {
        return ResponseEntity.ok(eventService.assignBuilding(eventId, buildingId));
    }

    // ================= ASSIGN ORGANIZER =================
    @Operation(summary = "Призначити організатора події")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Організатора призначено"),
            @ApiResponse(responseCode = "404", description = "Подію або організатора не знайдено")
    })
    @PutMapping("/{eventId}/organizer/{organizerId}")
    public ResponseEntity<Event> assignOrganizer(@PathVariable Long eventId,
                                                 @PathVariable Long organizerId) {
        return ResponseEntity.ok(eventService.assignOrganizer(eventId, organizerId));
    }
}