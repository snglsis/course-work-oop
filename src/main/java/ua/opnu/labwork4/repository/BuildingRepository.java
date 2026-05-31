package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.labwork4.entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
