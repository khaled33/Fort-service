package com.sid.Fort.QuestionsResponsesScenarios.Controller;

import com.sid.Fort.Questions.Dao.Questions;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenarios;
import com.sid.Fort.QuestionsResponsesScenarios.Dao.QuestionsResponsesScenariosRepository;
import com.sid.Fort.QuestionsResponsesScenarios.Service.QuestionsResponsesScenariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class QuestionsResponsesScenariosController {

    @Autowired
    private QuestionsResponsesScenariosService questionsResponsesScenariosService;

    @Autowired
    private QuestionsResponsesScenariosRepository QuestionsResponsesScenariosRepository;

    @GetMapping("/QuestionsResponsesScenario/{id}")
    public ResponseEntity<QuestionsResponsesScenarios> getQuestionsResponsesScenariosById(@PathVariable Long id) {
        return new ResponseEntity<>(questionsResponsesScenariosService.getQuestionsResponsesScenariosById(id), HttpStatus.OK);
    }
    @GetMapping("/QuestionsResponsesScenarios")
    public ResponseEntity<List<QuestionsResponsesScenarios>> getAllQuestionsResponsesScenarios() {
        return new ResponseEntity<>(questionsResponsesScenariosService.getAllQuestionsResponsesScenarios(), HttpStatus.OK);

    }

    @PostMapping("/QuestionsResponsesScenario/scenario/{scenario_id}/product/{product_id}")
    public QuestionsResponsesScenarios AddQuestionsResponsesScenarios(@RequestBody QuestionsResponsesScenarios QuestionsResponsesScenarios,@PathVariable Long scenario_id,@PathVariable Long product_id) {
        return questionsResponsesScenariosService.AddQuestionsResponsesScenarios(QuestionsResponsesScenarios, scenario_id, product_id);
    }

    @PostMapping("/QuestionsResponsesScenario/scenario/{scenario_id}")
    public ResponseEntity< QuestionsResponsesScenarios> AddQuestionsResponsesScenarios(@RequestBody QuestionsResponsesScenarios QuestionsResponsesScenarios,@PathVariable Long scenario_id) {
     //   return questionsResponsesScenariosService.AddQuestionsResponsesScenarios(QuestionsResponsesScenarios, scenario_id);
        return new ResponseEntity<>(
                questionsResponsesScenariosService.AddQuestionsResponsesScenarios
                        (QuestionsResponsesScenarios, scenario_id), HttpStatus.CREATED);
    }

    @PostMapping("/QuestionsResponsesScenario")
    public ResponseEntity<List<QuestionsResponsesScenarios>> AddQuestionsResponsesScenarios(@RequestBody List<QuestionsResponsesScenarios> QuestionsResponsesScenarios) {
        return new ResponseEntity<>(questionsResponsesScenariosService.AddQuestionsResponsesScenarios
                (QuestionsResponsesScenarios), HttpStatus.CREATED);
    }

    @PutMapping("/QuestionsResponsesScenario/{id}")
    public ResponseEntity<QuestionsResponsesScenarios> UpdateQuestionsResponsesScenarios(@RequestBody QuestionsResponsesScenarios QuestionsResponsesScenarios,@PathVariable Long id) {
        return new ResponseEntity<>(
                questionsResponsesScenariosService.UpdateQuestionsResponsesScenarios
                        (QuestionsResponsesScenarios, id), HttpStatus.CREATED);
    }
    @DeleteMapping("/QuestionsResponsesScenario")
    public ResponseEntity<Void> DeleteQuestionsResponsesScenarios(Long id) {
        questionsResponsesScenariosService.DeleteQuestionsResponsesScenarios(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @GetMapping("/QuestionsResponsesScenario/Scenario/{id_Scenario}")
    public List<QuestionsResponsesScenarios> getAllQuestionsResponsesScenariosByIdScenarios(@PathVariable Long id_Scenario) {
        return questionsResponsesScenariosService.getAllQuestionsResponsesScenariosByIdScenarios(id_Scenario);
    }
    @GetMapping("/QuestionsResponsesScenario/Scenario/{id_Scenario}/Type/{type}")
    public List<QuestionsResponsesScenarios> findAllQuestionsResponsesScenariosByQuestionsType(@PathVariable Long id_Scenario,@PathVariable String type) {
        return QuestionsResponsesScenariosRepository.findAllQuestionsResponsesScenariosByScenariosIdAndQuestionsType(id_Scenario,Enum.valueOf(Questions.Type.class, type));
    }
}
