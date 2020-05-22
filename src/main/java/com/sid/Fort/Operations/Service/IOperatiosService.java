package com.sid.Fort.Operations.Service;

import com.sid.Fort.Operations.Entity.Operations;

import java.util.List;

public interface IOperatiosService {

    public Operations getOperationsById(Long id);
    public String getDesignationOpirationById(Long id);
    public List<Operations> getAllOperations(Long id_user);
    public Operations AddOperations(Operations Operations);

    Operations AddOperations(Operations operations,
                             Long country_id,
                             Long id_User,
                             Long profession_id);

    public Operations UpdateOperations(Operations operations, Long id);
    public void DeleteOperations(Long id);
}
