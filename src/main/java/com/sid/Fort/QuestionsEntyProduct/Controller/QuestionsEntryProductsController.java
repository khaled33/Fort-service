package com.sid.Fort.QuestionsEntyProduct.Controller;

import com.sid.Fort.QuestionsEntyProduct.Entity.QuestionsEntryProducts;
import com.sid.Fort.QuestionsEntyProduct.Service.QuestionsEntryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionsEntryProductsController {
    @Autowired
    private QuestionsEntryProductService questionsEntryProductService;

    @GetMapping("/QuestionsEntryProduct/[id}")
    public ResponseEntity<QuestionsEntryProducts> getQuestionsEntryProduct(@PathVariable Long id) {
        return new ResponseEntity<>(questionsEntryProductService.getQuestionsEntryProduct(id), HttpStatus.OK);
    }

    @GetMapping("/QuestionsEntryProducts")
    public ResponseEntity<List<QuestionsEntryProducts>> getAllQuestionsEntryProduct() {
        return new ResponseEntity<>(questionsEntryProductService.getAllQuestionsEntryProduct(), HttpStatus.OK);
    }

    @PostMapping("/QuestionsEntryProduct")
    public ResponseEntity<QuestionsEntryProducts> AddQuestionsEntryProduct(@RequestBody QuestionsEntryProducts questionsEntryProduct) {
        return new ResponseEntity<>( questionsEntryProductService.AddQuestionsEntryProduct(questionsEntryProduct), HttpStatus.CREATED);
    }

    @PutMapping("/QuestionsEntryProduct/[id}")
    public ResponseEntity<QuestionsEntryProducts> UpdateQuestionsEntryProduct(@PathVariable Long id, @RequestBody QuestionsEntryProducts questionsEntryProduct) {
        return new ResponseEntity<>( questionsEntryProductService.UpdateQuestionsEntryProduct(id,questionsEntryProduct), HttpStatus.CREATED);
    }

    @DeleteMapping("/QuestionsEntryProduct/[id}")
    public  ResponseEntity<Void> DeleteQuestionsEntryProduct(@PathVariable Long id) {
        questionsEntryProductService.DeleteQuestionsEntryProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/QuestionsEntryProducts/Secteur/{secteur_id}/Scenario/{Scenario_id}/Product/{product_id}")
    public List<QuestionsEntryProducts> findQuestionsEntryProductsBySecteur(@PathVariable  Long secteur_id, @PathVariable Long Scenario_id,@PathVariable Long product_id) {
        return questionsEntryProductService.findQuestionsEntryProductsBySecteur(secteur_id,Scenario_id,product_id);
    }
}
