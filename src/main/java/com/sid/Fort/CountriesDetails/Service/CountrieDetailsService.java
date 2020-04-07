package com.sid.Fort.CountriesDetails.Service;

import com.sid.Fort.CountriesDetails.Entity.CountrieDetails;

import java.util.List;

public interface CountrieDetailsService {

        public CountrieDetails getCountrieDetailsById(Long id);
        public List<CountrieDetails> getAllCountrieDetails();
        public CountrieDetails UpdateCountrieDetails(CountrieDetails countrieDetails,Long id);
        public void DeleteCountrieDetails(Long id);
        public CountrieDetails AddCountrieDetails(CountrieDetails countrieDetails);

        CountrieDetails UpdateCountrieDetails(CountrieDetails countrieDetails, Long id, Long id_operation);

        CountrieDetails AddCountrieDetails(CountrieDetails countrieDetails, Long id_operation);
}
