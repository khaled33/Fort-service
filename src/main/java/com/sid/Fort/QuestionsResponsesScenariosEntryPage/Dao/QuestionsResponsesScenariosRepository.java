package com.sid.Fort.QuestionsResponsesScenariosEntryPage.Dao;

import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity.QuestionsResponsesScenariosEntryPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsResponsesScenariosRepository extends JpaRepository<QuestionsResponsesScenariosEntryPage,Long> {
    public List<QuestionsResponsesScenariosEntryPage> findAllQuestionsResponsesScenariosByScenariosId(Long id);
    public List<QuestionsResponsesScenariosEntryPage> findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(Long id_Scenario, Enum TYpe);
    public QuestionsResponsesScenariosEntryPage findQuestionsResponsesScenariosByScenariosIdAndQuestionsTypeAndQuestionsIndx(Long id_Scenario, Enum TYpe, Integer Order);
    public QuestionsResponsesScenariosEntryPage findByQuestionsIdAndScenariosId(Long id_Question, Long Id_Scenarios);
    //public QuestionsResponsesScenariosEntryPage findByQuestionsIdAndScenariosIdAndProductsId(Long id_Question,Long Id_Scenarios,Long id_Products);

    public QuestionsResponsesScenariosEntryPage findByQuestionsId(Long id_Question);
    public void deleteByScenariosId(Long id_senaros);

}
