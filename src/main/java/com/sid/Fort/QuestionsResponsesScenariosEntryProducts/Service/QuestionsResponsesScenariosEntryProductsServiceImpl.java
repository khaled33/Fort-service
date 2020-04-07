package com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Service;

import com.sid.Fort.Products.Dao.ProductsRepository;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Dao.QuestionsResponsesScenariosEntryProductsRepository;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Entity.QuestionsResponsesScenariosEntryProducts;
import com.sid.Fort.Responses.Dao.ResponsesRepository;
import com.sid.Fort.Responses.Entity.Responses;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsResponsesScenariosEntryProductsServiceImpl implements QuestionsResponsesScenariosEntryProductsService {
    @Autowired
    private QuestionsResponsesScenariosEntryProductsRepository questionsResponsesScenariosEntryProductsRepository;
    @Autowired
    ScenariosRepository scenariosRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    private ResponsesRepository responsesRepository;


    @Override
    public QuestionsResponsesScenariosEntryProducts getQuestionsResponsesScenariosEntryProductsById(Long id) {
        return questionsResponsesScenariosEntryProductsRepository.getOne(id);
    }

    @Override
    public List<QuestionsResponsesScenariosEntryProducts> getAllQuestionsResponsesScenariosEntryProducts() {
        return questionsResponsesScenariosEntryProductsRepository.findAll();
    }

    @Override
    public List<QuestionsResponsesScenariosEntryProducts> getAllQuestionsResponsesScenariosEntryProductsByIdScenarios(Long id_Scenarios) {
        return questionsResponsesScenariosEntryProductsRepository.findAllQuestionsResponsesScenariosEntryProductsByScenariosId(id_Scenarios);
    }

    @Override
    public QuestionsResponsesScenariosEntryProducts AddQuestionsResponsesScenariosEntryProducts(QuestionsResponsesScenariosEntryProducts QuestionsResponsesScenariosEntryProducts,
                                                                                                Long scenario_id, Long product_id) {

        QuestionsResponsesScenariosEntryProducts.setId(1L);
        Scenarios scenarios = scenariosRepository.getOne(scenario_id);
        Products products = productsRepository.getOne(product_id);

        Long id_Question = QuestionsResponsesScenariosEntryProducts.getQuestionsEntryProducts().getId();

        QuestionsResponsesScenariosEntryProducts.setScenarios(scenarios);
        QuestionsResponsesScenariosEntryProducts.setProducts(products);
        QuestionsResponsesScenariosEntryProducts OldquestionsResponsesScenarios = questionsResponsesScenariosEntryProductsRepository.findByQuestionsEntryProductsIdAndScenariosIdAndProductsId(id_Question, scenario_id, product_id);
        if (QuestionsResponsesScenariosEntryProducts.getResponses_sel() != null && QuestionsResponsesScenariosEntryProducts.getResponses_sel() != -1) {
            Responses responses = responsesRepository.getOne(QuestionsResponsesScenariosEntryProducts.getResponses_sel());

            QuestionsResponsesScenariosEntryProducts.setValue(responses.getValue());
            QuestionsResponsesScenariosEntryProducts.setResponses(responses);
        } else {
            QuestionsResponsesScenariosEntryProducts.setValue(0d);
            QuestionsResponsesScenariosEntryProducts.setResponses(null);
        }


        if (OldquestionsResponsesScenarios != null) {
            QuestionsResponsesScenariosEntryProducts.setId(OldquestionsResponsesScenarios.getId());
        }

        return questionsResponsesScenariosEntryProductsRepository.save(QuestionsResponsesScenariosEntryProducts);

    }

    @Override
    public QuestionsResponsesScenariosEntryProducts UpdateQuestionsResponsesScenariosEntryProducts(QuestionsResponsesScenariosEntryProducts QuestionsResponsesScenariosEntryProducts, Long id) {
        return null;
    }

    @Override
    public void DeleteQuestionsResponsesScenariosEntryProducts(Long id) {

    }
}
