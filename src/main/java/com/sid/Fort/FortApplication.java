package com.sid.Fort;

import com.sid.Fort.CalculesVulnerabilityProdcts.ServiceVulnerabilityProduct;
import com.sid.Fort.UserDetails.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FortApplication   {



	public static void main(String[] args) {
		SpringApplication.run(FortApplication.class, args);

	}
	@Bean
	public BCryptPasswordEncoder geBCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Override
//	public void run(String... args) throws Exception {
//
////		accountService.saveUser(new AppUser(
////
////				 "firstname", "lastname", null,null,
////				 null, null,"language", 5, 5,
////				10, "123"," email", true, "mobilephone","phone"
////
////
////				));
////
////		accountService.saveRole(new Role("ADMIN",null));
////		accountService.saveRole(new Role("USER",null));
////
////		accountService.addRoleToUser("Admin","ADMIN");
////		accountService.addRoleToUser("Admin","USER");
//		accountService.addRoleToUser("User","USER");
//
//
//
//	}

}
