package com.sid.Fort.QuestionsEntryPage.Controller;

import com.sid.Fort.QuestionsEntryPage.Entity.Questions;
import com.sid.Fort.QuestionsEntryPage.Service.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionsController {
    @Autowired
    private IQuestionsService iQuestionsService;


    @GetMapping("/Question/{id}")
    public ResponseEntity<Questions> getQuestionsById(@PathVariable Long id) {
        return new ResponseEntity<>(iQuestionsService.getQuestionsById(id), HttpStatus.OK);
    }

    @GetMapping("/Questions/Secteur/{id_Secteur}/{type}/Scenario/{scenario_id}")
    public ResponseEntity<List<Questions>> getQuestionsBySecteurId(@PathVariable Long id_Secteur, @PathVariable String type, @PathVariable Long scenario_id) {
        return new ResponseEntity<>(iQuestionsService.getQuestionsBySecteurIdAndType(id_Secteur, Enum.valueOf(Questions.Type.class, type), scenario_id), HttpStatus.OK);
    }

    @GetMapping("/Questions/Secteur/{id_Secteur}/{type}/Scenarios/{scenario_id}")
    public ResponseEntity<List<Questions>> getQuestionsBySecteurIdAndTypeINTERMEDIATE(@PathVariable Long id_Secteur, @PathVariable String type, @PathVariable Long scenario_id) {
        return new ResponseEntity<>(iQuestionsService.getQuestionsBySecteurIdAndTypeINTERMEDIATE(id_Secteur, Enum.valueOf(Questions.Type.class, type), scenario_id), HttpStatus.OK);
    }

    @GetMapping("/Questions")
    public ResponseEntity<List<Questions>> getAllQuestions() {
        return new ResponseEntity<>(iQuestionsService.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping("/Question")
    public ResponseEntity<Questions> AddQuestions(@RequestBody Questions Questions) {
        return new ResponseEntity<>(iQuestionsService.AddQuestions(Questions), HttpStatus.CREATED);
    }

    @PutMapping("/Question/{id}")
    public ResponseEntity<Questions> UpdateQuestions(@RequestBody Questions Questions, @PathVariable Long id) {
        return new ResponseEntity<>(iQuestionsService.UpdateQuestions(Questions, id), HttpStatus.CREATED);

    }

    @DeleteMapping("/Question/{id}")
    public ResponseEntity<Void> DeleteQuestions(@PathVariable Long id) {
        iQuestionsService.DeleteQuestions(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/Question/{id_Secteur}/ResponsesGroups/{id_responsesGroups}")
    public Questions AddQuestionsid_Secteur(@RequestBody Questions Questions, @PathVariable Long id_Secteur,@PathVariable Long id_responsesGroups) {
        return iQuestionsService.AddQuestionsid_Secteur(Questions, id_Secteur,id_responsesGroups);
    }
}
