package com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Dao;

import com.sid.Fort.Products.Entity.Products;
import com.sid.Fort.QuestionsResponsesScenariosEntryProducts.Entity.QuestionsResponsesScenariosEntryProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsResponsesScenariosEntryProductsRepository extends JpaRepository<QuestionsResponsesScenariosEntryProducts,Long> {
public List<QuestionsResponsesScenariosEntryProducts> findAllQuestionsResponsesScenariosEntryProductsByScenariosId(Long id);
public List<QuestionsResponsesScenariosEntryProducts> findAllQuestionsResponsesScenariosEntryProductsByScenariosIdAndProductsId(Long id_senario,Long id_product);
public QuestionsResponsesScenariosEntryProducts findByQuestionsEntryProductsIdAndScenariosIdAndProductsId(Long id_question,Long id_senario,Long id_product);
    public List<QuestionsResponsesScenariosEntryProducts> findByQuestionsEntryProductsTypeAndScenariosIdAndProductsId(Enum Type,Long id_senario,Long id_product);

    void deleteByProductsId(Long id_product);

    @Query("SELECT DISTINCT products.id FROM #{#entityName}  WHERE scenario_id= ?1")
    List<Long> findIdProductbyIdSenario(Long scenario_id);

}
