package com.sid.Fort.QuestionsEntyProduct.Service;

import com.sid.Fort.QuestionsEntyProduct.Entity.QuestionsEntryProducts;

import java.util.List;

public interface QuestionsEntryProductService {

    QuestionsEntryProducts getQuestionsEntryProduct(Long id);
     List<QuestionsEntryProducts> getAllQuestionsEntryProduct();
    QuestionsEntryProducts AddQuestionsEntryProduct(QuestionsEntryProducts questionsEntryProduct);
    QuestionsEntryProducts UpdateQuestionsEntryProduct(Long id,QuestionsEntryProducts questionsEntryProduct);
     void DeleteQuestionsEntryProduct(Long id);
     List<QuestionsEntryProducts> findQuestionsEntryProductsBySecteur(Long secteur_id,Long senario_id,Long product_id);




}

