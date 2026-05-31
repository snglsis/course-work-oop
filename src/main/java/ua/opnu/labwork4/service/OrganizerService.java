package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.entity.Organizer;
import ua.opnu.labwork4.repository.EventRepository;
import ua.opnu.labwork4.repository.OrganizerRepository;

import java.util.List;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;

    public OrganizerService(OrganizerRepository organizerRepository,
                            EventRepository eventRepository) {
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
    }

    public Organizer create(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public List<Organizer> getAll() {
        return organizerRepository.findAll();
    }

    public Organizer getById(Long id) {
        return organizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer not found: " + id));
    }

    public Organizer update(Long id, Organizer updated) {
        Organizer existing = getById(id);
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        return organizerRepository.save(existing);
    }

    public void delete(Long id) {
        organizerRepository.deleteById(id);
    }

    public List<Event> getEvents(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    public List<Organizer> search(String query) {
        return organizerRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(query, query);
    }
}