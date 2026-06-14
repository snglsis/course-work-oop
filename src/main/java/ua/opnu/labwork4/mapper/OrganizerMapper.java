package ua.opnu.labwork4.mapper;

import ua.opnu.labwork4.dto.OrganizerDTO;
import ua.opnu.labwork4.entity.Organizer;

public class OrganizerMapper {

    public static OrganizerDTO toDTO(Organizer organizer) {
        if (organizer == null) return null;
        return new OrganizerDTO(
                organizer.getId(),
                organizer.getFirstName(),
                organizer.getLastName(),
                organizer.getEmail(),
                organizer.getPhone()
        );
    }

    public static Organizer toEntity(OrganizerDTO dto) {
        if (dto == null) return null;
        Organizer organizer = new Organizer();
        organizer.setFirstName(dto.getFirstName());
        organizer.setLastName(dto.getLastName());
        organizer.setEmail(dto.getEmail());
        organizer.setPhone(dto.getPhone());
        return organizer;
    }
}
