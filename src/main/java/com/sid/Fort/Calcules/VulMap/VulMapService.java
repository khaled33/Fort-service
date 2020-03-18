package com.sid.Fort.Calcules.VulMap;

import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VulMapService {
    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;

    public void  calcule(Long id_Scenario){

       List<QuestionsResponsesScenarios>
               QuestionsResponsesScenarios=
               questionsResponsesScenariosRepository.findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(id_Scenario,Questions.Type.INTERMEDIATE_VARIABLE_TYPE);

        for (QuestionsResponsesScenarios qrs:QuestionsResponsesScenarios) {

            System.out.println(qrs.getQuestions().getQuestionsWeights().getWeight());

        }
    }



}
