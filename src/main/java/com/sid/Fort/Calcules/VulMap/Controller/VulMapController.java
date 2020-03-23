package com.sid.Fort.Calcules.VulMap.Controller;

import com.sid.Fort.Calcules.VulMap.Entity.VulMap;
import com.sid.Fort.Calcules.VulMap.Service.VulMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VulMapController {
    @Autowired
    private VulMapService vulMapService;

    @GetMapping("/VulMap/{id_Scenario}")
    public VulMap getVueVulMap(@PathVariable Long id_Scenario) {
        return vulMapService.getVueVulMap(id_Scenario);
    }
}
