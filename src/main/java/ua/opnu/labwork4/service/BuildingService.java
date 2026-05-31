package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.entity.Building;
import ua.opnu.labwork4.entity.Hall;
import ua.opnu.labwork4.repository.BuildingRepository;
import ua.opnu.labwork4.repository.HallRepository;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final HallRepository hallRepository;

    public BuildingService(BuildingRepository buildingRepository,
                           HallRepository hallRepository) {
        this.buildingRepository = buildingRepository;
        this.hallRepository = hallRepository;
    }

    public Building create(Building building) {
        return buildingRepository.save(building);
    }

    public List<Building> getAll() {
        return buildingRepository.findAll();
    }

    public Building getById(Long id) {
        return buildingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Building not found: " + id));
    }

    public Building update(Long id, Building updated) {
        Building existing = getById(id);
        existing.setName(updated.getName());
        existing.setCity(updated.getCity());
        existing.setAddress(updated.getAddress());
        return buildingRepository.save(existing);
    }

    public void delete(Long id) {
        buildingRepository.deleteById(id);
    }

    public List<Hall> getHalls(Long buildingId) {
        return hallRepository.findByBuildingId(buildingId);
    }
}