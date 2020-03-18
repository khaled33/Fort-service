package com.sid.Fort.QuestionsResponsesScenarios.Service;

import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;

import java.util.List;

public interface QuestionsResponsesScenariosService {
    public QuestionsResponsesScenarios getQuestionsResponsesScenariosById(Long id);
    public List<QuestionsResponsesScenarios> getAllQuestionsResponsesScenarios();
    public List<QuestionsResponsesScenarios> getAllQuestionsResponsesScenariosByIdScenarios(Long id);
    public QuestionsResponsesScenarios AddQuestionsResponsesScenarios(QuestionsResponsesScenarios QuestionsResponsesScenarios,Long scenario_id,Long product_id);
    public QuestionsResponsesScenarios AddQuestionsResponsesScenarios(QuestionsResponsesScenarios QuestionsResponsesScenarios,Long scenario_id);

    List<QuestionsResponsesScenarios> AddQuestionsResponsesScenarios(List<QuestionsResponsesScenarios> QuestionsResponsesScenarios);

    public QuestionsResponsesScenarios UpdateQuestionsResponsesScenarios(QuestionsResponsesScenarios QuestionsResponsesScenarios, Long id);
    public void DeleteQuestionsResponsesScenarios(Long id);
}
