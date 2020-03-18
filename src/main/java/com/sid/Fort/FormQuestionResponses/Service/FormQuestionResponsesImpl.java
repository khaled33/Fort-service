package com.sid.Fort.FormQuestionResponses.Service;

import com.sid.Fort.FormQuestionResponses.Dao.FormQuestionResponseRepository;
import com.sid.Fort.FormQuestionResponses.Dao.FormQuestionResponses;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@Qualifier("v1")
public class FormQuestionResponsesImpl implements IFormQuestionResponses {

    @Autowired
    private FormQuestionResponseRepository formQuestionResponseRepository;

    @Override
    public FormQuestionResponses getFormQuestionResponsesById(Long id) {
        try {
            return formQuestionResponseRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public List<FormQuestionResponses> getAllFormQuestionResponses() {
        return formQuestionResponseRepository.findAll();
    }

    @Override
    public FormQuestionResponses UpdateFormQuestionResponses(FormQuestionResponses frmQuestionResponses, Long id) {
        frmQuestionResponses.setId(id);
        return formQuestionResponseRepository.save(frmQuestionResponses);
    }

    @Override
    public FormQuestionResponses UpdateFormQuestionResponses(FormQuestionResponses frmQuestionResponses, Long id, Long id_responsesGroups) {
        return null;
    }

    @Override
    public void DeleteFormQuestionResponses(Long id) {
        formQuestionResponseRepository.deleteById(id);

    }

    @Override
    public FormQuestionResponses AddFormQuestionResponses(FormQuestionResponses formQuestionResponses) {
        return formQuestionResponseRepository.save(formQuestionResponses);
    }

    @Override
    public FormQuestionResponses AddFormQuestionResponses(FormQuestionResponses formQuestionResponses, Long id_responsesGroups) {
        return null;
    }
}
