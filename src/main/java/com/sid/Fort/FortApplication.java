package com.sid.Fort;

import com.sid.Fort.AnalyseOperation.ChartVulSector.Service.ChartVulSectorService;
import com.sid.Fort.AnalyseOperation.ChatVulProduct.Dao.ChatVulProductRepository;
import com.sid.Fort.CalculesVulnerabilityProdcts.ServiceVulnerabilityProduct;
import com.sid.Fort.Countries.Dao.CountrieRepository;
import com.sid.Fort.Countries.Entity.Countrie;

import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.UserDetails.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@SpringBootApplication(scanBasePackages = {"com.sid"},exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2

public class FortApplication implements CommandLineRunner {

    @Autowired
    private ChatVulProductRepository chatVulProductRepository;

    public static void main(String[] args) {
        SpringApplication.run(FortApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder geBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

//
//		final String uri = "https://restcountries.eu/rest/v2/all";
//try {
//
//
//	RestTemplate restTemplate = new RestTemplate();
//	cont result[] = restTemplate.getForObject(uri, cont[].class);
//
////
//	for (cont r:result ) {
//		Countrie countrie=new Countrie();
//		countrie.setCountry_code(r.getAlpha2Code());
//		countrie.setCountry_name(r.getName());
//		countrie.setFlag(r.getFlag());
//		countrieRepository.save(countrie);
//	}
//
//
//} catch (RestClientException e) {
//	e.printStackTrace();
//}

    }

}
