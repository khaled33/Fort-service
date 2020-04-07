package com.sid.Fort.QuestionsWeights.Controller;

import com.sid.Fort.QuestionsWeights.Entity.QuestionsWeights;
import com.sid.Fort.QuestionsWeights.Service.QuestionsWeightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionsWeightsController {
    @Autowired
    QuestionsWeightsService questionsWeightsService;

    @GetMapping("/QuestionsWeight/{id}")
    public QuestionsWeights getQuestionsWeightsById(@PathVariable Long id) {
        return questionsWeightsService.getQuestionsWeightsById(id);
    }

    @GetMapping("/QuestionsWeights")
    public List<QuestionsWeights> getAllQuestionsWeights() {
        return questionsWeightsService.getAllQuestionsWeights();
    }

    @PostMapping("/QuestionsWeight")
    public QuestionsWeights AddQuestionsWeights(@RequestBody QuestionsWeights QuestionsWeights) {
        return questionsWeightsService.AddQuestionsWeights(QuestionsWeights);
    }

    @PutMapping("/QuestionsWeight/{id}")
    public QuestionsWeights UpdateQuestionsWeights(@RequestBody QuestionsWeights QuestionsWeights, @PathVariable Long id) {
        return questionsWeightsService.UpdateQuestionsWeights(QuestionsWeights, id);
    }

    @DeleteMapping("/QuestionsWeight/{id}")
    public void DeleteQuestionsWeights(@PathVariable Long id) {
        questionsWeightsService.DeleteQuestionsWeights(id);
    }
}
