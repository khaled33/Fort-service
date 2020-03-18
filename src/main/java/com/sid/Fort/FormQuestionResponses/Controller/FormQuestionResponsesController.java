package com.sid.Fort.FormQuestionResponses.Controller;

import com.sid.Fort.FormQuestionResponses.Dao.FormQuestionResponses;
import com.sid.Fort.FormQuestionResponses.Service.IFormQuestionResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FormQuestionResponsesController {

    @Autowired
    @Qualifier("v2")
    private IFormQuestionResponses iFormQuestionResponses;

    @GetMapping("/FormQuestionResponse/{id}")
    public ResponseEntity<FormQuestionResponses> getFormQuestionResponsesById(@PathVariable Long id) {
        FormQuestionResponses result = iFormQuestionResponses.getFormQuestionResponsesById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("/FormQuestionResponses")
    public ResponseEntity<List<FormQuestionResponses>> getAllFormQuestionResponses() {
        List<FormQuestionResponses>result=iFormQuestionResponses.getAllFormQuestionResponses();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/FormQuestionResponse/ResponsesGroups/{id_responsesGroups}")
    public ResponseEntity<FormQuestionResponses> AddFormQuestionResponses(@RequestBody FormQuestionResponses formQuestionResponses,@PathVariable Long id_responsesGroups) {
        FormQuestionResponses result = iFormQuestionResponses.AddFormQuestionResponses(formQuestionResponses,id_responsesGroups);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PostMapping("/FormQuestionResponse")
    public ResponseEntity<FormQuestionResponses> AddFormQuestionResponses(@RequestBody FormQuestionResponses formQuestionResponses) {
        FormQuestionResponses result = iFormQuestionResponses.AddFormQuestionResponses(formQuestionResponses);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PutMapping("/FormQuestionResponse/{id}/ResponsesGroups/{id_responsesGroups}")
    public ResponseEntity<FormQuestionResponses> UpdateFormQuestionResponses(@RequestBody FormQuestionResponses frmQuestionResponses,@PathVariable Long id,@PathVariable Long id_responsesGroups) {
        frmQuestionResponses.setId(id);
        FormQuestionResponses result =iFormQuestionResponses.UpdateFormQuestionResponses(frmQuestionResponses, id,id_responsesGroups);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    @PutMapping("/FormQuestionResponse/{id}")
    public ResponseEntity<FormQuestionResponses> UpdateFormQuestionResponses(@RequestBody FormQuestionResponses frmQuestionResponses,@PathVariable Long id) {
        frmQuestionResponses.setId(id);
        FormQuestionResponses result =iFormQuestionResponses.UpdateFormQuestionResponses(frmQuestionResponses, id);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    @DeleteMapping("/FormQuestionResponse/{id}")
    public ResponseEntity<Void> DeleteFormQuestionResponses(@PathVariable Long id) {
        iFormQuestionResponses.DeleteFormQuestionResponses(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
