package com.sid.Fort.Questions.Dao;

import com.sid.Fort.DnfbpsSectors.Dao.DnfbpsSectors;
import com.sid.Fort.ResponsesGroups.Dao.ResponsesGroups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    public List<Questions> findQuestionsBySecteurIdAndType(Long secteur_id, Enum type);
}
