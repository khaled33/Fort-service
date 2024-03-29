package com.sid.Fort.QuestionsEntryPage.Service;

import com.sid.Fort.DnfbpsSectors.Entity.DnfbpsSectors;
import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectorsRepository;
import com.sid.Fort.QuestionsEntryPage.Entity.Questions;
import com.sid.Fort.QuestionsEntryPage.Dao.QuestionsRepository;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity.QuestionsResponsesScenariosEntryPage;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.ResponsesGroups.Entity.ResponsesGroups;
import com.sid.Fort.ResponsesGroups.Dao.ResponsesGroupsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionsServiceImpl implements IQuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private DnfbpsSectorsRepository dnfbpsSectorsRepository;

    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;
    @Autowired
        private ResponsesGroupsRepository responsesGroupsRepository;

    @Override
    public Questions getQuestionsById(Long id) {
        try {
            return questionsRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<Questions> getQuestionsBySecteurIdAndType(Long id_Secteur, Enum tyoe, Long scenario_id) {

        List<Questions> questions = questionsRepository.findQuestionsBySecteurIdAndType(id_Secteur, tyoe);
        List<Questions> questions1 = questionsRepository.findQuestionsBySecteurIdAndType(id_Secteur, Questions.Type.INTERMEDIATE_VARIABLE_TYPE);
//            trier les qss selon ordre
        questions.sort((l, r) -> l.getIndx().compareTo(r.getIndx()));
        for (Questions qs : questions) {
            QuestionsResponsesScenariosEntryPage questionsResponsesScenarios = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(qs.getId(), scenario_id);
            if (questionsResponsesScenarios != null)
                qs.setRespSelected(questionsResponsesScenarios.getResponses().getId());
           // else qs.setRespSelected((long) -1);
        }

//        fussuoner les deux list du seustion list 1=INTERMEDIATE_VARIABLE_TYPE list2= entrypage
//        List<Questions> combinedList = Stream.of(questions, questions1)
//                .flatMap(x -> x.stream())
//                .collect(Collectors.toList());

        return questions;
    }

    @Override
    public List<Questions> getQuestionsBySecteurIdAndTypeINTERMEDIATE(Long id_Secteur, Enum tyoe, Long scenario_id) {

        return questionsRepository.findQuestionsBySecteurIdAndType(id_Secteur, tyoe);
    }


    @Override
    public List<Questions> getAllQuestions() {

        return questionsRepository.findAll();
    }

    @Override
    public Questions AddQuestions(Questions Questions) {
        return questionsRepository.save(Questions);
    }

    @Override
    public Questions AddQuestionsid_Secteur(Questions Questions, Long id_Secteur,Long id_responsesGroups) {

        List<DnfbpsSectors> dnfbpsSectors = dnfbpsSectorsRepository.findAllById(Collections.singleton(id_Secteur));
        ResponsesGroups responsesGroups=responsesGroupsRepository.getOne(id_responsesGroups);

        Questions.setSecteur(dnfbpsSectors);
        Questions.setResponsesGroups(responsesGroups);
        return questionsRepository.save(Questions);
    }

    @Override
    public Questions UpdateQuestions(Questions Questions, Long id) {
        Questions.setId(id);
        return questionsRepository.save(Questions);
    }

    @Override
    public void DeleteQuestions(Long id) {
        questionsRepository.deleteById(id);
    }
}
