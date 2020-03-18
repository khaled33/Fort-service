package com.sid.Fort.Questions.Service;

import com.sid.Fort.Questions.Dao.Questions;

import java.util.List;

public interface IQuestionsService {
    public Questions getQuestionsById(Long id);
    public List<Questions> getQuestionsBySecteurIdAndType(Long id_Secteur, Enum Type,Long scenario_id);
    public List<Questions> getAllQuestions();
    public Questions AddQuestions(Questions Questions);
    public Questions AddQuestionsid_Secteur(Questions Questions,Long id_Secteur);
    public Questions UpdateQuestions(Questions Questions,Long id);
    public void DeleteQuestions(Long id);
}
