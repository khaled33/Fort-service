package com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao;

import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity.QuestionsResponsesScenariosEntryPage;
import com.sid.Fort.Scenarios.Entity.Scenarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsResponsesScenariosRepository extends JpaRepository<QuestionsResponsesScenariosEntryPage,Long> {
    public List<QuestionsResponsesScenariosEntryPage> findAllQuestionsResponsesScenariosByScenariosId(Long id);
    public List<QuestionsResponsesScenariosEntryPage> findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(Long id_Scenario, Enum TYpe);
    public QuestionsResponsesScenariosEntryPage findQuestionsResponsesScenariosByScenariosIdAndQuestionsTypeAndQuestionsIndx(Long id_Scenario, Enum TYpe, Integer Order);

    @Query("SELECT qrs.value FROM QuestionsResponsesScenariosEntryPage as qrs INNER JOIN QuestionsEntryPage as q ON qrs.questions = q.id AND q.indx=?1 AND q.type='INTERMEDIATE_VARIABLE_TYPE' AND qrs.scenarios=?2")
    public Double getQualityofGeneralAMLControls(Integer Order ,Scenarios id_Scenario);

    public QuestionsResponsesScenariosEntryPage findByQuestionsIdAndScenariosId(Long id_Question, Long Id_Scenarios);
    //public QuestionsResponsesScenariosEntryPage findByQuestionsIdAndScenariosIdAndProductsId(Long id_Question,Long Id_Scenarios,Long id_Products);

    public QuestionsResponsesScenariosEntryPage findByQuestionsId(Long id_Question);
    public void deleteByScenariosId(Long id_senaros);

}
