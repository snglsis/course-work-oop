package ua.opnu.labwork4.mapper;

import ua.opnu.labwork4.dto.BuildingDTO;
import ua.opnu.labwork4.entity.Building;

public class BuildingMapper {

    // Entity → DTO (для відповіді клієнту)
    public static BuildingDTO toDTO(Building building) {
        if (building == null) return null;
        return new BuildingDTO(
                building.getId(),
                building.getName(),
                building.getCity(),
                building.getAddress()
        );
    }

    // DTO → Entity (для збереження в БД)
    public static Building toEntity(BuildingDTO dto) {
        if (dto == null) return null;
        Building building = new Building();
        // id не ставимо — Hibernate генерує сам при save()
        building.setName(dto.getName());
        building.setCity(dto.getCity());
        building.setAddress(dto.getAddress());
        return building;
    }
}
