package com.sid.Fort.Operations.Service;

import com.sid.Fort.Countries.Dao.Countrie;
import com.sid.Fort.Countries.Dao.CountrieRepository;
import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectors;
import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectorsRepository;
import com.sid.Fort.Operations.Dao.Operations;
import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.Questions.Service.QuestionsServiceImpl;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.QuestionsResponsesScenarios.Service.QuestionsResponsesScenariosServiceImpl;
import com.sid.Fort.Scenarios.Dao.Scenarios;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.UserDetails.Dao.AppUser;
import com.sid.Fort.UserDetails.Dao.AppUsersRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Qualifier("v2")
public class OperatiosServiceImpl1 implements IOperatiosService {
    @Autowired
    private OperationsRepository operationsRepository;

    @Autowired
    private CountrieRepository countrieRepository;

    @Autowired
    private DnfbpsSectorsRepository dnfbpsSectorsRepository;

    @Autowired
    private AppUsersRepository usersReposirory;
    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;
    @Autowired
    private QuestionsServiceImpl questionsService;
    @Autowired
    private ScenariosRepository scenariosRepository;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Override
    public Operations getOperationsById(Long id) {
        try {
            return operationsRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<Operations> getAllOperations() {
        return operationsRepository.findAll();
    }
@Transactional
    @Override
    public Operations AddOperations(Operations operations,
                                    Long country_id,
                                    Long profession_id

    ) {

//        return countrieRepository.findById(country_id)
//                .map(rescountry-> {
//                    operations.setCountrie(rescountry);
//
//                    return dnfbpsSectorsRepository.findById(profession_id)
//                            .map(resdnfbpsSectors-> {
//                                operations.setDnfbpsSectors(resdnfbpsSectors);
//
//                                return scenariosRepository.findById(initial_case_id)
//                                        .map(resscenarios-> {
//                                            operations.setInitial_case(resscenarios);
//
//                                            return scenariosRepository.findById(last_case_id)
//                                                    .map(resscenario-> {
//                                                        operations.setLast_case_id(resscenario);
//
////                                                        return usersReposirory.findById(id_user)
////                                                                .map(resuser-> {
////                                                                    operations.se(resscenario);
////
////                                                                    return operationsRepository.save(operations);
////                                                                } ).orElseThrow(() ->new RuntimeException(""));
//
//                                                        return operationsRepository.save(operations);
//                                                    } ).orElseThrow(() ->new RuntimeException(""));
//
//                                        } ).orElseThrow(() ->new RuntimeException(""));
//
//
//                            } ).orElseThrow(() ->new RuntimeException(""));
//
//
//                } ).orElseThrow(() ->new RuntimeException(""));
        Countrie countrie = countrieRepository.getOne(country_id);
        DnfbpsSectors dnfbpsSectors = dnfbpsSectorsRepository.getOne(profession_id);

        Scenarios initial_case = new Scenarios(null, new Date(), new Date(), "Initial Case");
        Scenarios Scenarios = new Scenarios(null, new Date(), new Date(), "Initial Case");

        Set<Scenarios> scenariosSet = new HashSet<>();

        Scenarios.setOperations(operations);
        scenariosSet.add(Scenarios);
        //  initial_case.setOperations(operations);
//        scenariosRepository.save(initial_case);

        operations.setCountrie(countrie);
        operations.setDnfbpsSectors(dnfbpsSectors);
//        operations.setInitial_case(initial_case);
//        operations.setLast_case_id(initial_ase);
        operations.setScenarios(scenariosSet);


        List<Questions> questions = questionsService.getQuestionsBySecteurIdAndTypeINTERMEDIATE(profession_id, Questions.Type.INTERMEDIATE_VARIABLE_TYPE, Scenarios.getId());
        for (Questions qs:questions) {
            QuestionsResponsesScenarios questionsResponsesScenarios=new QuestionsResponsesScenarios();
            questionsResponsesScenarios.setValue(0);
            questionsResponsesScenarios.setBest_value(7d);
            questionsResponsesScenarios.setScenarios(Scenarios);
            questionsResponsesScenarios.setQuestions(qs);
            questionsResponsesScenariosRepository.save(questionsResponsesScenarios);


        }


        return  operationsRepository.save(operations);
    }

    @Override
    public Operations UpdateOperations(Operations operations, Long id) {
        operations.setId(id);
        return operationsRepository.save(operations);
    }

    @Override
    @Transactional
    public void DeleteOperations(Long id) {
        List<Scenarios> scenarios= scenariosRepository.findScenariosByOperationsId(id);
        for (Scenarios scenario:scenarios)
            {
                questionsResponsesScenariosRepository.deleteByScenariosId(scenario.getId());
            }
        operationsRepository.deleteById(id);
    }

    @Override
    public Operations AddOperations(Operations Operations) {
        return operationsRepository.save(Operations);
    }
}
