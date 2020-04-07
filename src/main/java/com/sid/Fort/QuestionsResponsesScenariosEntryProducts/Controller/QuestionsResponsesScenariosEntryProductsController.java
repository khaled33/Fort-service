package com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Controller;

import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Entity.QuestionsResponsesScenariosEntryProducts;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Service.QuestionsResponsesScenariosEntryProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class QuestionsResponsesScenariosEntryProductsController {
    @Autowired
    QuestionsResponsesScenariosEntryProductsService questionsResponsesScenariosEntryProductsService;
@GetMapping("/QuestionsResponsesScenariosEntryProducts/{id}")
    public QuestionsResponsesScenariosEntryProducts getQuestionsResponsesScenariosEntryProductsById(@PathVariable Long id) {
        return questionsResponsesScenariosEntryProductsService.getQuestionsResponsesScenariosEntryProductsById(id);
    }

    public List<QuestionsResponsesScenariosEntryProducts> getAllQuestionsResponsesScenariosEntryProducts() {
        return questionsResponsesScenariosEntryProductsService.getAllQuestionsResponsesScenariosEntryProducts();
    }

    public List<QuestionsResponsesScenariosEntryProducts> getAllQuestionsResponsesScenariosEntryProductsByIdScenarios(Long id) {
        return questionsResponsesScenariosEntryProductsService.getAllQuestionsResponsesScenariosEntryProductsByIdScenarios(id);
    }

    @PostMapping("/QuestionsResponsesScenariosEntryProducts/scenario/{scenario_id}/Product/{product_id}")
    public QuestionsResponsesScenariosEntryProducts AddQuestionsResponsesScenariosEntryProducts(@RequestBody QuestionsResponsesScenariosEntryProducts QuestionsResponsesScenariosEntryProducts, @PathVariable Long scenario_id, @PathVariable Long product_id) {
        return questionsResponsesScenariosEntryProductsService.AddQuestionsResponsesScenariosEntryProducts(QuestionsResponsesScenariosEntryProducts, scenario_id, product_id);
    }

    public QuestionsResponsesScenariosEntryProducts UpdateQuestionsResponsesScenariosEntryProducts(QuestionsResponsesScenariosEntryProducts QuestionsResponsesScenariosEntryProducts, Long id) {
        return questionsResponsesScenariosEntryProductsService.UpdateQuestionsResponsesScenariosEntryProducts(QuestionsResponsesScenariosEntryProducts, id);
    }

    public void DeleteQuestionsResponsesScenariosEntryProducts(Long id) {
        questionsResponsesScenariosEntryProductsService.DeleteQuestionsResponsesScenariosEntryProducts(id);
    }
}
