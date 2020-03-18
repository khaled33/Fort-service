package com.sid.Fort.FormQuestionResponses.Service;

import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectors;
import com.sid.Fort.FormQuestionResponses.Dao.FormQuestionResponses;

import java.util.List;

public interface IFormQuestionResponses {
    public FormQuestionResponses getFormQuestionResponsesById(Long id);
    public List<FormQuestionResponses> getAllFormQuestionResponses();
    public FormQuestionResponses AddFormQuestionResponses(FormQuestionResponses formQuestionResponses);

    FormQuestionResponses AddFormQuestionResponses(FormQuestionResponses formQuestionResponses, Long id_responsesGroups);

    public FormQuestionResponses UpdateFormQuestionResponses(FormQuestionResponses frmQuestionResponses, Long id);

    FormQuestionResponses UpdateFormQuestionResponses(FormQuestionResponses frmQuestionResponses, Long id, Long id_responsesGroups);

    public void DeleteFormQuestionResponses(Long id);
}
