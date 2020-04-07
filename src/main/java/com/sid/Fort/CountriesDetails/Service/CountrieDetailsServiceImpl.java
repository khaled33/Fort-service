package com.sid.Fort.CountriesDetails.Service;

import com.sid.Fort.CountriesDetails.Entity.CountrieDetails;
import com.sid.Fort.CountriesDetails.Dao.CountrieDetailsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Qualifier("imp")
public class CountrieDetailsServiceImpl implements CountrieDetailsService {

    @Autowired
    private CountrieDetailsRepository countrieDetailsRepository;

    @Override
    public CountrieDetails getCountrieDetailsById(Long id) {
        try {
            return countrieDetailsRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<CountrieDetails> getAllCountrieDetails() {
        return countrieDetailsRepository.findAll();
    }

    @Override
    public CountrieDetails UpdateCountrieDetails(CountrieDetails countrieDetails, Long id) {

        countrieDetails.setId(id);
        return countrieDetailsRepository.save(countrieDetails);
    }

    @Override
    public void DeleteCountrieDetails(Long id) {
        countrieDetailsRepository.deleteById(id);

    }

    @Override
    public CountrieDetails AddCountrieDetails(CountrieDetails countrieDetails) {
        return countrieDetailsRepository.save(countrieDetails);
    }

    @Override
    public CountrieDetails UpdateCountrieDetails(CountrieDetails countrieDetails, Long id, Long id_operation) {
        return null;
    }

    @Override
    public CountrieDetails AddCountrieDetails(CountrieDetails countrieDetails, Long id_operation) {
        return null;
    }
}
