package com.sid.Fort.DnfbpsSectors.Controller;

import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.DnfbpsSectors.Service.DnfbpsSectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class DnfbpsSectorsController {
    @Autowired
    private DnfbpsSectorsService dnfbpsSectorsService;

    @GetMapping("/DnfbpsSector/{id}")
    public ResponseEntity<DnfbpsSectors> getDnfbpsSectorsById(@PathVariable Long id) {

        DnfbpsSectors  result= dnfbpsSectorsService.getDnfbpsSectorsById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @GetMapping("/DnfbpsSectors")
    public ResponseEntity<List<DnfbpsSectors>> getAllDnfbpsSectors() {
        List<DnfbpsSectors>  result= dnfbpsSectorsService.getAllDnfbpsSectors();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping("/DnfbpsSector/{id}")
    public ResponseEntity<DnfbpsSectors> UpdateDnfbpsSectors(@Valid @RequestBody DnfbpsSectors dnfbpssectors, @PathVariable Long id) {
        DnfbpsSectors  result= dnfbpsSectorsService.UpdateDnfbpsSectors(dnfbpssectors, id);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(("/DnfbpsSector/{id}"))
    public ResponseEntity<Void> DeleteDnfbpsSectors(@PathVariable Long id) {

        dnfbpsSectorsService.DeleteDnfbpsSectors(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/DnfbpsSector")
    public ResponseEntity<DnfbpsSectors> AddDnfbpsSectors(@Valid @RequestBody DnfbpsSectors dnfbpssectors) {

        DnfbpsSectors result=dnfbpsSectorsService.AddDnfbpsSectors(dnfbpssectors);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
