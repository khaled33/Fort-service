package com.sid.Fort;

import com.sid.Fort.AnalyseOperation.ChartVulSector.Service.ChartVulSectorService;
import com.sid.Fort.CalculesVulnerabilityProdcts.ServiceVulnerabilityProduct;
import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.UserDetails.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication(scanBasePackages = {"com.sid"},exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
//@EnableAutoConfiguration(exclude = {
//		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
//})
public class FortApplication implements CommandLineRunner {

@Autowired
OperationsRepository OperationsRepository;

	public static void main(String[] args) {
		SpringApplication.run(FortApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder geBCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

//
		String SectoreType = OperationsRepository.getSectorsByOpirationId(9L);


	}

}
