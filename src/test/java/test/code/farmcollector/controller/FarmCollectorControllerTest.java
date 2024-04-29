package test.code.farmcollector.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import test.code.farmcollector.constant.Season;
import test.code.farmcollector.dto.HarvestedField;
import test.code.farmcollector.dto.HarvestedResult;
import test.code.farmcollector.dto.PlantedField;
import test.code.farmcollector.dto.PlantedResult;
import test.code.farmcollector.service.FarmCollectorService;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(controllers = FarmCollectorController.class)
class FarmCollectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FarmCollectorService farmCollectorService;

    @Test
    void getPlantedData() throws Exception {
        var plantedData = createPlantedData();
        when(farmCollectorService.getPlantedData()).thenReturn(plantedData);
        this.mockMvc.perform(get("/farm-collector/v1/planted"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.farmName").exists());
    }

    private  List<PlantedResult> createPlantedData() {
        return List.of(new PlantedResult("Farm 1",
                        Map.of(Season.RAIN, List.of(
                                        new PlantedField(1, 200, Map.of("potatos", 150f, "corn", 120f)),
                                        new PlantedField(2, 100, Map.of("potatos", 100f)),
                                        new PlantedField(3, 100, Map.of("corn", 120f))),
                                Season.SUMMER, List.of(
                                        new PlantedField(4, 300, Map.of("potatos", 130f, "corn", 140f)),
                                        new PlantedField(5, 130, Map.of("potatos", 110f, "corn", 160f)),
                                        new PlantedField(6, 110, Map.of("corn", 140f)))
                        )
                ),
                new PlantedResult("Farm 2",
                        Map.of(Season.RAIN, List.of(
                                        new PlantedField(7, 400, Map.of("potatos", 251f, "corn", 160f)),
                                        new PlantedField(8, 600, Map.of("potatos", 120f)),
                                        new PlantedField(9, 700, Map.of("corn", 150f))),
                                Season.SUMMER, List.of(
                                        new PlantedField(10, 320, Map.of("potatos", 240f, "corn", 190f)),
                                        new PlantedField(11, 135, Map.of("potatos", 170f, "corn", 160f)),
                                        new PlantedField(12, 127, Map.of("corn", 180f)))
                        )
                ));
    }

    @Test
    void getHarvestedData() throws Exception {
        var harvestedData = createHarvestedData();
        when(farmCollectorService.getHarvestedData()).thenReturn(harvestedData);
        this.mockMvc.perform(get("/farm-collector/v1/planted"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.farmName").exists());
    }

    private List<HarvestedResult> createHarvestedData() {
        return List.of(new HarvestedResult("Farm 1",
                        Map.of(Season.RAIN, List.of(
                                        new HarvestedField(1,  Map.of("potatos", 140f, "corn", 110f)),
                                        new HarvestedField(2, Map.of("potatos", 90f)),
                                        new HarvestedField(3, Map.of("corn", 110f))),
                                Season.SUMMER, List.of(
                                        new HarvestedField(4, Map.of("potatos", 125f)),
                                        new HarvestedField(5, Map.of("potatos", 100f, "corn", 150f)),
                                        new HarvestedField(6, Map.of("corn", 120f)))
                        )
                ),
                new HarvestedResult("Farm 2",
                        Map.of(Season.RAIN, List.of(
                                        new HarvestedField(7,  Map.of("potatos", 221f, "corn", 180f)),
                                        new HarvestedField(8, Map.of("potatos", 120f)),
                                        new HarvestedField(9, Map.of("corn", 110f))),
                                Season.SUMMER, List.of(
                                        new HarvestedField(10, Map.of("potatos", 0f, "corn", 100f)),
                                        new HarvestedField(11,  Map.of("potatos", 120f, "corn", 100f)),
                                        new HarvestedField(12, Map.of("corn", 100f)))
                        )
                ));
    }
}
