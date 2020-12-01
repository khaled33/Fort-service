package com.sid.Fort;

import com.sid.Fort.AnalyseOperation.ChartVulSector.Service.ChartVulSectorService;
import com.sid.Fort.AnalyseOperation.ChatVulProduct.Dao.ChatVulProductRepository;
import com.sid.Fort.CalculesVulnerabilityProdcts.ServiceVulnerabilityProduct;
import com.sid.Fort.Countries.Dao.CountrieRepository;
import com.sid.Fort.Countries.Entity.Countrie;

import com.sid.Fort.Form.Entity.DTODoughnutChart;
import com.sid.Fort.Form.Entity.FormEntity;
import com.sid.Fort.Form.Service.FormServiceImp;
import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.Prioritization.Service.PrioritizationServiceImpl;
import com.sid.Fort.UploadImage.property.FileStorageProperties;
import com.sid.Fort.UserDetails.Service.AccountService;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class FortApplication extends ServletInitializer implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

  @Autowired
    private PrioritizationServiceImpl prioritizationService;


    public static void main(String[] args) {
        SpringApplication.run(FortApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder geBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println(prioritizationService.PrioritizationCalcule(16L));

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FortApplication.class);
    }
//
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(redirectConnector());
//        return tomcat;
//    }
//
//    private Connector redirectConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(8087);
//        connector.setSecure(false);
//        connector.setRedirectPort(8443);
//        return connector;
//    }

//    @Configuration
//    @EnableWebMvc
//    public class WebConfig implements WebMvcConfigurer {
//
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/** ** ");
//        }
//    }
}
