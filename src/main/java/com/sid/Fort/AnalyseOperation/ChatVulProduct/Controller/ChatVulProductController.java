package com.sid.Fort.AnalyseOperation.ChatVulProduct.Controller;

import com.sid.Fort.AnalyseOperation.ChatVulProduct.Dao.ChatVulProductRepository;
import com.sid.Fort.AnalyseOperation.ChatVulProduct.Entity.ChatVulProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatVulProductController {
    @Autowired
    private ChatVulProductRepository chatVulProductRepository;

    @GetMapping("/ChatVulProduct/Opiration/{id_Opiration}")
    private List<ChatVulProduct> getChatVulProduct(@PathVariable Long id_Opiration){

        return chatVulProductRepository.getByOperationOrderByProductsIdAsc(id_Opiration);
    }
    @GetMapping("/ChatVulProduct/Opiration/{id_Opiration}/Scenario/{id}")
    private List<ChatVulProduct> getChatVulProduct(@PathVariable Long id_Opiration,@PathVariable Long id){

        return chatVulProductRepository.getByOperationAndProductsId(id_Opiration,id);
    }
}
