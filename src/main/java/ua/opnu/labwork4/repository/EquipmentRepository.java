package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.labwork4.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}