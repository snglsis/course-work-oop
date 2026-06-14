package ua.opnu.labwork4.mapper;

import ua.opnu.labwork4.dto.EquipmentDTO;
import ua.opnu.labwork4.entity.Equipment;

public class EquipmentMapper {

    public static EquipmentDTO toDTO(Equipment equipment) {
        if (equipment == null) return null;
        return new EquipmentDTO(
                equipment.getId(),
                equipment.getName(),
                equipment.getDescription()
        );
    }

    public static Equipment toEntity(EquipmentDTO dto) {
        if (dto == null) return null;
        Equipment equipment = new Equipment();
        equipment.setName(dto.getName());
        equipment.setDescription(dto.getDescription());
        return equipment;
    }
}
