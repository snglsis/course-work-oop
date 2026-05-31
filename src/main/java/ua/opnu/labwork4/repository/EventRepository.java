package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.opnu.labwork4.entity.Event;
import ua.opnu.labwork4.enums.EventStatus;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganizerId(Long organizerId);
    List<Event> findByHallId(Long hallId);
    List<Event> findByBuildingId(Long buildingId);
    List<Event> findByStatus(EventStatus status);
    List<Event> findByTitleContainingIgnoreCase(String query);

    @Query("SELECT e.building.name, COUNT(e) FROM Event e WHERE e.building IS NOT NULL GROUP BY e.building.name")
    List<Object[]> countByBuilding();
}