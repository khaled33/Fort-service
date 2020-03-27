package com.sid.Fort.Calcules.VulMap.Service;

import com.sid.Fort.Calcules.VulMap.Entity.VulMaPChldrenl;
import com.sid.Fort.Calcules.VulMap.Entity.VulMap;
import com.sid.Fort.Calcules.VulMap.Entity.VulMap_no_children;
import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.QuestionsResponsesScenarios.Service.QuestionsResponsesScenariosServiceImpl;
import com.sid.Fort.QuestionsWeights.Dao.QuestionsWeights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class VulMapService {
    @Autowired
    private QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;


    public void calcule(Long id_Scenario) {

        List<QuestionsResponsesScenarios>
                QuestionsResponsesScenarios =
                questionsResponsesScenariosRepository.findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(id_Scenario, Questions.Type.INTERMEDIATE_VARIABLE_TYPE);
//            trier les qss selon ordre
        QuestionsResponsesScenarios.sort((l, r) -> l.getQuestions().getIndx().compareTo(r.getQuestions().getIndx()));

        for (QuestionsResponsesScenarios qrs : QuestionsResponsesScenarios) {

            System.out.println(qrs.getQuestions().getText() + " text");
            System.out.println(qrs.getQuestions().getIndx() + " order");
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
                QuestionsResponsesScenarios questionsResponsesScenarios = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(qs.getId(), idqSenario);

                if (questionsResponsesScenarios != null) {
                    valeus = questionsResponsesScenarios.getValue();


                    Integer questionsWeights = qs.getQuestionsWeights().getWeight();
                    Boolean Prerequisite = qs.getQuestionsWeights().getPrerequisite();

                    System.out.println(qs.getText() + " valus parat");
                    System.out.println(valeus + " valus parat");
                    System.out.println(questionsWeights + " witegh parant");
                    System.out.println(Prerequisite + " Prerequisite");
                    System.out.println("--------------------------------------");

                    if (qrs.getQuestions().getIndx() == 6) {
                        questionsWeights = 1;
                        Prerequisite = false;

                    }
                    if (qrs.getQuestions().getIndx() == 4) {
                        if (qs.getText().equals("Qualité de la supervision de la LBC")) {
                            questionsWeights = 2;
                            Prerequisite = true;

                        }
                        if (qs.getText().equals("Efficacité des systèmes de conformité")) {
                            questionsWeights = 1;
                            Prerequisite = false;
                        }
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
            System.out.println("min" + MinPrerequisite.toString());
            System.out.println("**********");


        }
    }

    public VulMap getVueVulMap(Long id_Scenario) {
        QuestionsResponsesScenarios Qrs = questionsResponsesScenariosRepository.findQuestionsResponsesScenariosByScenariosIdAndQuestionsTypeAndQuestionsIndx(id_Scenario, Questions.Type.INTERMEDIATE_VARIABLE_TYPE, 7);

        VulMaPChldrenl map = new VulMaPChldrenl();
        Map<String, String> data = new HashMap<>();
        List<VulMap> Children_Niveau_1 = new ArrayList<>();

        map.setId(Qrs.getQuestions().getId().toString());
        map.setName(Qrs.getValue() + ":" + Qrs.getQuestions().getText());

        data.put("value", "" + Qrs.getValue());
        map.setData(data);


        for (Questions QsParant_Niveau_1 : Qrs.getQuestions().getQuestionsWeights().getParent_id()) {

            VulMaPChldrenl MapParant_Niveau_1 = new VulMaPChldrenl();

            Map<String, String> data1 = new HashMap<>();
            List<VulMap> Children_Niveau_2 = new ArrayList<>();

            MapParant_Niveau_1.setId(map.getId() + "" + QsParant_Niveau_1.getId());
            QuestionsResponsesScenarios questionsResponsesScenarios = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(QsParant_Niveau_1.getId(), id_Scenario);

            MapParant_Niveau_1.setName(questionsResponsesScenarios.getValue() + ":" + QsParant_Niveau_1.getText());

            data1.put("value", "" + questionsResponsesScenarios.getValue());
            MapParant_Niveau_1.setData(data1);


            for (Questions QsParant_Niveau_2 : QsParant_Niveau_1.getQuestionsWeights().getParent_id()) {

                VulMaPChldrenl MapParant_Niveau_2 = new VulMaPChldrenl<>();
                Map<String, String> data2 = new HashMap<>();
                List<VulMap> Children_Niveau_3 = new ArrayList<>();

                MapParant_Niveau_2.setId(QsParant_Niveau_1.getId() + "" + QsParant_Niveau_2.getId());
                QuestionsResponsesScenarios questionsResponsesScenarios1 = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(QsParant_Niveau_2.getId(), id_Scenario);
//
                MapParant_Niveau_2.setName(questionsResponsesScenarios1.getValue() + ":" + QsParant_Niveau_2.getText());
//
                data2.put("value", "" + questionsResponsesScenarios1.getValue());
                MapParant_Niveau_2.setData(data2);
//
//
                for (Questions QsParant_Niveau_3 : QsParant_Niveau_2.getQuestionsWeights().getParent_id()) {

                    VulMaPChldrenl MapParant_Niveau_3 = new VulMaPChldrenl<>();
                    Map<String, String> data3 = new HashMap<>();

                    List<VulMap> Children_Niveau_4 = new ArrayList<>();
//
                    MapParant_Niveau_3.setId(QsParant_Niveau_2.getId() + "" + QsParant_Niveau_3);
                    QuestionsResponsesScenarios questionsResponsesScenarios2 = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(QsParant_Niveau_3.getId(), id_Scenario);
////
                    MapParant_Niveau_3.setName(questionsResponsesScenarios2.getValue() + ":" + QsParant_Niveau_3.getText());
////
                    data3.put("value", "" + questionsResponsesScenarios2.getValue());
                    MapParant_Niveau_3.setData(data3);

                    for (Questions QsParant_Niveau_4 : QsParant_Niveau_3.getQuestionsWeights().getParent_id()) {

                        VulMap MapParant_Niveau_4 = new VulMaPChldrenl<>();
                        Map<String, String> data4 = new HashMap<>();

//
                        MapParant_Niveau_4.setId(QsParant_Niveau_4.getId().toString());
                        QuestionsResponsesScenarios questionsResponsesScenarios3 = questionsResponsesScenariosRepository.findByQuestionsIdAndScenariosId(QsParant_Niveau_4.getId(), id_Scenario);
////
                        MapParant_Niveau_4.setName(questionsResponsesScenarios3.getValue() + ":" + QsParant_Niveau_4.getText());
////
                        data4.put("value", "" + questionsResponsesScenarios3.getValue());
                        MapParant_Niveau_4.setData(data4);
//
//
//
//
                        Children_Niveau_4.add(MapParant_Niveau_4);
                        MapParant_Niveau_3.setChildren(Children_Niveau_4);
                    }
                    Children_Niveau_3.add(MapParant_Niveau_3);
                    MapParant_Niveau_2.setChildren(Children_Niveau_3);
                }

                Children_Niveau_2.add(MapParant_Niveau_2);
                MapParant_Niveau_1.setChildren(Children_Niveau_2);


            }

            Children_Niveau_1.add(MapParant_Niveau_1);
            map.setChildren(Children_Niveau_1);


        }

        return map;
    }
}
