package com.sid.Fort.QuestionsResponsesScenariosEntryPage.Service;

import com.sid.Fort.Calcules.VulMap.Service.VulMapService;
import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.Products.Dao.ProductsRepository;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity.QuestionsResponsesScenariosEntryPage;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.Responses.Entity.Responses;
import com.sid.Fort.Responses.Dao.ResponsesRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionsResponsesScenariosServiceImpl implements QuestionsResponsesScenariosService {
    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ScenariosRepository scenariosRepository;

    @Autowired
    private ResponsesRepository responsesRepository;
    @Autowired
    VulMapService vulMapService;

    @Override
    public QuestionsResponsesScenariosEntryPage getQuestionsResponsesScenariosById(Long id) {
        try {
            return questionsResponsesScenariosRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<QuestionsResponsesScenariosEntryPage> getAllQuestionsResponsesScenarios() {
        return questionsResponsesScenariosRepository.findAll();
    }

    @Override
    public List<QuestionsResponsesScenariosEntryPage> getAllQuestionsResponsesScenariosByIdScenarios(Long id) {
        try {
            return questionsResponsesScenariosRepository.findAllQuestionsResponsesScenariosByScenariosId(id);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public QuestionsResponsesScenariosEntryPage AddQuestionsResponsesScenarios(QuestionsResponsesScenariosEntryPage QuestionsResponsesScenarios, Long scenario_id, Long product_id) {
        QuestionsResponsesScenarios.setId(scenario_id);

        Long idQuestion = QuestionsResponsesScenarios.getQuestions().getId();
       // QuestionsResponsesScenariosEntryPage OldquestionsResponsesScenarios = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosIdAndProductsId(idQuestion, scenario_id, product_id);


        Scenarios scenarios = scenariosRepository.findById(scenario_id).get();
        Products products = productsRepository.getOne(product_id);

        QuestionsResponsesScenarios.setScenarios(scenarios);
//        QuestionsResponsesScenariosEntryPage.setProducts(products);


        if (QuestionsResponsesScenarios.getResponses_sel() != null) {
            Responses responses = responsesRepository.getOne(QuestionsResponsesScenarios.getResponses_sel());
            QuestionsResponsesScenarios.setValue(responses.getValue());
            QuestionsResponsesScenarios.setResponses(responses);

        } else {
            QuestionsResponsesScenarios.setResponses(null);
            QuestionsResponsesScenarios.setValue(0);
        }

//        if (OldquestionsResponsesScenarios != null) {
//            QuestionsResponsesScenariosEntryPage.setId(OldquestionsResponsesScenarios.getId());
//        }
        return questionsResponsesScenariosRepository.save(QuestionsResponsesScenarios);

    }

    @Override
    @Transactional
    public QuestionsResponsesScenariosEntryPage AddQuestionsResponsesScenarios(QuestionsResponsesScenariosEntryPage QuestionsResponsesScenarios, Long scenario_id) {
        QuestionsResponsesScenarios.setId(scenario_id);

        Long idQuestion = QuestionsResponsesScenarios.getQuestions().getId();

        QuestionsResponsesScenariosEntryPage OldquestionsResponsesScenarios = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(idQuestion, scenario_id);

        Scenarios scenarios = scenariosRepository.findById(scenario_id).get();
        QuestionsResponsesScenarios.setScenarios(scenarios);

        if (QuestionsResponsesScenarios.getResponses_sel() != null && QuestionsResponsesScenarios.getResponses_sel()!=-1) {
            Responses responses = responsesRepository.getOne(QuestionsResponsesScenarios.getResponses_sel());

            QuestionsResponsesScenarios.setValue(responses.getValue());
            QuestionsResponsesScenarios.setResponses(responses);

        } else {
            QuestionsResponsesScenarios.setValue(0);
            QuestionsResponsesScenarios.setResponses(null);
        }

        if (OldquestionsResponsesScenarios != null) {
            QuestionsResponsesScenarios.setId(OldquestionsResponsesScenarios.getId());
        }


        return questionsResponsesScenariosRepository.save(QuestionsResponsesScenarios);
    }

    @Override
    public List<QuestionsResponsesScenariosEntryPage> AddQuestionsResponsesScenarios(List<QuestionsResponsesScenariosEntryPage> QuestionsResponsesScenarios) {


        return questionsResponsesScenariosRepository.saveAll(QuestionsResponsesScenarios);
    }

    @Override
    public QuestionsResponsesScenariosEntryPage UpdateQuestionsResponsesScenarios(QuestionsResponsesScenariosEntryPage QuestionsResponsesScenarios, Long id) {
        QuestionsResponsesScenarios.setId(id);
        return questionsResponsesScenariosRepository.save(QuestionsResponsesScenarios);
    }

    @Override
    public void DeleteQuestionsResponsesScenarios(Long id) {
        questionsResponsesScenariosRepository.deleteById(id);
    }
}
