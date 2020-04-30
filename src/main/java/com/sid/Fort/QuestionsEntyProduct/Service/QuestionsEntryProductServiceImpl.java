package com.sid.Fort.QuestionsEntyProduct.Service;

import com.sid.Fort.QuestionsEntyProduct.Dao.QuestionsEntryProductsRepository;
import com.sid.Fort.QuestionsEntyProduct.Entity.QuestionsEntryProducts;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Dao.QuestionsResponsesScenariosEntryProductsRepository;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Entity.QuestionsResponsesScenariosEntryProducts;
import com.sid.Fort.Responses.Entity.Responses;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionsEntryProductServiceImpl implements QuestionsEntryProductService {
    @Autowired
    private QuestionsEntryProductsRepository questionsEntryProductsRepository;
    @Autowired
    private QuestionsResponsesScenariosEntryProductsRepository questionsResponsesScenariosEntryProductsRepository;
    @Override
    public QuestionsEntryProducts getQuestionsEntryProduct(Long id) {
        try {
            return   questionsEntryProductsRepository.getOne(id);
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }

    }

    @Override
    public List<QuestionsEntryProducts> getAllQuestionsEntryProduct() {
        return questionsEntryProductsRepository.findAll();
    }

    @Override
    public QuestionsEntryProducts AddQuestionsEntryProduct(QuestionsEntryProducts questionsEntryProduct) {
        return questionsEntryProductsRepository.save(questionsEntryProduct);
    }

    @Override
    public QuestionsEntryProducts UpdateQuestionsEntryProduct(Long id, QuestionsEntryProducts questionsEntryProduct) {
        questionsEntryProduct.setId(id);
        return questionsEntryProductsRepository.save(questionsEntryProduct);
    }

    @Override
    public void DeleteQuestionsEntryProduct(Long id) {
        questionsEntryProductsRepository.deleteById(id);

    }

    @Override
    public List<QuestionsEntryProducts> findQuestionsEntryProductsBySecteur(Long secteur_id,Long senario_id,Long product_id) {
         List<Responses> responses;


        List<QuestionsEntryProducts> questionsEntryProducts=questionsEntryProductsRepository.findQuestionsEntryProductsBySecteurId(secteur_id);
        List<QuestionsEntryProducts> questionsEntryProducts1 = null;
        questionsEntryProducts.sort((l, r) -> l.getIndx().compareTo(r.getIndx()));

        for (QuestionsEntryProducts qs : questionsEntryProducts) {
            QuestionsResponsesScenariosEntryProducts questionsResponsesScenariosEntryProducts = questionsResponsesScenariosEntryProductsRepository.findByQuestionsEntryProductsIdAndScenariosIdAndProductsId(qs.getId(), senario_id,product_id);
            if (questionsResponsesScenariosEntryProducts != null)
                try {
                    qs.setRespSelected(questionsResponsesScenariosEntryProducts.getResponses().getId());

                }catch (NullPointerException ignored) {;}
            qs.getResponsesGroups().getResponses().sort((o1, o2) -> Double.compare(o1.getValue(), o2.getValue()));
        }

        return questionsEntryProducts;
    }
}
