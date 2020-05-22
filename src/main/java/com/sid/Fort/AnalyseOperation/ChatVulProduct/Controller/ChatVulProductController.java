package com.sid.Fort.AnalyseOperation.ChatVulProduct.Controller;

import com.sid.Fort.AnalyseOperation.ChatVulProduct.Dao.ChatVulProductRepository;
import com.sid.Fort.AnalyseOperation.ChatVulProduct.Entity.ChatVulProduct;
import com.sid.Fort.Products.Dao.ProductsRepository;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChatVulProductController {
    @Autowired
    private ChatVulProductRepository chatVulProductRepository;
    @Autowired
    private ScenariosRepository scenariosRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/ChatVulProduct/Opiration/{id_Opiration}")
    private List<ChatVulProduct> getChatVulProduct(@PathVariable Long id_Opiration) {

        return chatVulProductRepository.getByOperationOrderByProductsIdAsc(id_Opiration);
    }

    @GetMapping("/ChatVulProduct/Opiration/{id_Opiration}/Scenario/{id}")
    private List<ChatVulProduct> getChatVulProduct(@PathVariable Long id_Opiration, @PathVariable Long id) {

        return chatVulProductRepository.getByOperationAndProductsId(id_Opiration, id);

    }

    @GetMapping("/TableVulProduct/Opiration/{id_Opiration}")
    private List<?> getVulProductAnalysis(@PathVariable Long id_Opiration) {

        List<Scenarios> scenarios = scenariosRepository.findScenariosByOperationsId(id_Opiration);
//        List<ChatVulProduct> chatVulProducts=new ArrayList<>();

        List<List<ChatVulProduct>> ListVulProducts = new ArrayList<>();

        List<ChatVulProduct> chatVulProducts = new ArrayList<>();
        List<List<ChatVulProduct>> chatVulProduct = new ArrayList<>();

        for (Scenarios scenario : scenarios) {

            List<Products> products = productsRepository.findProductsByDnfbpsSectorsId(scenario.getOperations().getDnfbpsSectors().getId());

            for (Products product : products) {
                System.out.println(product.getLabel());
                chatVulProducts =chatVulProductRepository.getByProductsIdAndOperation(product.getId(), id_Opiration);
                chatVulProduct.add(chatVulProducts);
                for (int i = 0; i < chatVulProducts.size(); i++) {
                    if (i >0){
                        chatVulProducts.get(i).setTextProducts("");
                    }
                    System.out.println(chatVulProducts.get(i).getVulnerabiliteFinale());
                    System.out.println(chatVulProducts.get(i).getVulnerabiliteInherente());
                    System.out.println(chatVulProducts.get(i).getId_Scenario());
                    System.out.println("********************************");
                }
            }

            System.out.println("________________"+scenario.getDesignation()+"__________________________");
break;
        }
        return chatVulProduct;
    }
}

class modeltableProdact {

}
