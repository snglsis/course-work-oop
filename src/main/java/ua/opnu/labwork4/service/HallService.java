package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.entity.Building;
import ua.opnu.labwork4.entity.Equipment;
import ua.opnu.labwork4.entity.Hall;
import ua.opnu.labwork4.repository.BuildingRepository;
import ua.opnu.labwork4.repository.EquipmentRepository;
import ua.opnu.labwork4.repository.HallRepository;

import java.util.List;

@Service
public class HallService {

    private final HallRepository hallRepository;
    private final BuildingRepository buildingRepository;
    private final EquipmentRepository equipmentRepository;

    public HallService(HallRepository hallRepository,
                       BuildingRepository buildingRepository,
                       EquipmentRepository equipmentRepository) {
        this.hallRepository = hallRepository;
        this.buildingRepository = buildingRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public Hall create(Hall hall) {
        return hallRepository.save(hall);
    }

    public List<Hall> getAll() {
        return hallRepository.findAll();
    }

    public Hall getById(Long id) {
        return hallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hall not found: " + id));
    }

    public Hall update(Long id, Hall updated) {
        Hall existing = getById(id);
        existing.setName(updated.getName());
        existing.setCapacity(updated.getCapacity());
        existing.setFloor(updated.getFloor());
        return hallRepository.save(existing);
    }

    public void delete(Long id) {
        hallRepository.deleteById(id);
    }

    public List<Hall> getByBuilding(Long buildingId) {
        return hallRepository.findByBuildingId(buildingId);
    }

    public List<Equipment> getEquipment(Long hallId) {
        return getById(hallId).getEquipment();
    }

    public List<Hall> searchByName(String query) {
        return hallRepository.findByNameContainingIgnoreCase(query);
    }

    public Hall addEquipment(Long hallId, Long equipmentId) {
        Hall hall = getById(hallId);
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new RuntimeException("Equipment not found: " + equipmentId));
        if (!hall.getEquipment().contains(equipment)) {
            hall.getEquipment().add(equipment);
        }
        return hallRepository.save(hall);
    }

    public Hall removeEquipment(Long hallId, Long equipmentId) {
        Hall hall = getById(hallId);
        hall.getEquipment().removeIf(e -> e.getId().equals(equipmentId));
        return hallRepository.save(hall);
    }

    public Hall assignBuilding(Long hallId, Long buildingId) {
        Hall hall = getById(hallId);
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found: " + buildingId));
        hall.setBuilding(building);
        return hallRepository.save(hall);
    }
}