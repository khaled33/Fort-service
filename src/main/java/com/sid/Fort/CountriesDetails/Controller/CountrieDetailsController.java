package com.sid.Fort.CountriesDetails.Controller;

import com.sid.Fort.CountriesDetails.Entity.CountrieDetails;
import com.sid.Fort.CountriesDetails.Service.CountrieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class CountrieDetailsController  {

    @Autowired
    @Qualifier("imp1")
    private CountrieDetailsService countrieDetailsService;

   @GetMapping("/CountrieDetail/{id}")
    public ResponseEntity<CountrieDetails>  getCountrieDetailsById(@PathVariable Long id) {
        CountrieDetails result = countrieDetailsService.getCountrieDetailsById(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/CountrieDetails")
    public ResponseEntity<List<CountrieDetails>> getAllCountrieDetails() {
        List<CountrieDetails> result = countrieDetailsService.getAllCountrieDetails();

        return new ResponseEntity<> (result,HttpStatus.OK);
    }

    @PostMapping("/CountrieDetail/Operation/{id_operation}")
    public ResponseEntity<CountrieDetails> AddCountrieDetails(@Valid @RequestBody CountrieDetails countrieDetails,@PathVariable Long id_operation) {
        CountrieDetails result =countrieDetailsService.AddCountrieDetails(countrieDetails,id_operation);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
    @PostMapping("/CountrieDetail/")
    public ResponseEntity<CountrieDetails> AddCountrieDetails(@Valid @RequestBody CountrieDetails countrieDetails) {
        CountrieDetails result =countrieDetailsService.AddCountrieDetails(countrieDetails);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PutMapping("/CountrieDetail/{id}/Operation/{id_operation}")
    public ResponseEntity<CountrieDetails> UpdateCountrieDetails(@Valid @RequestBody CountrieDetails countrieDetails, @PathVariable Long id,@PathVariable Long id_operation) {
        CountrieDetails result = countrieDetailsService.UpdateCountrieDetails(countrieDetails,id,id_operation);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/CountrieDetail/{id}")
    public ResponseEntity<CountrieDetails> UpdateCountrieDetails(@Valid @RequestBody CountrieDetails countrieDetails, @PathVariable Long id) {
        CountrieDetails result = countrieDetailsService.UpdateCountrieDetails(countrieDetails,id);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/CountrieDetail/{id}")
    public ResponseEntity<Void> DeleteCountrieDetails(@PathVariable Long id) {
        countrieDetailsService.DeleteCountrieDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
