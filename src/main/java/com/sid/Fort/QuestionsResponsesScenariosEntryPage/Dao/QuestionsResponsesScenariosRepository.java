package com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao;

import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity.QuestionsResponsesScenariosEntryPage;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsResponsesScenariosRepository extends JpaRepository<QuestionsResponsesScenariosEntryPage,Long> {
    public List<QuestionsResponsesScenariosEntryPage> findAllQuestionsResponsesScenariosByScenariosId(Long id);
    public List<QuestionsResponsesScenariosEntryPage> findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(Long id_Scenario, Enum TYpe);
    public List<QuestionsResponsesScenariosEntryPage> findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsTypeOrderByQuestions(Long id_Scenario, Enum TYpe);
    public QuestionsResponsesScenariosEntryPage findQuestionsResponsesScenariosByScenariosIdAndQuestionsTypeAndQuestionsIndx(Long id_Scenario, Enum TYpe, Integer Order);

    @Query("SELECT qrs.value FROM QuestionsResponsesScenariosEntryPage as qrs INNER JOIN QuestionsEntryPage as q ON qrs.questions = q.id AND q.indx=?1 AND q.type='INTERMEDIATE_VARIABLE_TYPE' AND qrs.scenarios=?2")
    public Double getINTERMEDIATE_VARIABLE_TYPE(Integer Order ,Scenarios id_Scenario);

    @Query("SELECT qrs.value ,qrs.questions.text FROM QuestionsResponsesScenariosEntryPage as qrs INNER JOIN QuestionsEntryPage as q ON qrs.questions = q.id  AND q.type='ENTRY_PAGE_TYPE' AND qrs.scenarios.id=?1 ORDER BY qrs.questions")
    public List<Double> getValue_ENTRY_PAGE_TYPE(Long id_Scenario);


    @Query("SELECT  qrs.questions.questionsWeights.weight FROM QuestionsResponsesScenariosEntryPage as qrs INNER JOIN QuestionsEntryPage as q ON qrs.questions = q.id  AND q.type='ENTRY_PAGE_TYPE' AND qrs.scenarios.id=?1 ORDER BY qrs.questions")
    public List<Integer> getWeight_ENTRY_PAGE_TYPE(Long id_Scenario);

    @Query("SELECT  qrs.questions.questionsWeights.prerequisite FROM QuestionsResponsesScenariosEntryPage as qrs INNER JOIN QuestionsEntryPage as q ON qrs.questions = q.id  AND q.type='ENTRY_PAGE_TYPE' AND qrs.scenarios.id=?1 ORDER BY qrs.questions")
    public List<Boolean> getPREREQUISITES_ENTRY_PAGE_TYPE(Long id_Scenario);

    public QuestionsResponsesScenariosEntryPage findByQuestionsIdAndScenariosId(Long id_Question, Long Id_Scenarios);

    public QuestionsResponsesScenariosEntryPage findByQuestionsId(Long id_Question);
    public void deleteByScenariosId(Long id_senaros);

 }
