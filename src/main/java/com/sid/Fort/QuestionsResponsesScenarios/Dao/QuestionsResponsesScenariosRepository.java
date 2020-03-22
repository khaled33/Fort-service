package com.sid.Fort.QuestionsResponsesScenarios.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsResponsesScenariosRepository extends JpaRepository<QuestionsResponsesScenarios,Long> {
    public List<QuestionsResponsesScenarios> findAllQuestionsResponsesScenariosByScenariosId(Long id);
    public List<QuestionsResponsesScenarios> findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(Long id_Question,Enum TYpe);
    public QuestionsResponsesScenarios findByQuestionsIdAndScenariosId(Long id_Question,Long Id_Scenarios);
    public QuestionsResponsesScenarios findByQuestionsIdAndScenariosIdAndProductsId(Long id_Question,Long Id_Scenarios,Long id_Products);

    public QuestionsResponsesScenarios findByQuestionsId(Long id_Question);
    public void deleteByScenariosId(Long id_senaros);

}
