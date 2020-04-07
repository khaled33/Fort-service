package com.sid.Fort.DnfbpsSectorsDetails.Controller;

import com.sid.Fort.DnfbpsSectorsDetails.Entity.DnfbpsSectorsDetails;
import com.sid.Fort.DnfbpsSectorsDetails.Service.IDnfbpsSectorsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DnfbpsSectorsDetailsController {

    @Autowired
    @Qualifier("Impl2")
    private IDnfbpsSectorsDetails iDnfbpsSectorsDetails;

    @GetMapping("/DnfbpsSectorsDetail/{id}")
    public ResponseEntity<DnfbpsSectorsDetails> getDnfbpsSectorsDetailsById(@PathVariable Long id) {
        DnfbpsSectorsDetails result = iDnfbpsSectorsDetails.getDnfbpsSectorsDetailsById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/DnfbpsSectorsDetails")
    public ResponseEntity<List<DnfbpsSectorsDetails>> getAllDnfbpsSectorsDetailss() {
        List<DnfbpsSectorsDetails> result = iDnfbpsSectorsDetails.getAllDnfbpsSectorsDetailss();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/DnfbpsSectorsDetail/Operation/{id_operation}")
    public ResponseEntity<DnfbpsSectorsDetails> AddDnfbpsSectorsDetails(@RequestBody DnfbpsSectorsDetails dnfbpsSectorsDetails,@PathVariable Long id_operation) {
        DnfbpsSectorsDetails result = iDnfbpsSectorsDetails.AddDnfbpsSectorsDetails(dnfbpsSectorsDetails,id_operation);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/DnfbpsSectorsDetail")
    public ResponseEntity<DnfbpsSectorsDetails> AddDnfbpsSectorsDetails(@RequestBody DnfbpsSectorsDetails dnfbpsSectorsDetails) {
        DnfbpsSectorsDetails result = iDnfbpsSectorsDetails.AddDnfbpsSectorsDetails(dnfbpsSectorsDetails);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @PutMapping("/DnfbpsSectorsDetail/{id}/Operation/{id_operation}")
    public ResponseEntity<DnfbpsSectorsDetails> UpdateDnfbpsSectorsDetails(@RequestBody DnfbpsSectorsDetails dnfbpsSectorsDetails, @PathVariable Long id,@PathVariable Long id_operation) {
        DnfbpsSectorsDetails result = iDnfbpsSectorsDetails.UpdateDnfbpsSectorsDetails(dnfbpsSectorsDetails, id,id_operation);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/DnfbpsSectorsDetail/{id}")
    public ResponseEntity<DnfbpsSectorsDetails> UpdateDnfbpsSectorsDetails(@RequestBody DnfbpsSectorsDetails dnfbpsSectorsDetails, @PathVariable Long id) {
        DnfbpsSectorsDetails result = iDnfbpsSectorsDetails.UpdateDnfbpsSectorsDetails(dnfbpsSectorsDetails, id);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/DnfbpsSectorsDetail/{id}")
    public ResponseEntity<Void> DeleteDnfbpsSectorsDetails(@PathVariable Long id) {
        iDnfbpsSectorsDetails.DeleteDnfbpsSectorsDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
