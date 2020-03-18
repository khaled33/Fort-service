package com.sid.Fort.Countries.Service;

import com.sid.Fort.Countries.Dao.Countrie;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICountrieService {
    public Countrie getCountrieById(Long id);

    public List<Countrie> getAllCountries();

    public Countrie UpdateCountrie(Countrie Countrie, Long id);

    public void DeleteCountrie(Long id);

    public Countrie AddCountrie(Countrie Countrie);

    public Countrie UpdateCountrie(String country_code, String country_name, Long id, MultipartFile file);

    public Countrie AddCountrie(String country_code, String country_name, MultipartFile file);
}
