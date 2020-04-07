package com.sid.Fort.QuestionsEntryPage.Dao;

import com.sid.Fort.QuestionsEntryPage.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    public List<Questions> findQuestionsBySecteurIdAndType(Long secteur_id, Enum type);
}
