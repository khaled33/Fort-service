package com.sid.Fort.CountriesDetails.Service;

import com.sid.Fort.CountriesDetails.Entity.CountrieDetails;
import com.sid.Fort.CountriesDetails.Dao.CountrieDetailsRepository;
import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Qualifier("imp1")
public class CountrieDetailsServiceImpl2 implements CountrieDetailsService {

    @Autowired
    private CountrieDetailsRepository countrieDetailsRepository;

    @Autowired
    private OperationsRepository operationsRepository;

    @Override
    public CountrieDetails getCountrieDetailsById(Long id) {
        try {
            return countrieDetailsRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<CountrieDetails> getAllCountrieDetails() {
        return countrieDetailsRepository.findAll();
    }


    @Override
    public CountrieDetails AddCountrieDetails(CountrieDetails countrieDetails, Long id_operation) throws NotFoundException {
        return operationsRepository.findById(id_operation)
                .map(responseOperation -> {
                    countrieDetails.setOperations(responseOperation);
                    return countrieDetailsRepository.save(countrieDetails);
                }).orElseThrow(() -> new RuntimeException("operation id=" + id_operation + "n'existe pas"));

    }

    @Override
    public CountrieDetails AddCountrieDetails(CountrieDetails countrieDetails) {
        return countrieDetailsRepository.save(countrieDetails);
    }

    @Override
    public CountrieDetails UpdateCountrieDetails(CountrieDetails countrieDetails, Long id, Long id_operation) {
        return operationsRepository.findById(id_operation)
                .map(responseOperation -> {
                    countrieDetails.setId(id);
                    countrieDetails.setOperations(responseOperation);
                    return countrieDetailsRepository.save(countrieDetails);
                }).orElseThrow(() -> new RuntimeException("operation id=" + id_operation + "n'existe pas"));
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
}
