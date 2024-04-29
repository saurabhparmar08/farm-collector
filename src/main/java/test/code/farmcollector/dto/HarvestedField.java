package test.code.farmcollector.dto;

import java.util.Map;

public record HarvestedField(int fieldId, Map<String, Float> actualHarvestedCorps  ) {
}
