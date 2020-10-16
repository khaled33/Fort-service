package com.sid.Fort.Prioritization.Service;

import com.sid.Fort.Prioritization.Dao.PrioritizationRepository;
import com.sid.Fort.Prioritization.Entity.Case;
import com.sid.Fort.Prioritization.Entity.PrioritizationEntity;
import com.sid.Fort.Prioritization.StringsPrioritization;
import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.Scenarios.Dao.ScenariosRepository;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionRequiredException;
import java.util.*;
import java.util.stream.Stream;

import static com.sid.Fort.Prioritization.StringsPrioritization.*;

@Service
public class PrioritizationServiceImpl implements PrioritizationService, StringsPrioritization {

    @Autowired
    QuestionsResponsesScenariosRepository questionsResponsesScenariosRepository;

    @Autowired
    ScenariosRepository scenariosRepository;
    @Autowired
    PrioritizationRepository prioritizationRepository;


    @Override
    @Transactional
    public List<PrioritizationEntity> PrioritizationCalcule(Long id_Scenarios) {

        if(prioritizationRepository.getAllByScenariosId(id_Scenarios)!=null)
                 prioritizationRepository.deleteAllByScenariosId(id_Scenarios);

        Double minNumber;
        Double minNumber2;
        Double minNumber3;
        Double minNumber4;
        Double minNumber5;
        Double minNumber6;
        String Question = "";
        Scenarios scenarios = scenariosRepository.findById(id_Scenarios).get();

        List<Case> ListCaseYear = YearCalcule(id_Scenarios);
        if(ListCaseYear.size()>0){
        List<PrioritizationEntity> ListprioritizationEntities = new ArrayList<>();

        List<Case> ListCase = Insert_Other_Case_Scenario(id_Scenarios);
        for (int i = 0; i < 13; i++) {
            PrioritizationEntity prioritizationEntity = new PrioritizationEntity();
            if (i == 0) {
                if (ListCaseYear.get(11).getValue_reponse() >= 0.7) {
                    ListCase.get(11).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(11).getQuestion();
                ListCase.get(11).setValue_reponse(ListCaseYear.get(11).getValue_reponse());
                ListCase.get(11).setPrerequisites(ListCaseYear.get(11).getValue_reponse());
            } else if (i == 1) {

                ListCase.get(11).setValue_reponse(0.7);
                ListCase.get(11).setPrerequisites(0.7);

                if (ListCaseYear.get(10).getValue_reponse() >= 0.7) {
                    ListCase.get(10).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(10).getQuestion();

                ListCase.get(10).setValue_reponse(ListCaseYear.get(10).getValue_reponse());
                ListCase.get(10).setPrerequisites(ListCaseYear.get(10).getWieghts());
            } else if (i == 2) {
                ListCase.get(10).setValue_reponse(0.7);
                ListCase.get(10).setPrerequisites(99.0);

                if (ListCaseYear.get(12).getValue_reponse() >= 0.7) {
                    ListCase.get(12).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(12).getQuestion();

                ListCase.get(12).setValue_reponse(ListCaseYear.get(12).getValue_reponse());
                ListCase.get(12).setPrerequisites(99.0);
            }


            if (i == 3) {
                ListCase.get(12).setValue_reponse(0.7);
                ListCase.get(12).setPrerequisites(99.0);
                if (ListCaseYear.get(9).getValue_reponse() >= 0.7) {
                    ListCase.get(9).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(9).getQuestion();

                ListCase.get(9).setValue_reponse(ListCaseYear.get(9).getValue_reponse());
                ListCase.get(12).setPrerequisites(99.0);
            }
            if (i == 4) {

                ListCase.get(10).setValue_reponse(0.7);
                ListCase.get(9).setValue_reponse(0.7);
                ListCase.get(10).setPrerequisites(99.0);
                if (ListCaseYear.get(6).getValue_reponse() >= 0.7) {
                    ListCase.get(6).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(6).getQuestion();

                ListCase.get(6).setValue_reponse(ListCaseYear.get(6).getValue_reponse());

            }
            if (i == 5) {
                ListCase.get(6).setValue_reponse(0.7);
                ListCase.get(6).setPrerequisites(99.0);
                if (ListCaseYear.get(7).getValue_reponse() >= 0.7) {
                    ListCase.get(7).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(7).getQuestion();

                ListCase.get(7).setValue_reponse(ListCaseYear.get(7).getValue_reponse());
                ListCase.get(7).setPrerequisites(ListCaseYear.get(7).getValue_reponse());
            }
            if (i == 6) {
                ListCase.get(7).setValue_reponse(0.7);
                ListCase.get(7).setPrerequisites(0.7);
                if (ListCaseYear.get(8).getValue_reponse() >= 0.7) {
                    ListCase.get(8).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(8).getQuestion();

                ListCase.get(8).setValue_reponse(ListCaseYear.get(8).getValue_reponse());
                ListCase.get(8).setPrerequisites(99.0);
            }
            if (i == 7) {
                ListCase.get(8).setValue_reponse(0.7);
                ListCase.get(8).setPrerequisites(99.0);
                if (ListCaseYear.get(4).getValue_reponse() >= 0.7) {
                    ListCase.get(4).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(4).getQuestion();

                ListCase.get(4).setValue_reponse(ListCaseYear.get(4).getValue_reponse());
                ListCase.get(4).setPrerequisites(ListCaseYear.get(4).getValue_reponse());
            }
            if (i == 8) {
                ListCase.get(4).setValue_reponse(0.7);
                ListCase.get(4).setPrerequisites(0.7);
                if (ListCaseYear.get(5).getValue_reponse() >= 0.7) {
                    ListCase.get(5).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(5).getQuestion();

                ListCase.get(5).setValue_reponse(ListCaseYear.get(5).getValue_reponse());
                ListCase.get(5).setPrerequisites(99.0);
            }
            if (i == 9) {


                ListCase.get(5).setValue_reponse(0.7);
                if (ListCaseYear.get(2).getValue_reponse() >= 0.7) {
                    ListCase.get(2).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(2).getQuestion();

                ListCase.get(2).setValue_reponse(ListCaseYear.get(2).getValue_reponse());
                ListCase.get(2).setPrerequisites(99.0);
            }
            if (i == 10) {

                ListCase.get(2).setValue_reponse(0.7);
                ListCase.get(2).setPrerequisites(99.0);
                if (ListCaseYear.get(3).getValue_reponse() >= 0.7) {
                    ListCase.get(3).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(3).getQuestion();

                ListCase.get(3).setValue_reponse(ListCaseYear.get(3).getValue_reponse());
                ListCase.get(3).setPrerequisites(99.0);
            }
            if (i == 11) {

                ListCase.get(3).setValue_reponse(0.7);
                ListCase.get(3).setPrerequisites(99.0);
                if (ListCaseYear.get(1).getValue_reponse() >= 0.7) {
                    ListCase.get(1).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(1).getQuestion();

                ListCase.get(1).setValue_reponse(ListCaseYear.get(1).getValue_reponse());
                ListCase.get(1).setPrerequisites(99.0);
            }
            if (i == 12) {

                ListCase.get(1).setValue_reponse(0.7);
                if (ListCaseYear.get(0).getValue_reponse() >= 0.7) {
                    ListCase.get(0).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(0).getQuestion();

                ListCase.get(0).setValue_reponse(ListCaseYear.get(0).getValue_reponse());
                ListCase.get(0).setPrerequisites(99.0);
            }

//            System.out.println("******" + (i + 1));

//  calcule Qualité de la supervision de la LBC
            Double Qualité_de_la_supervision_de_la_LBC = ((ListCase.get(4).getValue_reponse() * ListCase.get(4).getWieghts()) +
                    (ListCase.get(5).getValue_reponse() * ListCase.get(5).getWieghts())) /
                    ((ListCase.get(4).getWieghts()) + (ListCase.get(5).getWieghts()));

            minNumber = Stream.of(ListCase.get(4).getPrerequisites(), ListCase.get(5).getPrerequisites(), Qualité_de_la_supervision_de_la_LBC)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();
            ListCase.add(new Case("Qualité de la supervision de la LBC", minNumber, minNumber));
//   fin calcule Qualité de la supervision de la LBC


//        calcule Engagement et leadership des directions des banques

            Double Engagement_et_leadership_des_directions_des_banques =
                    ((ListCase.get(1).getValue_reponse() * ListCase.get(1).getWieghts()) +
                            (ListCase.get(2).getValue_reponse() * ListCase.get(2).getWieghts()) +
                            (ListCase.get(3).getValue_reponse() * ListCase.get(3).getWieghts()) +
                            (minNumber * 4)) /
                            (ListCase.get(1).getWieghts() + ListCase.get(2).getWieghts() + ListCase.get(3).getWieghts() + 4);


            minNumber2 = Stream.of(ListCase.get(1).getPrerequisites(), ListCase.get(2).getPrerequisites(), ListCase.get(3).getPrerequisites(), Engagement_et_leadership_des_directions_des_banques, 99.00)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();


            ListCase.add(new Case("Engagement et leadership des directions des banques", minNumber2, minNumber2));
            Double Disponibilite_et_application_de_sanctions_penales = ListCase.get(1).getValue_reponse();
            ListCase.add(new Case("Disponibilite et application de sanctions penales", Disponibilite_et_application_de_sanctions_penales, 0.99));
//   fin calcule Engagement et leadership des directions des banques

//        calcule Conformité du personnel des banques
            Disponibilite_et_application_de_sanctions_penales = 0.7;
            Qualité_de_la_supervision_de_la_LBC = 0.7;
            if (i == 7 || i == 8) {
                Qualité_de_la_supervision_de_la_LBC = minNumber;
            }
            Double Conformite_du_personnel_des_banques =
                    ((ListCase.get(6).getValue_reponse() * ListCase.get(6).getWieghts()) +
                            (ListCase.get(7).getValue_reponse() * ListCase.get(7).getWieghts()) +
                            (ListCase.get(8).getValue_reponse() * ListCase.get(8).getWieghts()) +
                            (Disponibilite_et_application_de_sanctions_penales * 1) +
                            (Qualité_de_la_supervision_de_la_LBC * 2)) /
                            (ListCase.get(6).getWieghts() + ListCase.get(7).getWieghts() + ListCase.get(8).getWieghts() + 1 + 2);


            minNumber3 = Stream.of(Conformite_du_personnel_des_banques, ListCase.get(6).getPrerequisites(), ListCase.get(7).getPrerequisites(), ListCase.get(8).getPrerequisites(), Qualité_de_la_supervision_de_la_LBC, 99.00)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();
//
            ListCase.add(new Case("Conformité du personnel des banques", minNumber3, minNumber3));
//   fin calcule Conformité du personnel des banques

//        calcule Qualité du cadre de CDD

            Double Qualite_du_cadre_de_CDD =

                    ((ListCase.get(10).getValue_reponse() * ListCase.get(10).getWieghts()) +
                            (ListCase.get(11).getValue_reponse() * ListCase.get(11).getWieghts()) +
                            (ListCase.get(12).getValue_reponse() * ListCase.get(12).getWieghts())) /

                            (ListCase.get(10).getWieghts() + ListCase.get(11).getWieghts() + ListCase.get(12).getWieghts());


            minNumber4 = Stream.of(ListCase.get(9).getPrerequisites(), ListCase.get(10).getPrerequisites(), ListCase.get(11).getPrerequisites(), ListCase.get(12).getPrerequisites(), Qualite_du_cadre_de_CDD)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();


            ListCase.add(new Case("Qualité du cadre de CDD", minNumber4, 99D));
            //   fin calcule Qualité du cadre de CDD

//         Qualité des opérations des banques


            Double Qualite_des_operations_des_banques =
                    ((minNumber4) +
                            (ListCase.get(9).getValue_reponse() * ListCase.get(9).getWieghts()) +
                            ((minNumber3 * 3) +
                                    (minNumber2 * 3))) /
                            (7 + ListCase.get(9).getWieghts());


            if (i == 4 || i == 5 || i == 6 || i == 7 || i == 8) {
                minNumber5 = Stream.of(
                        Qualite_des_operations_des_banques,
                        minNumber3,
                        Conformite_du_personnel_des_banques,
                        getPre(ListCase, "Engagement et leadership des directions des banques"),
                        ListCase.get(9).getPrerequisites())
                        .min(Comparator.comparing(Double::valueOf))
                        .get();
            } else {
                minNumber5 = Stream.of(
                        Qualite_des_operations_des_banques,
                        getPre(ListCase, "Qualité du cadre de CDD"),
                        getPre(ListCase, "Conformité du personnel des banques"),
                        getPre(ListCase, "Engagement et leadership des directions des banques"),
                        ListCase.get(9).getPrerequisites())
                        .min(Comparator.comparing(Double::valueOf))
                        .get();

            }
            if (i == 9 || i == 10 || i == 11) {
                minNumber5 = Stream.of(
                        Qualite_des_operations_des_banques,
                        minNumber3,
                        Conformite_du_personnel_des_banques,
                        minNumber2,
                        ListCase.get(9).getPrerequisites())
                        .min(Comparator.comparing(Double::valueOf))
                        .get();
            }

            ListCase.add(new Case("Qualité des opérations des banques", minNumber5, 99D));


            //  fin  Qualité des opérations des banques


//  Qualité des politiques et procédures internes de LBC

            Double Qualite_des_politiques_et_procedures_internes_de_LBC =
                    ((ListCase.get(0).getValue_reponse())
                            + (minNumber2) + (ListCase.get(8).getValue_reponse())) /
                            3;
            minNumber6 = Stream.of(minNumber5, Qualite_des_politiques_et_procedures_internes_de_LBC)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();
            ListCase.add(new Case("QUALITY OF GENERAL AML CONTROLS", minNumber6, 99D));

            Double Impact_on_Quality_of_General_AML_Controls = null;
            System.out.println(ListCaseYear.get(i).getValue_reponse());
            if (ListCaseYear.get(i).getValue_reponse() < 0.7) {
                Impact_on_Quality_of_General_AML_Controls = minNumber6 - 0.7;


            }  if (ListCaseYear.get(i).getValue_reponse() > 0.7){
                Impact_on_Quality_of_General_AML_Controls = 1D;
            }

            prioritizationEntity.setPrioritizatioValues((double) Math.round(Impact_on_Quality_of_General_AML_Controls * 10000) / 10000);
            prioritizationEntity.setQuestion(Question);
            ListprioritizationEntities.add(prioritizationEntity);
        }

        ListprioritizationEntities.sort((o1, o2) -> Double.compare(o1.getPrioritizatioValues(), o2.getPrioritizatioValues()));
        for (int i = 0; i < ListprioritizationEntities.size(); i++) {
            ListprioritizationEntities.get(i).setRank(i + 1);
            ListprioritizationEntities.get(i).setScenarios(scenarios);
            System.out.println(ListprioritizationEntities.get(i).toString());

        }
        return prioritizationRepository.saveAll(ListprioritizationEntities);}else return null;
    }

    private List<Case> YearCalcule(Long id_Scenarios) {

        List<Case> ListCase = Insert_YEAR_Case_Scenario(id_Scenarios);
if(ListCase!=null){

//  calcule Qualité de la supervision de la LBC
        Double Qualité_de_la_supervision_de_la_LBC = (ListCase.get(4).getValue_reponse() * ListCase.get(4).getWieghts() +
                (ListCase.get(5).getValue_reponse() * ListCase.get(5).getWieghts())) /
                (ListCase.get(4).getWieghts() + ListCase.get(5).getWieghts());

        Double minNumber = Stream.of(ListCase.get(4).getPrerequisites(), ListCase.get(5).getPrerequisites(), Qualité_de_la_supervision_de_la_LBC)
                .min(Comparator.comparing(Double::valueOf))
                .get();


        ListCase.add(new Case("Qualité de la supervision de la LBC", minNumber, minNumber));
//   fin calcule Qualité de la supervision de la LBC


//        calcule Engagement et leadership des directions des banques

        Double Engagement_et_leadership_des_directions_des_banques =
                ((ListCase.get(1).getValue_reponse() * ListCase.get(1).getWieghts()) +
                        (ListCase.get(2).getValue_reponse() * ListCase.get(2).getWieghts()) +
                        (ListCase.get(3).getValue_reponse() * ListCase.get(3).getWieghts()) +
                        (minNumber * 4)) /
                        (ListCase.get(1).getWieghts() + ListCase.get(2).getWieghts() + ListCase.get(3).getWieghts() + 4);


        Engagement_et_leadership_des_directions_des_banques = (double) Math.round(Engagement_et_leadership_des_directions_des_banques * 100) / 100;

        Double minNumber2 = Stream.of(ListCase.get(1).getPrerequisites(), ListCase.get(2).getPrerequisites(), ListCase.get(3).getPrerequisites(), Engagement_et_leadership_des_directions_des_banques, 99.00)
                .min(Comparator.comparing(Double::valueOf))
                .get();


        ListCase.add(new Case("Engagement et leadership des directions des banques", minNumber2, minNumber2));
        Double Disponibilite_et_application_de_sanctions_penales = ListCase.get(1).getValue_reponse();
        ListCase.add(new Case("Disponibilite et application de sanctions penales", Disponibilite_et_application_de_sanctions_penales, 0.99));
//   fin calcule Engagement et leadership des directions des banques

//        calcule Conformité du personnel des banques

        Double Conformite_du_personnel_des_banques =
                ((ListCase.get(6).getValue_reponse() * ListCase.get(6).getWieghts()) +
                        (ListCase.get(7).getValue_reponse() * ListCase.get(7).getWieghts()) +
                        (ListCase.get(8).getValue_reponse() * ListCase.get(8).getWieghts()) +
                        (Disponibilite_et_application_de_sanctions_penales * 1) +
                        (Qualité_de_la_supervision_de_la_LBC * 2)) /
                        (ListCase.get(6).getWieghts() + ListCase.get(7).getWieghts() + ListCase.get(8).getWieghts() + 1 + 2);


        Double minNumber3 = Stream.of(Conformite_du_personnel_des_banques, ListCase.get(6).getPrerequisites(), ListCase.get(7).getPrerequisites(), ListCase.get(8).getPrerequisites(), Qualité_de_la_supervision_de_la_LBC, 99.00)
                .min(Comparator.comparing(Double::valueOf))
                .get();

        ListCase.add(new Case("Conformité du personnel des banques", minNumber3, minNumber3));
//   fin calcule Conformité du personnel des banques

//        calcule Qualité du cadre de CDD

        Double Qualite_du_cadre_de_CDD =

                ((ListCase.get(10).getValue_reponse() * ListCase.get(10).getWieghts()) +
                        (ListCase.get(11).getValue_reponse() * ListCase.get(11).getWieghts()) +
                        (ListCase.get(12).getValue_reponse() * ListCase.get(12).getWieghts())) /

                        (ListCase.get(10).getWieghts() + ListCase.get(11).getWieghts() + ListCase.get(12).getWieghts());


        Double minNumber4 = Stream.of(ListCase.get(9).getPrerequisites(), ListCase.get(10).getPrerequisites(), ListCase.get(11).getPrerequisites(), ListCase.get(12).getPrerequisites(), Qualite_du_cadre_de_CDD)
                .min(Comparator.comparing(Double::valueOf))
                .get();

        ListCase.add(new Case("Qualité du cadre de CDD", minNumber4, 99D));
        //   fin calcule Qualité du cadre de CDD

//         Qualité des opérations des banques


        Double Qualite_des_operations_des_banques =
                ((minNumber4) +
                        (ListCase.get(9).getValue_reponse() * ListCase.get(9).getWieghts()) +
                        ((minNumber3 * 3) +
                                (minNumber2 * 3))) / (7 + ListCase.get(9).getWieghts());


        Double minNumber5 = Stream.of(
                Qualite_des_operations_des_banques,
                getPre(ListCase, "Qualité du cadre de CDD"),
                getPre(ListCase, "Conformité du personnel des banques"),
                getPre(ListCase, "Engagement et leadership des directions des banques"),
                ListCase.get(9).getPrerequisites())
                .min(Comparator.comparing(Double::valueOf))
                .get();
        ListCase.add(new Case("Qualité des opérations des banques", minNumber5, 99D));

        //  fin  Qualité des opérations des banques


//  Qualité des politiques et procédures internes de LBC

        Double Qualite_des_politiques_et_procedures_internes_de_LBC =
                ((ListCase.get(0).getValue_reponse())
                        + (minNumber2) + (ListCase.get(8).getValue_reponse())) /
                        3;
        Double minNumber6 = Stream.of(minNumber5,  Qualite_des_politiques_et_procedures_internes_de_LBC )
                .min(Comparator.comparing(Double::valueOf))
                .get();
        ListCase.add(new Case("QUALITY OF GENERAL AML CONTROLS", minNumber6, 99D));

        return ListCase;}else return null;
    }

    @Transactional
    public List<Case> Insert_YEAR_Case_Scenario(Long id_Scenarios) {

        Map<String, Map<Double, Double>> map = new HashMap<>();


        List<Double> values;
        values = questionsResponsesScenariosRepository.getValue_ENTRY_PAGE_TYPE(id_Scenarios);
        if (values!=null){
        List<Integer> wieght;
        wieght = questionsResponsesScenariosRepository.getWeight_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Boolean> prerequisites;
        prerequisites = questionsResponsesScenariosRepository.getPREREQUISITES_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Case> ListCase = new ArrayList<>();

        for (int i = 0; i < getQeustion().size(); i++) {

            Case aCase = new Case();
            aCase.setQuestion(getQeustion().get(i));

            aCase.setValue_reponse(values.get(i));
            aCase.setWieghts(wieght.get(i).doubleValue());
            if (prerequisites.get(i)) {
                aCase.setPrerequisites(values.get(i));
            } else
                aCase.setPrerequisites(99.00);

            ListCase.add(aCase);


        }


        return ListCase;}else return null;
    }

    @Transactional
    public List<Case> Insert_Other_Case_Scenario(Long id_Scenarios) {

        List<Case> ListCase1 = YearCalcule(id_Scenarios);

        List<Double> values = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            values.add(0.7);
        }


        List<Integer> wieght;
        wieght = questionsResponsesScenariosRepository.getWeight_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Boolean> prerequisites;
        prerequisites = questionsResponsesScenariosRepository.getPREREQUISITES_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Case> ListCase = new ArrayList<>();

        for (int i = 0; i < getQeustion().size(); i++) {

            Case aCase = new Case();
            aCase.setQuestion(getQeustion().get(i));
            aCase.setValue_reponse(values.get(i));
            aCase.setWieghts(wieght.get(i).doubleValue());
            if (prerequisites.get(i)) {
                aCase.setPrerequisites(values.get(i));
            } else
                aCase.setPrerequisites(99.00);

            ListCase.add(aCase);


        }
/*
        map.put(Comprehensiveness_of_AML_Legal_Framework, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_and_Enforcement_of_Criminal_Sanctions, Collections.singletonMap(bestcase, Weights));
        map.put(Level_of_Market_Pressure_to_Meet_AML_Standards, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_and_Effectiveness_of_Entry_Controls, Collections.singletonMap(bestcase, Weights));
        map.put(Effectiveness_of_Supervision_Oversight_Activities, Collections.singletonMap(bestcase, bestcase));
        map.put(Availability_and_Enforcement_of_Administrative_Sanctions, Collections.singletonMap(bestcase, Weights));
        map.put(Integrity_of_Banks_Staff, Collections.singletonMap(bestcase, Weights));
        map.put(AML_Knowledge_of_Banks_Staff, Collections.singletonMap(bestcase, bestcase));
        map.put(Effectiveness_of_Compliance_Systems, Collections.singletonMap(bestcase, Weights));
        map.put(Effectiveness_of_Suspicious_Activity_Monitoring_and_Reporting, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_and_Access_to_Beneficial_Ownership_information, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_of_Reliable_Identification_Infrastructure, Collections.singletonMap(bestcase, bestcase));
        map.put(Availability_of_Independent_Information_Sources, Collections.singletonMap(bestcase, Weights));
        map.put("Qualité du cadre de CDD", Collections.singletonMap(bestcase, Weights));
        map.put("Conformité du personnel des banques", Collections.singletonMap(bestcase, bestcase));
        map.put("Qualité de la supervision de la LBC", Collections.singletonMap(bestcase, bestcase));
        map.put("Disponibilité et application de sanctions pénales", Collections.singletonMap(bestcase, Weights));
        map.put("Engagement et leadership des directions des banques", Collections.singletonMap(bestcase, bestcase));
        map.put("Qualité des politiques et procédures internes de LBC", Collections.singletonMap(bestcase, bestcase));
        map.put("Qualité de la supervision de la LBC 2", Collections.singletonMap(bestcase, Weights));
        map.put("Engagement et leadership des directions des banques 2", Collections.singletonMap(bestcase, Weights));
        map.put("Efficacité de la fonction de conformité", Collections.singletonMap(bestcase, Weights));
        System.out.println(questionsResponsesScenariosRepository.findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(14L, Questions.Type.ENTRY_PAGE_TYPE).get(0).getResponses().getValue());
*/


        return ListCase;
    }

    private Double getPre(List<Case> caseList, String question) {

        for (Case aCase : caseList) {
            if (question.equals(aCase.getQuestion()))
                return aCase.getWieghts();
        }

        return null;
    }
//*********************************************************************************************************************
//*********************************************************************************************************************
//*********************************************************************************************************************
//*********************************************************************************************************************
//*********************************************************************************************************************

    @Transactional
    public List<PrioritizationEntity> PrioritizationCalcule1(Long id_Scenarios) {
        if(prioritizationRepository.getAllByScenariosId(id_Scenarios)!=null)
            prioritizationRepository.deleteAllByScenariosId(id_Scenarios);
        Double minNumber;
        Double minNumber2;
        Double minNumber3;
        Double minNumber4;
        Double minNumber5;
        Double minNumber6;
        String Question = "";
        Scenarios scenarios = scenariosRepository.findById(id_Scenarios).get();

        List<Case> ListCaseYear = YearCalcule1(id_Scenarios);
        List<PrioritizationEntity> ListprioritizationEntities = new ArrayList<>();

        List<Case> ListCase = Insert_Other_Case_Scenario1(id_Scenarios);
        for (int i = 0; i < 12; i++) {
            PrioritizationEntity prioritizationEntity = new PrioritizationEntity();
      if (i == 0) {
                if (ListCaseYear.get(10).getValue_reponse() >= 0.7) {
                    ListCase.get(10).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(10).getQuestion();
                ListCase.get(10).setValue_reponse(ListCaseYear.get(10).getValue_reponse());
                ListCase.get(10).setPrerequisites(ListCaseYear.get(10).getValue_reponse());
            } else if (i == 1) {

                ListCase.get(10).setValue_reponse(0.7);
                ListCase.get(10).setPrerequisites(0.7);

                if (ListCaseYear.get(9).getValue_reponse() >= 0.7) {
                    ListCase.get(9).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(9).getQuestion();

                ListCase.get(9).setValue_reponse(ListCaseYear.get(9).getValue_reponse());
                ListCase.get(9).setPrerequisites(ListCaseYear.get(9).getWieghts());
            } else if (i == 2) {
                ListCase.get(9).setValue_reponse(0.7);
                ListCase.get(9).setPrerequisites(99.0);

                if (ListCaseYear.get(11).getValue_reponse() >= 0.7) {
                    ListCase.get(11).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(11).getQuestion();

                ListCase.get(11).setValue_reponse(ListCaseYear.get(11).getValue_reponse());
                ListCase.get(11).setPrerequisites(99.0);
            }


            if (i == 3) {
                ListCase.get(11).setValue_reponse(0.7);
                ListCase.get(11).setPrerequisites(99.0);
                if (ListCaseYear.get(8).getValue_reponse() >= 0.7) {
                    ListCase.get(8).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(8).getQuestion();

                ListCase.get(8).setValue_reponse(ListCaseYear.get(8).getValue_reponse());
                ListCase.get(8).setPrerequisites(99.0);
            }
            if (i == 4) {
                ListCase.get(8).setValue_reponse(0.7);
                ListCase.get(8).setPrerequisites(99.0);

                if (ListCaseYear.get(5).getValue_reponse() >= 0.7) {
                    ListCase.get(5).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(5).getQuestion();

                ListCase.get(5).setValue_reponse(ListCaseYear.get(5).getValue_reponse());

            }
          if (i == 5) {
                ListCase.get(5).setValue_reponse(0.7);
                ListCase.get(5).setPrerequisites(99.0);
                if (ListCaseYear.get(6).getValue_reponse() >= 0.7) {
                    ListCase.get(6).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(6).getQuestion();

                ListCase.get(6).setValue_reponse(ListCaseYear.get(6).getValue_reponse());
                ListCase.get(6).setPrerequisites(ListCaseYear.get(6).getValue_reponse());
            }
           if (i == 6) {
                ListCase.get(6).setValue_reponse(0.7);
                ListCase.get(6).setPrerequisites(0.7);
                if (ListCaseYear.get(7).getValue_reponse() >= 0.7) {
                    ListCase.get(7).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(7).getQuestion();

                ListCase.get(7).setValue_reponse(ListCaseYear.get(7).getValue_reponse());
                ListCase.get(7).setPrerequisites(99.0);
            }
             if (i == 7) {
                ListCase.get(7).setValue_reponse(0.7);
                ListCase.get(7).setPrerequisites(99.0);
                if (ListCaseYear.get(4).getValue_reponse() >= 0.7) {
                    ListCase.get(4).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(4).getQuestion();

                ListCase.get(4).setValue_reponse(ListCaseYear.get(4).getValue_reponse());
                ListCase.get(4).setPrerequisites(99.0);
            }
             if (i == 8) {
                ListCase.get(4).setValue_reponse(0.7);
                ListCase.get(4).setPrerequisites(0.7);
                if (ListCaseYear.get(1).getValue_reponse() >= 0.7) {
                    ListCase.get(1).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(1).getQuestion();

                ListCase.get(1).setValue_reponse(ListCaseYear.get(1).getValue_reponse());
                ListCase.get(1).setPrerequisites(ListCaseYear.get(1).getValue_reponse());
            }
           if (i == 9) {


                ListCase.get(1).setValue_reponse(0.7);
                ListCase.get(1).setPrerequisites(0.7);
                if (ListCaseYear.get(2).getValue_reponse() >= 0.7) {
                    ListCase.get(2).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(2).getQuestion();

                ListCase.get(2).setValue_reponse(ListCaseYear.get(2).getValue_reponse());
                ListCase.get(2).setPrerequisites(99.0);
            }
            if (i == 10) {

                ListCase.get(2).setValue_reponse(0.7);
                ListCase.get(2).setPrerequisites(99.0);
                if (ListCaseYear.get(3).getValue_reponse() >= 0.7) {
                    ListCase.get(3).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(3).getQuestion();

                ListCase.get(3).setValue_reponse(ListCaseYear.get(3).getValue_reponse());
                ListCase.get(3).setPrerequisites(99.0);
            }
            if (i == 11) {

                ListCase.get(3).setValue_reponse(0.7);
                ListCase.get(3).setPrerequisites(99.0);
                if (ListCaseYear.get(0).getValue_reponse() >= 0.7) {
                    ListCase.get(0).setValue_reponse(0.7);
                }
                Question = ListCaseYear.get(0).getQuestion();

                ListCase.get(0).setValue_reponse(ListCaseYear.get(0).getValue_reponse());
                ListCase.get(0).setPrerequisites(99.0);
            }

            System.out.println("******" + (i + 1));

//  calcule Qualité de la supervision de la LBC
            Double Qualite_de_la_supervision_de_la_LBC = (ListCase.get(1).getValue_reponse() * ListCase.get(1).getWieghts() +
                    (ListCase.get(2).getValue_reponse() * ListCase.get(2).getWieghts())) /
                    (ListCase.get(1).getWieghts() + ListCase.get(2).getWieghts());

             minNumber = Stream.of(ListCase.get(1).getPrerequisites(), ListCase.get(2).getPrerequisites(), Qualite_de_la_supervision_de_la_LBC)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();



            ListCase.add(new Case("Qualité de la supervision de la LBC", minNumber, 99.0));
//   fin calcule Qualité de la supervision de la LBC


//        calcule Engagement et leadership des directions des banques

            Double Engagement_et_leadership_des_directions_des_banques =
                    ((ListCase.get(3).getValue_reponse() * ListCase.get(3).getWieghts()) +
                            (ListCase.get(4).getValue_reponse() * ListCase.get(4).getWieghts()) +
                            (minNumber * 4)) /
                            (ListCase.get(3).getWieghts() + ListCase.get(4).getWieghts() + 4);


            Engagement_et_leadership_des_directions_des_banques = (double) Math.round(Engagement_et_leadership_des_directions_des_banques * 100) / 100;

             minNumber2 = Stream.of(ListCase.get(3).getPrerequisites(), ListCase.get(4).getPrerequisites(), Engagement_et_leadership_des_directions_des_banques, 99.00)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();

//            System.out.println(ListCase.get(3).getValue_reponse());
//            System.out.println(ListCase.get(4).getValue_reponse());
//            System.out.println(minNumber);


            ListCase.add(new Case("Engagement et leadership des directions des banques", minNumber2, minNumber2));

            Double Disponibilite_et_application_de_sanctions_penales = ListCase.get(3).getValue_reponse();
            ListCase.add(new Case("Disponibilite et application de sanctions penales", Disponibilite_et_application_de_sanctions_penales, 0.99));
//   fin calcule Engagement et leadership des directions des banques
//
//        calcule Conformité du personnel des banques

            Double Conformite_du_personnel_des_banques =
                    ((ListCase.get(5).getValue_reponse() * ListCase.get(5).getWieghts()) +
                            (ListCase.get(6).getValue_reponse() * ListCase.get(6).getWieghts()) +
                            (ListCase.get(7).getValue_reponse() * ListCase.get(7).getWieghts())+
                            Disponibilite_et_application_de_sanctions_penales )/
                            (ListCase.get(5).getWieghts() + ListCase.get(6).getWieghts() + ListCase.get(7).getWieghts() +1  );

             minNumber3 = Stream.of(Conformite_du_personnel_des_banques, ListCase.get(5).getPrerequisites(), ListCase.get(6).getPrerequisites(), ListCase.get(7).getPrerequisites()+1)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();

            ListCase.add(new Case("Conformité du personnel des banques", minNumber3, minNumber3));
//   fin calcule Conformité du personnel des banques
//
//        calcule Qualité du cadre de CDD

            Double Qualite_du_cadre_de_CDD =

                    ((ListCase.get(9).getValue_reponse() * ListCase.get(9).getWieghts()) +
                            (ListCase.get(10).getValue_reponse() * ListCase.get(10).getWieghts()) +
                            (ListCase.get(11).getValue_reponse() * ListCase.get(11).getWieghts())) /

                            (ListCase.get(10).getWieghts() + ListCase.get(11).getWieghts() + ListCase.get(9).getWieghts());

            Qualite_du_cadre_de_CDD = (double) Math.round(Qualite_du_cadre_de_CDD * 100) / 100;
             minNumber4 = Stream.of(ListCase.get(9).getPrerequisites(), ListCase.get(10).getPrerequisites(), ListCase.get(11).getPrerequisites(),  Qualite_du_cadre_de_CDD)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();
            ListCase.add(new Case("Qualité du cadre de CDD", minNumber4, 99D));

            //   fin calcule Qualité du cadre de CDD

//         Qualité des opérations des banques


            Double Qualite_des_operations_des_banques =
                    ((minNumber4) +
                    (ListCase.get(8).getValue_reponse() * ListCase.get(8).getWieghts()) +
                    ((minNumber3 * 3) +
                    (minNumber2 * 3))) /
                    (7 + ListCase.get(8).getWieghts());

            if (i==4||i==5||i==6){

                        minNumber5 = Stream.of(
                        minNumber2,
                        getPre(ListCase, "Qualité du cadre de CDD"),
                        minNumber3,
                        Qualite_des_operations_des_banques,
                        ListCase.get(8).getPrerequisites())
                        .min(Comparator.comparing(Double::valueOf))
                        .get();
                ListCase.add(new Case("Qualité des opérations des banques", minNumber5, 99D));
            }else {
                minNumber5 = Stream.of(
                        minNumber2,
                        getPre(ListCase, "Qualité du cadre de CDD"),
                        getPre(ListCase, "Conformité du personnel des banques"),
                        Qualite_des_operations_des_banques,
                        ListCase.get(8).getPrerequisites())
                        .min(Comparator.comparing(Double::valueOf))
                        .get();
                ListCase.add(new Case("Qualité des opérations des banques", minNumber5, 99D));
            }


            //  fin  Qualité des opérations des banques


//  Qualité des politiques et procédures internes de LBC

            Double Qualite_des_politiques_et_procedures_internes_de_LBC =
                    ((ListCase.get(0).getValue_reponse())
                            + (minNumber2) + (ListCase.get(7).getValue_reponse())) /
                            3;
             minNumber6 = Stream.of(minNumber5, (double) Math.round(Qualite_des_politiques_et_procedures_internes_de_LBC * 10000) / 10000)
                    .min(Comparator.comparing(Double::valueOf))
                    .get();
            ListCase.add(new Case("QUALITY OF GENERAL AML CONTROLS", minNumber6, 99D));
            System.out.println(minNumber6);


            Double Impact_on_Quality_of_General_AML_Controls;
            if (ListCaseYear.get(0).getValue_reponse() < 0.7) {
                Impact_on_Quality_of_General_AML_Controls = minNumber6 - 0.7;


            } else {
                Impact_on_Quality_of_General_AML_Controls = 1D;
            }
            prioritizationEntity.setPrioritizatioValues((double) Math.round(Impact_on_Quality_of_General_AML_Controls * 10000) / 10000);
            prioritizationEntity.setQuestion(Question);
            ListprioritizationEntities.add(prioritizationEntity);
        }

        ListprioritizationEntities.sort((o1, o2) -> Double.compare(o1.getPrioritizatioValues(), o2.getPrioritizatioValues()));
        for (int i = 0; i < ListprioritizationEntities.size(); i++) {
            ListprioritizationEntities.get(i).setRank(i + 1);
            ListprioritizationEntities.get(i).setScenarios(scenarios);
//            System.out.println(ListprioritizationEntities.get(i).toString());

        }
        return prioritizationRepository.saveAll(ListprioritizationEntities);
    }

    public List<Case> YearCalcule1(Long id_Scenarios) {

        List<Case> ListCase = Insert_YEAR_Case_Scenario1(id_Scenarios);


//  calcule Qualité de la supervision de la LBC
        Double Qualite_de_la_supervision_de_la_LBC = (ListCase.get(1).getValue_reponse() * ListCase.get(1).getWieghts() +
                (ListCase.get(2).getValue_reponse() * ListCase.get(2).getWieghts())) /
                (ListCase.get(1).getWieghts() + ListCase.get(2).getWieghts());
        Qualite_de_la_supervision_de_la_LBC = (double) Math.round(Qualite_de_la_supervision_de_la_LBC * 100) / 100;

        Double minNumber = Stream.of(ListCase.get(1).getPrerequisites(), ListCase.get(2).getPrerequisites(), Qualite_de_la_supervision_de_la_LBC)
                .min(Comparator.comparing(Double::valueOf))
                .get();



        ListCase.add(new Case("Qualité de la supervision de la LBC", minNumber, 99.0));
//   fin calcule Qualité de la supervision de la LBC


//        calcule Engagement et leadership des directions des banques

        Double Engagement_et_leadership_des_directions_des_banques =
                ((ListCase.get(3).getValue_reponse() * ListCase.get(3).getWieghts()) +
                        (ListCase.get(4).getValue_reponse() * ListCase.get(4).getWieghts()) +
                        (minNumber * 4)) /
                        (ListCase.get(3).getWieghts() + ListCase.get(4).getWieghts() + 4);


        Engagement_et_leadership_des_directions_des_banques = (double) Math.round(Engagement_et_leadership_des_directions_des_banques * 100) / 100;

        Double minNumber2 = Stream.of(ListCase.get(3).getPrerequisites(), ListCase.get(4).getPrerequisites(), Engagement_et_leadership_des_directions_des_banques, 99.00)
                .min(Comparator.comparing(Double::valueOf))
                .get();



        ListCase.add(new Case("Engagement et leadership des directions des banques", minNumber2, minNumber2));

        Double Disponibilite_et_application_de_sanctions_penales = ListCase.get(3).getValue_reponse();
        ListCase.add(new Case("Disponibilite et application de sanctions penales", Disponibilite_et_application_de_sanctions_penales, 0.99));
//   fin calcule Engagement et leadership des directions des banques
//
//        calcule Conformité du personnel des banques

        Double Conformite_du_personnel_des_banques =
                ((ListCase.get(5).getValue_reponse() * ListCase.get(5).getWieghts()) +
                        (ListCase.get(6).getValue_reponse() * ListCase.get(6).getWieghts()) +
                        (ListCase.get(7).getValue_reponse() * ListCase.get(7).getWieghts()) +
                        (Disponibilite_et_application_de_sanctions_penales * 1) ) /
                        (ListCase.get(5).getWieghts() + ListCase.get(6).getWieghts() + ListCase.get(7).getWieghts() + 1  );
        Conformite_du_personnel_des_banques = (double) Math.round(Conformite_du_personnel_des_banques * 100) / 100;

        Double minNumber3 = Stream.of(Conformite_du_personnel_des_banques, ListCase.get(5).getPrerequisites(), ListCase.get(6).getPrerequisites(), ListCase.get(7).getPrerequisites(),  99.00)
                .min(Comparator.comparing(Double::valueOf))
                .get();

        ListCase.add(new Case("Conformité du personnel des banques", minNumber3, minNumber3));
//   fin calcule Conformité du personnel des banques
//
//        calcule Qualité du cadre de CDD

        Double Qualite_du_cadre_de_CDD =

                ((ListCase.get(9).getValue_reponse() * ListCase.get(9).getWieghts()) +
                        (ListCase.get(10).getValue_reponse() * ListCase.get(10).getWieghts()) +
                        (ListCase.get(11).getValue_reponse() * ListCase.get(11).getWieghts())) /

                        (ListCase.get(10).getWieghts() + ListCase.get(11).getWieghts() + ListCase.get(9).getWieghts());

        Qualite_du_cadre_de_CDD = (double) Math.round(Qualite_du_cadre_de_CDD * 100) / 100;
        Double minNumber4 = Stream.of(ListCase.get(9).getPrerequisites(), ListCase.get(10).getPrerequisites(), ListCase.get(11).getPrerequisites(),  Qualite_du_cadre_de_CDD)
                .min(Comparator.comparing(Double::valueOf))
                .get();
        ListCase.add(new Case("Qualité du cadre de CDD", minNumber4, 99D));
        //   fin calcule Qualité du cadre de CDD

//         Qualité des opérations des banques


        Double Qualite_des_operations_des_banques =
                ((minNumber4) +
                        (ListCase.get(8).getValue_reponse() * ListCase.get(8).getWieghts()) +
                        ((minNumber3 * 3) +
                                (minNumber2 * 3))) / (7 + ListCase.get(8).getWieghts());

        Double minNumber5 = Stream.of(
                minNumber2,
                getPre(ListCase, "Qualité du cadre de CDD"),
                getPre(ListCase, "Conformité du personnel des banques"),
                Qualite_des_operations_des_banques,
                ListCase.get(8).getPrerequisites())
                .min(Comparator.comparing(Double::valueOf))
                .get();
        ListCase.add(new Case("Qualité des opérations des banques", minNumber5, 99D));


        //  fin  Qualité des opérations des banques


//  Qualité des politiques et procédures internes de LBC

        Double Qualite_des_politiques_et_procedures_internes_de_LBC =
                ((ListCase.get(0).getValue_reponse())
                        + (minNumber2) + (ListCase.get(7).getValue_reponse())) /
                        3;
        Double minNumber6 = Stream.of(minNumber5, (double) Math.round(Qualite_des_politiques_et_procedures_internes_de_LBC * 10000) / 10000)
                .min(Comparator.comparing(Double::valueOf))
                .get();
        ListCase.add(new Case("QUALITY OF GENERAL AML CONTROLS", minNumber6, 99D));

        return ListCase;
    }
    @Transactional
    public List<Case> Insert_YEAR_Case_Scenario1(Long id_Scenarios) {

        Map<String, Map<Double, Double>> map = new HashMap<>();


        List<Double> values;
        values = questionsResponsesScenariosRepository.getValue_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Integer> wieght;
        wieght = questionsResponsesScenariosRepository.getWeight_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Boolean> prerequisites;
        prerequisites = questionsResponsesScenariosRepository.getPREREQUISITES_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Case> ListCase = new ArrayList<>();

        for (int i = 0; i < getQeustion1().size(); i++) {

            Case aCase = new Case();
            aCase.setQuestion(getQeustion1().get(i));

            aCase.setValue_reponse(values.get(i));
            aCase.setWieghts(wieght.get(i).doubleValue());
            if (prerequisites.get(i)) {
                aCase.setPrerequisites(values.get(i));
            } else
                aCase.setPrerequisites(99.00);

            ListCase.add(aCase);


        }


        return ListCase;
    }
    @Transactional
    public List<Case> Insert_Other_Case_Scenario1(Long id_Scenarios) {

        List<Case> ListCase1 = YearCalcule1(id_Scenarios);

        List<Double> values = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            values.add(0.7);
        }


        List<Integer> wieght;
        wieght = questionsResponsesScenariosRepository.getWeight_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Boolean> prerequisites;
        prerequisites = questionsResponsesScenariosRepository.getPREREQUISITES_ENTRY_PAGE_TYPE(id_Scenarios);
        List<Case> ListCase = new ArrayList<>();

        for (int i = 0; i < getQeustion1().size(); i++) {

            Case aCase = new Case();
            aCase.setQuestion(getQeustion1().get(i));
            aCase.setValue_reponse(values.get(i));
            aCase.setWieghts(wieght.get(i).doubleValue());
            if (prerequisites.get(i)) {
                aCase.setPrerequisites(values.get(i));
            } else
                aCase.setPrerequisites(99.00);

            ListCase.add(aCase);


        }
/*
        map.put(Comprehensiveness_of_AML_Legal_Framework, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_and_Enforcement_of_Criminal_Sanctions, Collections.singletonMap(bestcase, Weights));
        map.put(Level_of_Market_Pressure_to_Meet_AML_Standards, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_and_Effectiveness_of_Entry_Controls, Collections.singletonMap(bestcase, Weights));
        map.put(Effectiveness_of_Supervision_Oversight_Activities, Collections.singletonMap(bestcase, bestcase));
        map.put(Availability_and_Enforcement_of_Administrative_Sanctions, Collections.singletonMap(bestcase, Weights));
        map.put(Integrity_of_Banks_Staff, Collections.singletonMap(bestcase, Weights));
        map.put(AML_Knowledge_of_Banks_Staff, Collections.singletonMap(bestcase, bestcase));
        map.put(Effectiveness_of_Compliance_Systems, Collections.singletonMap(bestcase, Weights));
        map.put(Effectiveness_of_Suspicious_Activity_Monitoring_and_Reporting, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_and_Access_to_Beneficial_Ownership_information, Collections.singletonMap(bestcase, Weights));
        map.put(Availability_of_Reliable_Identification_Infrastructure, Collections.singletonMap(bestcase, bestcase));
        map.put(Availability_of_Independent_Information_Sources, Collections.singletonMap(bestcase, Weights));
        map.put("Qualité du cadre de CDD", Collections.singletonMap(bestcase, Weights));
        map.put("Conformité du personnel des banques", Collections.singletonMap(bestcase, bestcase));
        map.put("Qualité de la supervision de la LBC", Collections.singletonMap(bestcase, bestcase));
        map.put("Disponibilité et application de sanctions pénales", Collections.singletonMap(bestcase, Weights));
        map.put("Engagement et leadership des directions des banques", Collections.singletonMap(bestcase, bestcase));
        map.put("Qualité des politiques et procédures internes de LBC", Collections.singletonMap(bestcase, bestcase));
        map.put("Qualité de la supervision de la LBC 2", Collections.singletonMap(bestcase, Weights));
        map.put("Engagement et leadership des directions des banques 2", Collections.singletonMap(bestcase, Weights));
        map.put("Efficacité de la fonction de conformité", Collections.singletonMap(bestcase, Weights));
        System.out.println(questionsResponsesScenariosRepository.findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(14L, Questions.Type.ENTRY_PAGE_TYPE).get(0).getResponses().getValue());
*/


        return ListCase;
    }
}
