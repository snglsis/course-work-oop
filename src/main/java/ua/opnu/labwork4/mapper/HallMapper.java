package ua.opnu.labwork4.mapper;

import ua.opnu.labwork4.dto.HallDTO;
import ua.opnu.labwork4.entity.Hall;

public class HallMapper {

    public static HallDTO toDTO(Hall hall) {
        if (hall == null) return null;
        return new HallDTO(
                hall.getId(),
                hall.getName(),
                hall.getCapacity(),
                hall.getFloor(),
                // getBuilding() може бути null — перевіряємо
                hall.getBuilding() != null ? hall.getBuilding().getId() : null
        );
    }

    public static Hall toEntity(HallDTO dto) {
        if (dto == null) return null;
        Hall hall = new Hall();
        hall.setName(dto.getName());
        hall.setCapacity(dto.getCapacity());
        hall.setFloor(dto.getFloor());
        // building встановлюється у HallService після пошуку за buildingId
        return hall;
    }
}
