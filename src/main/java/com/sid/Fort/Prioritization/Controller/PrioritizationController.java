package com.sid.Fort.Prioritization.Controller;

import com.sid.Fort.Prioritization.Dao.PrioritizationRepository;
import com.sid.Fort.Prioritization.Entity.PrioritizationEntity;
import com.sid.Fort.Prioritization.Service.PrioritizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrioritizationController {

    @Autowired
    PrioritizationService prioritizationService;

    @Autowired
    PrioritizationRepository prioritizationRepository;

    @PostMapping("/Prioritization/{id_Scenarios}/typeSectors/{typeSecteur}")
    public List<PrioritizationEntity> PrioritizationCalcule(@PathVariable Long id_Scenarios,@PathVariable String typeSecteur) {
        if (typeSecteur.equals("Banking Sector")||typeSecteur.equals("Insurance Sector")||typeSecteur.equals("Securities Sector")||typeSecteur.equals("Securities Sector (Product Based)")) {
            return prioritizationService.PrioritizationCalcule(id_Scenarios);
        }else
            return prioritizationService.PrioritizationCalcule1(id_Scenarios);
    }
    @GetMapping("/Prioritization/{id_Scenarios}")
    public List<PrioritizationEntity> PrioritizationCalculeOtherSecteur(@PathVariable Long id_Scenarios) {
        return prioritizationRepository.getAllByScenariosId(id_Scenarios);
    }
}
