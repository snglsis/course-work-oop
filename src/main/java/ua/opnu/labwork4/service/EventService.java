package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.entity.Building;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.entity.Hall;
import ua.opnu.labwork4.entity.Organizer;
import ua.opnu.labwork4.enums.EventStatus;
import ua.opnu.labwork4.repository.BuildingRepository;
import ua.opnu.labwork4.repository.EventRepository;
import ua.opnu.labwork4.repository.HallRepository;
import ua.opnu.labwork4.repository.OrganizerRepository;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final HallRepository hallRepository;
    private final BuildingRepository buildingRepository;
    private final OrganizerRepository organizerRepository;

    public EventService(EventRepository eventRepository,
                        HallRepository hallRepository,
                        BuildingRepository buildingRepository,
                        OrganizerRepository organizerRepository) {
        this.eventRepository = eventRepository;
        this.hallRepository = hallRepository;
        this.buildingRepository = buildingRepository;
        this.organizerRepository = organizerRepository;
    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found: " + id));
    }

    public Event update(Long id, Event updated) {
        Event existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setStartTime(updated.getStartTime());
        existing.setEndTime(updated.getEndTime());
        existing.setStatus(updated.getStatus());
        return eventRepository.save(existing);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getByStatus(EventStatus status) {
        return eventRepository.findByStatus(status);
    }

    public List<Event> searchByTitle(String query) {
        return eventRepository.findByTitleContainingIgnoreCase(query);
    }

    public Event assignHall(Long eventId, Long hallId) {
        Event event = getById(eventId);
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(() -> new RuntimeException("Hall not found: " + hallId));
        event.setHall(hall);
        return eventRepository.save(event);
    }

    public Event assignBuilding(Long eventId, Long buildingId) {
        Event event = getById(eventId);
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found: " + buildingId));
        event.setBuilding(building);
        return eventRepository.save(event);
    }

    public Event assignOrganizer(Long eventId, Long organizerId) {
        Event event = getById(eventId);
        Organizer organizer = organizerRepository.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("Organizer not found: " + organizerId));
        event.setOrganizer(organizer);
        return eventRepository.save(event);
    }

    public List<Event> getByHall(Long hallId) {
        return eventRepository.findByHallId(hallId);
    }

    public List<Event> getByBuilding(Long buildingId) {
        return eventRepository.findByBuildingId(buildingId);
    }
}