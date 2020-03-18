package com.sid.Fort.Countries.Controller;

import com.sid.Fort.Countries.Dao.Countrie;
import com.sid.Fort.Countries.Service.ICountrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController

public class ControllerCountriesImpl {

    @Autowired
    @Qualifier("ImpV2")
    private ICountrieService iCountrieService;

    @GetMapping("/Countrie/{id}")
    public ResponseEntity<Countrie> getCountrieById(@PathVariable Long id) {
        Countrie result = iCountrieService.getCountrieById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/Countries")
    public ResponseEntity<List<Countrie>> getAllCountries() {
        List<Countrie> result = iCountrieService.getAllCountries();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/Countrie/{id}")
    public ResponseEntity<Void> DeleteCountrie(@PathVariable Long id) {
        iCountrieService.DeleteCountrie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    @PutMapping("/Countrie/{id}")
    public ResponseEntity<Countrie> UpdateCountrie(@RequestParam String country_code,
                                                   @RequestParam String country_name,
                                                   @PathVariable Long id,
                                                   @RequestParam(required = false) MultipartFile file) {
        Countrie result = iCountrieService.UpdateCountrie(country_code, country_name, id, file);

        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PostMapping("/Countrie")
    public ResponseEntity<Countrie> AddCountrie(
            @RequestParam String country_code, @RequestParam String country_name, @RequestParam MultipartFile file) {
        Countrie result = iCountrieService.AddCountrie(country_code, country_name, file);

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    public ResponseEntity<Countrie> UpdateCountrie(@Valid @RequestBody Countrie Countrie, @PathVariable Long id) {
//        Countrie result = iCountrieService.UpdateCountrie(Countrie, id);
//        return new ResponseEntity<>(result, HttpStatus.CREATED);
//    }
//    public ResponseEntity<Countrie> AddCountrie( @Valid @RequestBody Countrie Countrie) {
//        Countrie result =iCountrieService.AddCountrie(Countrie);
//        return new ResponseEntity<>(result, HttpStatus.CREATED);
//
//    }
}
