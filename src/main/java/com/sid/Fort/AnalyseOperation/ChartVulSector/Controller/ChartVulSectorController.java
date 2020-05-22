package com.sid.Fort.AnalyseOperation.ChartVulSector.Controller;

import com.sid.Fort.AnalyseOperation.ChartVulSector.Entity.ChartVulSector;
import com.sid.Fort.AnalyseOperation.ChartVulSector.Service.ChartVulSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartVulSectorController {

    @Autowired
    ChartVulSectorService chartVulSectorService;

    @GetMapping("/ChartVulSector/Opiration/{id_Operation}")
    public List<ChartVulSector> getOpenDoorChart(@PathVariable Long id_Operation) {
        return chartVulSectorService.getOpenDoorchart(id_Operation);
    }
    @GetMapping("/ChartVulSector/Scenarios/{id_Scenarios}/Opiration/{id_Operation}")
    public Double getOneByScenariosOpenDoorchart(@PathVariable Long id_Scenarios,@PathVariable Long id_Operation) {
        return chartVulSectorService.getOneByScenariosOpenDoorchart(id_Scenarios,id_Operation);
    }

}
