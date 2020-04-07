package com.sid.Fort.QuestionsResponsesScenariosEntryPage.Service;

import com.sid.Fort.QuestionsResponsesScenariosEntryPage.Entity.QuestionsResponsesScenariosEntryPage;

import java.util.List;

public interface QuestionsResponsesScenariosService {
    public QuestionsResponsesScenariosEntryPage getQuestionsResponsesScenariosById(Long id);
    public List<QuestionsResponsesScenariosEntryPage> getAllQuestionsResponsesScenarios();
    public List<QuestionsResponsesScenariosEntryPage> getAllQuestionsResponsesScenariosByIdScenarios(Long id);
    public QuestionsResponsesScenariosEntryPage AddQuestionsResponsesScenarios(QuestionsResponsesScenariosEntryPage QuestionsResponsesScenarios, Long scenario_id, Long product_id);
    public QuestionsResponsesScenariosEntryPage AddQuestionsResponsesScenarios(QuestionsResponsesScenariosEntryPage QuestionsResponsesScenarios, Long scenario_id);

    List<QuestionsResponsesScenariosEntryPage> AddQuestionsResponsesScenarios(List<QuestionsResponsesScenariosEntryPage> QuestionsResponsesScenarios);

    public QuestionsResponsesScenariosEntryPage UpdateQuestionsResponsesScenarios(QuestionsResponsesScenariosEntryPage QuestionsResponsesScenarios, Long id);
    public void DeleteQuestionsResponsesScenarios(Long id);
}
