package test.code.farmcollector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.code.farmcollector.dto.HarvestedResult;
import test.code.farmcollector.dto.PlantedResult;
import test.code.farmcollector.service.FarmCollectorService;

import java.util.List;

@RestController
public class FarmCollectorController {

    private final FarmCollectorService farmCollectorService;

    public FarmCollectorController(FarmCollectorService farmCollectorService) {
        this.farmCollectorService = farmCollectorService;
    }

    @GetMapping("planted")
    public List<PlantedResult> getPlantedData() {
        return farmCollectorService.getPlantedData();
    }

    @GetMapping("harvested")
    public List<HarvestedResult> getHarvestedData() {
        return farmCollectorService.getHarvestedData();
    }
}
