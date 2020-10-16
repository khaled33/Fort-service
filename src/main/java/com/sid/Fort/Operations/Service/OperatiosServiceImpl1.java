package com.sid.Fort.Operations.Service;

import com.sid.Fort.Countries.Entity.Countrie;
import com.sid.Fort.Countries.Dao.CountrieRepository;
import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectorsRepository;
import com.sid.Fort.Operations.Entity.Operations;
import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.QuestionsEntryPage.Entity.Questions;
import com.sid.Fort.QuestionsEntryPage.Service.QuestionsServiceImpl;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity.QuestionsResponsesScenariosEntryPage;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.UserDetails.Dao.AppUsersRepository;
import com.sid.Fort.UserDetails.Entity.AppUser;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    @Autowired
    private AppUsersRepository appUsersRepository;
    @Override
    public Operations getOperationsById(Long id) {
        try {
            return operationsRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public String getDesignationOpirationById(Long id) {
        try {
            return operationsRepository.getDesignationOpirationById(id);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<Operations> getAllOperations(Long id_user,String authorizationHeader) {



        Object EmailToken = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        AppUser appUser=appUsersRepository.findByEmail(EmailToken.toString());
        if (appUser.getId().equals(id_user)){
            return operationsRepository.getAllOperationsByAppUserId(id_user);
        }
    return null;
    }

    @Transactional
    @Override
    public Operations AddOperations(Operations operations,
                                    Long country_id,
                                    Long id_User,
                                    Long profession_id

    ) {


        Countrie countrie = countrieRepository.getOne(country_id);
        DnfbpsSectors dnfbpsSectors = dnfbpsSectorsRepository.getOne(profession_id);

        Scenarios Scenarios = new Scenarios(null, new Date(), "Initial Case");
        AppUser user = usersReposirory.getOne(id_User);

        Set<Scenarios> scenariosSet = new HashSet<>();

        Scenarios.setOperations(operations);
        scenariosSet.add(Scenarios);


        operations.setCountrie(countrie);
        operations.setAppUser(user);
        operations.setDnfbpsSectors(dnfbpsSectors);

        operations.setScenarios(scenariosSet);


        List<Questions> questions = questionsService.getQuestionsBySecteurIdAndTypeINTERMEDIATE(profession_id, Questions.Type.INTERMEDIATE_VARIABLE_TYPE, Scenarios.getId());
        for (Questions qs : questions) {
            QuestionsResponsesScenariosEntryPage questionsResponsesScenarios = new QuestionsResponsesScenariosEntryPage();
            questionsResponsesScenarios.setValue(0);
            questionsResponsesScenarios.setScenarios(Scenarios);
            questionsResponsesScenarios.setQuestions(qs);
            questionsResponsesScenariosRepository.save(questionsResponsesScenarios);


        }


        return operationsRepository.save(operations);
    }

    @Override
    public Operations UpdateOperations(Operations operations, Long id) {
        operations.setId(id);
        return operationsRepository.save(operations);
    }

    @Override
    @Transactional
    public void DeleteOperations(Long id) {
        List<Scenarios> scenarios = scenariosRepository.findScenariosByOperationsId(id);
        for (Scenarios scenario : scenarios) {
            questionsResponsesScenariosRepository.deleteByScenariosId(scenario.getId());
        }
        // scenariosRepository.deleteAll(scenarios);

        operationsRepository.deleteById(id);
    }

    @Override
    public Operations AddOperations(Operations Operations) {
        return operationsRepository.save(Operations);
    }
}
