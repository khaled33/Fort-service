package com.sid.Fort.AnalyseOperation.ChatVulProduct.Dao;

import com.sid.Fort.AnalyseOperation.ChatVulProduct.Entity.ChatVulProduct;
import com.sid.Fort.Products.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatVulProductRepository extends JpaRepository<ChatVulProduct, Long> {
    List<ChatVulProduct> getByOperationOrderByProductsIdAsc(Long Id_Operation);

    ChatVulProduct getByProductsIdAndOperation(Long id_Product, Long id_Operation);

    @Query(value = "SELECT * FROM `chat_vul_product` WHERE id_scenario=?1 AND operation=?2 AND  products_id =?3 ORDER BY `chat_vul_product`.`products_id` ASC", nativeQuery = true)
    ChatVulProduct getByProductsIdAndOperation(Long id_scenario, Long id_Operation, Long id_Product);

    @Query(value = "SELECT * FROM `chat_vul_product` WHERE id_scenario=?2 AND operation=?1 ORDER BY `chat_vul_product`.`products_id` ASC", nativeQuery = true)
    List<ChatVulProduct> getByOperationAndProductsId(Long Id_Operation, Long id_scenario);

    @Query(value = "SELECT * FROM `chat_vul_product` WHERE id_scenario=?2 AND operation=?1 ORDER BY `chat_vul_product`.`vulnerabilite_finale` DESC", nativeQuery = true)
    List<ChatVulProduct> getByOperationAndProductsIdOrder(Long Id_Operation, Long id_scenario);

    void deleteByProductsId(Long id_Products);
}
