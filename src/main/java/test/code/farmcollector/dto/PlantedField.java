package test.code.farmcollector.dto;

import java.util.Map;

public record PlantedField(int fieldId, float plantedArea, Map<String, Float> expectedCropsInTons) {
}
