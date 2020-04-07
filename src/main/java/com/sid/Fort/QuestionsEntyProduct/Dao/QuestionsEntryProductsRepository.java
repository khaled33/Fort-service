package com.sid.Fort.QuestionsEntyProduct.Dao;

import com.sid.Fort.QuestionsEntyProduct.Entity.QuestionsEntryProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsEntryProductsRepository extends JpaRepository<QuestionsEntryProducts,Long> {
    public List<QuestionsEntryProducts> findQuestionsEntryProductsBySecteurId(Long secteur_id);
}
