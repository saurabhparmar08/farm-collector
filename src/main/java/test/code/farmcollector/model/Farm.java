package test.code.farmcollector.model;

import java.util.List;

public record Farm(String farmName, List<Field> fields, float farmArea) {
}
