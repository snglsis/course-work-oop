package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.labwork4.entity.Hall;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Long> {
    List<Hall> findByBuildingId(Long buildingId);
    List<Hall> findAllByOrderByCapacityDesc();
    List<Hall> findByNameContainingIgnoreCase(String query);
}