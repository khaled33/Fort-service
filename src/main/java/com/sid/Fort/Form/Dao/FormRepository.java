package com.sid.Fort.Form.Dao;
import com.sid.Fort.Form.Entity.FormEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FormRepository extends MongoRepository <FormEntity,String> {
//    List<FormEntity> findByReponseEquals
    int countByTypeForm(String typeForm);
}
