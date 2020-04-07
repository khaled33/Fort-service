package com.sid.Fort.Countries.Service;

import com.sid.Fort.Countries.Entity.Countrie;
import com.sid.Fort.Countries.Dao.CountrieRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Qualifier("ImpV1")
public class CountrieServiceImpl implements ICountrieService {

    @Autowired
    CountrieRepository countrieRepository;

    @Override
    public Countrie getCountrieById(Long id) {
        try {
            return countrieRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }

    }

    @Override
    public List<Countrie> getAllCountries() {
        return countrieRepository.findAll();
    }

    @Override
    public Countrie UpdateCountrie(Countrie countrie, Long id) {
        countrie.setId(id);
        return countrieRepository.save(countrie);
    }

    @Override
    public void DeleteCountrie(Long id) {
        countrieRepository.deleteById(id);
    }

    @Override
    public Countrie AddCountrie(Countrie countrie) {
        return countrieRepository.save(countrie);
    }

    @Override
    public Countrie UpdateCountrie(String country_code, String country_name, Long id, MultipartFile file) {
        return null;
    }

    @Override
    public Countrie AddCountrie(String country_code, String country_name, MultipartFile file) {
        return null;
    }


}
