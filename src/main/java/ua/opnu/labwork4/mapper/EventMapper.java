package ua.opnu.labwork4.mapper;

import ua.opnu.labwork4.dto.EventDTO;
import ua.opnu.labwork4.entity.Event;

public class EventMapper {

    public static EventDTO toDTO(Event event) {
        if (event == null) return null;
        return new EventDTO(
                event.getId(),
                event.getTitle(),
                event.getStartTime(),
                event.getEndTime(),
                event.getStatus(),
                event.getOrganizer() != null ? event.getOrganizer().getId() : null,
                event.getHall()      != null ? event.getHall().getId()      : null,
                event.getBuilding()  != null ? event.getBuilding().getId()  : null
        );
    }

    public static Event toEntity(EventDTO dto) {
        if (dto == null) return null;
        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setStartTime(dto.getStartTime());
        event.setEndTime(dto.getEndTime());
        event.setStatus(dto.getStatus());
        // hall / building / organizer встановлюються у EventService
        return event;
    }
}
