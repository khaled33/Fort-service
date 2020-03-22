package com.sid.Fort.Calcules.VulMap;

import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.QuestionsResponsesScenarios.Service.QuestionsResponsesScenariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class VulMapService {
    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;
    @Autowired
    QuestionsResponsesScenariosServiceImpl questionsResponsesScenariosService;

    public void calcule(Long id_Scenario) {

        List<QuestionsResponsesScenarios>
                QuestionsResponsesScenarios =
                questionsResponsesScenariosRepository.findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(id_Scenario, Questions.Type.INTERMEDIATE_VARIABLE_TYPE);
//            trier les qss selon ordre
        QuestionsResponsesScenarios.sort((l, r) -> l.getQuestions().getOrdre().compareTo(r.getQuestions().getOrdre()));

        for (QuestionsResponsesScenarios qrs : QuestionsResponsesScenarios) {

            System.out.println(qrs.getQuestions().getText() + " text");
            System.out.println(qrs.getQuestions().getOrdre() + " order");
            Long idqrs = qrs.getId();
            Long idqSenario = qrs.getScenarios().getId();
            double somVal = 0;
            double somWeights = 0;
            double res;
            double min = 0;
            Double valeus;
            List<Double> MinPrerequisite = new ArrayList<>();
            Double testPrerequisite = null;
//
           for (Questions qs : qrs.getQuestions().getQuestionsWeights().getParent_id()) {

              // Double valeus = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(qs.getId(),idqSenario).getValue();
              QuestionsResponsesScenarios  questionsResponsesScenarios = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(qs.getId(),idqSenario);

        if (questionsResponsesScenarios!=null){
             valeus =questionsResponsesScenarios.getValue();


                Integer questionsWeights = qs.getQuestionsWeights().getWeight();
                Boolean Prerequisite = qs.getQuestionsWeights().getPrerequisite();

                System.out.println(qs.getText() + " valus parat");
                System.out.println(valeus + " valus parat");
                System.out.println(questionsWeights + " witegh parant");
                System.out.println(Prerequisite + " Prerequisite");
                System.out.println("--------------------------------------");

                if (qrs.getQuestions().getOrdre() == 6) {
                    questionsWeights = 1;
                }
                if (qrs.getQuestions().getOrdre() == 4) {
                    if (qs.getText().equals("Qualité de la supervision de la LBC valus"))
                    questionsWeights = 2;
                    Prerequisite=true;
                }
                somVal += valeus * questionsWeights;
                somWeights += questionsWeights;


                if (Prerequisite)
                    testPrerequisite = valeus;
                else
                    testPrerequisite = Double.valueOf(99);

                MinPrerequisite.add(testPrerequisite);

            min = MinPrerequisite.stream().min(Comparator.naturalOrder()).get();

        }
           }
            res = somVal / somWeights;


            double ArrondirRest = (double) Math.round(res * 100) / 100;
            double ArrondirMin = (double) Math.round(min * 100) / 100;
            qrs.setValue(Math.min(ArrondirRest, ArrondirMin));

            questionsResponsesScenariosRepository.save(qrs);
            System.out.println("RES" + Math.min(ArrondirRest, ArrondirMin));
            System.out.println("min" +  MinPrerequisite.toString());
            System.out.println("**********");


        }
    }


}
