package test.code.farmcollector.dto;

import test.code.farmcollector.constant.Season;

import java.util.List;
import java.util.Map;

public record PlantedResult(String farmName, Map<Season, List<PlantedField>> seasonData) {
}
