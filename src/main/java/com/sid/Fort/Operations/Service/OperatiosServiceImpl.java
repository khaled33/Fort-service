package com.sid.Fort.Operations.Service;

import com.sid.Fort.Operations.Entity.Operations;
import com.sid.Fort.Operations.Dao.OperationsRepository;
import com.sid.Fort.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class OperatiosServiceImpl implements IOperatiosService {
    @Autowired
    private OperationsRepository operationsRepository;
    @Override
    public Operations getOperationsById(Long id) {
        try {
            return operationsRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    @Override
    public String getDesignationOpirationById(Long id) {
        return null;
    }

    @Override
    public List<Operations> getAllOperations(Long id_user) {
        return null;
    }


    @Override
    public Operations AddOperations(Operations operations) {
        return operationsRepository.save(operations);
    }

    @Override
    public Operations AddOperations(Operations operations, Long country_id, Long id_User, Long profession_id) {
        return null;
    }



    @Override
    public Operations UpdateOperations(Operations operations, Long id) {
        operations.setId(id);
        return operationsRepository.save(operations);
    }

    @Override
    public void DeleteOperations(Long id) {
        operationsRepository.deleteById(id);
    }
}
