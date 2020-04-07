package com.sid.Fort.QuestionsWeights.Service;

import com.sid.Fort.QuestionsWeights.Entity.QuestionsWeights;
import com.sid.Fort.QuestionsWeights.Dao.QuestionsWeightsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class QuestionsWeightsServiceImpl implements QuestionsWeightsService {

    @Autowired
    QuestionsWeightsRepository questionsWeightsRepository;

    @Override
    public QuestionsWeights getQuestionsWeightsById(Long id) {

        try {
            return questionsWeightsRepository.getOne(id);
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }

    }

    @Override
    public List<QuestionsWeights> getAllQuestionsWeights() {
        return questionsWeightsRepository.findAll();
    }

    @Override
    public QuestionsWeights AddQuestionsWeights(QuestionsWeights QuestionsWeights) {
        return questionsWeightsRepository.save(QuestionsWeights);
    }

    @Override
    public QuestionsWeights UpdateQuestionsWeights(QuestionsWeights QuestionsWeights, Long id) {
        QuestionsWeights.setId(id);
        return questionsWeightsRepository.save(QuestionsWeights);
    }

    @Override
    public void DeleteQuestionsWeights(Long id) {
        questionsWeightsRepository.deleteById(id);
    }
}
