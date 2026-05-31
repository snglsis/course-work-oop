package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.entity.Equipment;
import ua.opnu.labwork4.repository.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    public Equipment getById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found: " + id));
    }

    public Equipment update(Long id, Equipment updated) {
        Equipment existing = getById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        return equipmentRepository.save(existing);
    }

    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}