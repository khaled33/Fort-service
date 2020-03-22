package com.sid.Fort.Scenarios.Service;

import com.sid.Fort.Operations.Dao.Operations;
import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.Questions.Service.QuestionsServiceImpl;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.Scenarios.Dao.Scenarios;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScenariosServiceImpl implements IScenariosService {

    @Autowired
    private ScenariosRepository scenariosRepository;
    @Autowired
    private OperationsRepository operationsRepository;
    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;
    @Autowired
    private QuestionsServiceImpl questionsService;
    @Override
    public Scenarios getScenariosById(Long id) {
        try {
        return scenariosRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }


    @Override
    public List<Scenarios> getScenariosById_Opiration(Long id) {
        try {
            return scenariosRepository.findScenariosByOperationsId(id);
    }catch (NoSuchElementException ex) {
        throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
    }
    }

    @Override
    public List<Scenarios> getAllScenarios() {
        return scenariosRepository.findAll();
    }

    @Override
    public Scenarios AddScenarios(Scenarios scenarios) {

        return scenariosRepository.save(scenarios);
    }
    @Override
    @Transactional
    public Scenarios AddScenarios (Scenarios scenarios, Long id_opiration) {

        Operations operations=operationsRepository.getOne(id_opiration);
        scenarios.setOperations(operations);

        List<Questions> questions = questionsService.getQuestionsBySecteurIdAndTypeINTERMEDIATE(operations.getDnfbpsSectors().getId(), Questions.Type.INTERMEDIATE_VARIABLE_TYPE, scenarios.getId());
        for (Questions qs:questions) {
            QuestionsResponsesScenarios questionsResponsesScenarios=new QuestionsResponsesScenarios();
            questionsResponsesScenarios.setValue(0);
            questionsResponsesScenarios.setBest_value(7d);
            questionsResponsesScenarios.setScenarios(scenarios);
            questionsResponsesScenarios.setQuestions(qs);
            questionsResponsesScenariosRepository.save(questionsResponsesScenarios);

        }
        return scenariosRepository.save(scenarios);
    }

    @Override
    public Scenarios UpdateScenarios(Scenarios scenarios, Long id) {
        scenarios.setId(id);
        return scenariosRepository.save(scenarios);
    }

    @Override
    @Transactional
    public void DeleteScenarios(Long id) {
        questionsResponsesScenariosRepository.deleteByScenariosId(id);
        scenariosRepository.deleteById(id);
    }
}
