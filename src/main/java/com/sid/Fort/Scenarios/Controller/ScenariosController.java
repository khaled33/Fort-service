package com.sid.Fort.Scenarios.Controller;

import com.sid.Fort.Scenarios.Entity.Scenarios;
import com.sid.Fort.Scenarios.Service.IScenariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ScenariosController {
    @Autowired
    private IScenariosService iScenariosService;

    @GetMapping("/Scenario/{id}")
    public ResponseEntity<Scenarios> getOperationsById(@PathVariable Long id) {
        Scenarios rest = iScenariosService.getScenariosById(id);
       return new ResponseEntity<>(rest, HttpStatus.OK);
    }

    @GetMapping("/Scenario/Opiration/{id}")
    public ResponseEntity<List<Scenarios>> getScenariosById_Opiration(@PathVariable Long id) {
        List<Scenarios> rest = iScenariosService.getScenariosById_Opiration(id);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }

    @GetMapping("/Scenarios")
    public ResponseEntity<List<Scenarios>> getAllScenarios() {

        return new ResponseEntity<>(iScenariosService.getAllScenarios(), HttpStatus.OK);
    }

    @PostMapping("/Scenario")
    public ResponseEntity<Scenarios> AddScenarios(@RequestBody Scenarios scenarios) {
        return new ResponseEntity<>(iScenariosService.AddScenarios(scenarios), HttpStatus.CREATED);
    }
    @PostMapping("/Scenario/Opiration/{id_opiration}")
    public ResponseEntity<Scenarios> AddScenarios(@RequestBody Scenarios scenarios,@PathVariable Long id_opiration) {
        return new ResponseEntity<>(iScenariosService.AddScenarios(scenarios,id_opiration), HttpStatus.CREATED);
    }
    @PutMapping("/Scenario/{id}")
    public ResponseEntity<Scenarios> UpdateScenarios(@RequestBody Scenarios scenarios, @PathVariable Long id) {
        return new ResponseEntity<>(iScenariosService.UpdateScenarios(scenarios, id), HttpStatus.CREATED);

    }

    @DeleteMapping("/Scenario/{id}")
    public ResponseEntity<Void> DeleteScenarios(@PathVariable Long id) {
        iScenariosService.DeleteScenarios(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }
}
