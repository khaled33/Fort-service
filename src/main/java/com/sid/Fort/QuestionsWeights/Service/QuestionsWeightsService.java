package com.sid.Fort.QuestionsWeights.Service;

import com.sid.Fort.QuestionsWeights.Dao.QuestionsWeights;

import java.util.List;

public interface QuestionsWeightsService {
    public QuestionsWeights getQuestionsWeightsById(Long id);
    public List<QuestionsWeights> getAllQuestionsWeights();
    public QuestionsWeights AddQuestionsWeights(QuestionsWeights QuestionsWeights);
    public QuestionsWeights UpdateQuestionsWeights(QuestionsWeights QuestionsWeights,Long id);
    public void DeleteQuestionsWeights(Long id);
}
